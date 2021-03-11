package com.antherd.securitydemo.config;

import java.beans.PersistenceDelegate;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

//@Configuration
public class SecurityConfigTest extends WebSecurityConfigurerAdapter {
//
//  @Autowired
//  private UserDetailsService userDetailsService;
//
//  // 注入数据源
//  @Autowired
//  private DataSource dataSource;
//
//  @Bean
//  public PersistentTokenRepository persistentTokenRepository() {
//    JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
//    jdbcTokenRepository.setDataSource(dataSource);
////    jdbcTokenRepository.setCreateTableOnStartup(true); // 自动创建表
//    return jdbcTokenRepository;
//  }
//
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(userDetailsService).passwordEncoder(password());
//  }
//
//  // PasswordEncoder: 配置密码加密类，否则运行报错 There is no PasswordEncoder mapped for the id "null"
//  @Bean
//  PasswordEncoder password() {
//    return new BCryptPasswordEncoder();
//  }
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    // 退出
//    http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();
//
//    // 配置没有权限访问跳转自定义页面
//    http.exceptionHandling().accessDeniedPage("/unauth.html");
//
//    http.formLogin() // 自定义自己编写的登录页面
//        .loginPage("/login.html") // 登录页面设置
//        .loginProcessingUrl("/user/login") //登录访问路径
//        .defaultSuccessUrl("/success.html").permitAll() // 登录成功后，跳转路径
//        .and().authorizeRequests() //
//          .antMatchers("/", "/test/hello", "/user/login").permitAll() // 设置哪些路径可以直接访问，不需要认证
//          // 当前登录用户，只有具有admins权限才可以访问这个路径
////          1、hasAuthority
////          .antMatchers("/test/index").hasAuthority("admins")
////          2、hasAnyAuthority
////          .antMatchers("/test/index").hasAnyAuthority("admins, manager")
////          3、hasRole, ROLE_sale
////          .antMatchers("/test/index").hasRole("sale")
////          4、hasAnyRole
//            .antMatchers("/test/index").hasAnyRole("sale")
//        .anyRequest().authenticated()
//        .and().rememberMe().tokenRepository(persistentTokenRepository())
//        .tokenValiditySeconds(60) // 设置有效时长，单位秒
//        .userDetailsService(userDetailsService);
////        .and().csrf().disable(); // 关闭csrf防护
//  }
}
