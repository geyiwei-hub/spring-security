package com.antherd.securitydemo.service;

import com.antherd.securitydemo.entity.Users;
import com.antherd.securitydemo.mapper.UsersMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private UsersMapper usersMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // 调用usersMapper方法，根据用户名查询数据库
    QueryWrapper<Users> wrapper = new QueryWrapper<>();
    // where username = ?
    wrapper.eq("username", username);
    Users users = usersMapper.selectOne(wrapper);
    // 判断
    if (users == null) { // 数据库没有用户名， 认证失败
      throw new UsernameNotFoundException("用户名不存在！");
    }
    List<GrantedAuthority> auths =
//        AuthorityUtils.commaSeparatedStringToAuthorityList("admins"); // 将admins改成123，返回登录访问403
//        AuthorityUtils.commaSeparatedStringToAuthorityList("admins, ROLE_sale"); // 角色权限需要加上"ROLE_"前缀
        AuthorityUtils.commaSeparatedStringToAuthorityList("admins, ROLE_admin, ROLE_sale");
    // 从查询数据库返回users对象，得到用户名和密码，返回
    return new User(users.getUsername(), new BCryptPasswordEncoder().encode(users.getPassword()), auths);
  }
}
