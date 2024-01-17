//package com.easy.learn.configure;
//
//import com.easy.learn.service.CustomManagerDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.sql.DataSource;
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    public UserDetailsService userDetailsService() {
//        return new CustomManagerDetailService();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.authenticationProvider(authenticationProvider());
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .usernameParameter("username")
//                .defaultSuccessUrl("/admin")
//                .permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/").permitAll();
//    }
//}
