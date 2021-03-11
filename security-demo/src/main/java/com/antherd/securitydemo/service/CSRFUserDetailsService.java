package com.antherd.securitydemo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CSRFUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    List<SimpleGrantedAuthority> list = new ArrayList<>();
    list.add(new SimpleGrantedAuthority("role"));
    UserDetails userDetails = new User("lucy", new BCryptPasswordEncoder().encode("123"),
        list);
    return userDetails;
  }
}
