package sia.tacocloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

/**
 * @author sayCode
 * @date 2023/3/1 18:55
 * @project taco-cloud
 * @Title SecurityConfig
 * @description TODO
 * @deprecated 由于在新版本中WebSecurityConfigurerAdapter中被弃用，故舍弃该类的相关操作，新的代码在类SecurityConfiguration中
 */
// @Deprecated
// @Configuration
// @EnableWebSecurity
// public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    // private final UserDetailsService userDetailsService;
    // DataSource dataSource;
    //
    // @Autowired
    // public SecurityConfig(UserDetailsService userDetailsService) {
    //     this.userDetailsService = userDetailsService;
    // }
    //
    //
    // // public SecurityConfig(DataSource dataSource) {
    // //     this.dataSource = dataSource;
    // // }
    //
    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     //基于内存的用户存储
    //     // auth
    //     //         .inMemoryAuthentication()
    //     //         .withUser("buzz")
    //     //         .password("123456")
    //     //         .authorities("ROLE_USER")
    //     //         .and()
    //     //         .withUser("woody")
    //     //         .password("123456")
    //     //         .authorities("ROLE_USER");
    //
    //     //基于JDBC的用户存储
    //     // auth
    //     //         .jdbcAuthentication()
    //     //         .dataSource(dataSource)
    //     //         .usersByUsernameQuery(
    //     //                 "select username, password, enabled from User" +
    //     //                         "where username=?"
    //     //         )
    //     //         .authoritiesByUsernameQuery(
    //     //                 "select username, authority from UserAuthorities" +
    //     //                         "where username=?"
    //     //         ).passwordEncoder(new StandardPasswordEncoder("53cr3t"));
    //
    //     //基于LDAP作为后端的用户存储
    //     // auth.ldapAuthentication()
    //     //         .userSearchBase("ou=people")
    //     //         .userSearchFilter("({uid={0})")
    //     //         .groupSearchBase("ou=groups")
    //     //         .groupSearchFilter("member={0}")
    //     //         .passwordCompare()
    //     //         .passwordEncoder(new BCryptPasswordEncoder())
    //     //         .passwordAttribute("passcode")
    //     //         .and()
    //     //         .contextSource()
    //     //         .root("dc=tacocloud,dc=com");
    //
    //     //自定义用户认证
    //
    //     // auth
    //     //         .userDetailsService(userDetailsService)
    //     //         .passwordEncoder(encoder());
    // }
    //
    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //             //基于该方法返回的对象我们可以指定URL路径和这些路径的安全需求
    //             .authorizeRequests()
    //             //具备“ROLE_USER”权限才能访问这两个页面
    //             .antMatchers("/design", "/orders")
    //             .hasRole("USER")
    //             //其他的请求允许所有用户访问
    //             .antMatchers("/","/**").permitAll()
    //
    //             .and()
    //             .formLogin()
    //             .loginPage("/login")
    //             //设置true参数后，即便用户在登陆之前正在访问其他页面，在登陆之后也会被定向到页面“design”
    //             .defaultSuccessUrl("/design", true)
    //
    //             .and()
    //             .logout()
    //             .logoutSuccessUrl("/");
    //
    //     // http.csrf().disable()
    //     //         .authorizeRequests().anyRequest().permitAll();
    // }
    //
    // @Bean
    // public PasswordEncoder encoder(){
    //     return new StandardPasswordEncoder("53cr3t");
    // }
// }
