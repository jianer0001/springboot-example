package com.jianer.springbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 杨兴健
 * @Date 2020/4/17 21:19
 */
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 角色继承
     * @return
     */
    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_admin > ROLE_user");
        return roleHierarchy;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("admin").and()
                .withUser("user").password("user").roles("user").and()
                .withUser("jianer").password("jianer").roles("base");

    }

    /*
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password("user").roles("user").build());
        manager.createUser(User.withUsername("admin").password("admin").roles("admin").build());
        return manager;
    }
    */

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers("/js/**","/images/**","/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated().and()
                .formLogin()
                    .loginPage("/login.html")
                    .loginProcessingUrl("/doLogin")
                    .defaultSuccessUrl("/success")
                    .failureForwardUrl("/f1")
    //                .failureUrl("/f2")
                    .permitAll().and()
                .logout()
                    .logoutUrl("/logout")       //注销url
    //                .logoutRequestMatcher(new AntPathRequestMatcher("/zx","POST"))
                    .logoutSuccessUrl("/logout1")
                    .deleteCookies()            //清除cookie
                    .clearAuthentication(true)  //清除认证信息  默认true
                    .invalidateHttpSession(true)  //使httpSession失效 默认true
                    .permitAll().and()
                .csrf().disable();
    }
}
