package com.idsspl.webproject.config;

import java.time.Duration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.idsspl.webproject.serviceImpl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserServiceImpl();
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {

	    return builder.setConnectTimeout(Duration.ofMillis(300000))
	     .setReadTimeout(Duration.ofMillis(300000)).build();
	}

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/bootstrap/**", "/script/**", "/style/**", "/images/**", "/login")
//				.permitAll()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//				.loginPage("/login")
//				.usernameParameter("userName")
//				.passwordParameter("password")
//				.defaultSuccessUrl("/home", true)
//				.permitAll()
//				.and()
//				.logout()
//				.logoutSuccessUrl("/")
//				.invalidateHttpSession(true)
//				.deleteCookies("JSESSIONID")
//				.permitAll()
//				.and()
////		        .csrf()
////		        .disable();
////                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
////                .invalidSessionUrl("/login?timeout")
////                .sessionFixation().newSession()
//		.sessionManagement()
//                .maximumSessions(1)
//                .expiredUrl("/login?expired")
//                .maxSessionsPreventsLogin(false);
//	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	    http
//	        .authorizeRequests()
//	            .antMatchers("/bootstrap/**", "/script/**", "/style/**", "/images/**", "/login")
//	                .permitAll()
//	                .anyRequest().authenticated()
//	                .and()
//	        .formLogin()
//	            .loginPage("/login")
//	            .usernameParameter("userName")
//	            .passwordParameter("password")
//	            .defaultSuccessUrl("/home", true)
//	            .permitAll()
//	            .and()
//	        .logout()
//	            .logoutSuccessUrl("/")
//	            .invalidateHttpSession(true)
//	            .deleteCookies("JSESSIONID")
//	            .permitAll()
//	            .and()
//	        .sessionManagement()
//	            .maximumSessions(1)
//	            .expiredUrl("/login?expired")
//	            .maxSessionsPreventsLogin(false)
//	            .and()
//	        .and()
//	        .csrf()
//	            .disable()
//	        .headers()
//	            .frameOptions()
//	            .disable();
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .antMatchers("/bootstrap/**", "/script/**", "/style/**", "/images/**", "/login")
	                .permitAll()
	                .anyRequest().authenticated()
	                .and()
	        .formLogin()
	            .loginPage("/login")
	            .usernameParameter("userName")
	            .passwordParameter("password")
	            .defaultSuccessUrl("/home", true)
	            .permitAll()
	            .and()
	        .logout()
	            .logoutSuccessUrl("/")
	            .invalidateHttpSession(true)
	            .deleteCookies("JSESSIONID")
	            .permitAll()
	            .and()
	        .sessionManagement()
	            .maximumSessions(1)
	            .expiredUrl("/login?expired")
	            .maxSessionsPreventsLogin(false)
	            .and()
//	            .invalidSessionUrl("/login?expired")
	            .invalidSessionUrl("/login?timeout")
	            .sessionFixation()
	                .none()
	            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
	            .maximumSessions(1)
	                .expiredUrl("/login?expired")
	                .maxSessionsPreventsLogin(false)
	                .sessionRegistry(sessionRegistry())
	                .and()
	        .and()
	        .csrf()
	            .disable()
	        .headers()
	            .frameOptions()
	            .disable();
	}

	@Bean
	public SessionRegistry sessionRegistry() {
	    return new SessionRegistryImpl();
	}

	
	@Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
	
	@Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisherRegistration() {
        return new ServletListenerRegistrationBean<>(httpSessionEventPublisher());
    }
	
//	@Bean
//    public SessionRegistry sessionRegistry() {
//        return new SessionRegistryImpl();
//    }
	
	@Bean
    public ServletListenerRegistrationBean<HttpSessionListener> httpSessionListener() {
        return new ServletListenerRegistrationBean<>(new HttpSessionListener() {
            @Override
            public void sessionDestroyed(HttpSessionEvent se) {
                sessionRegistry().removeSessionInformation(se.getSession().getId());
            }
        });
    }
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/bootstrap/**", "/script/**", "/style/**", "/images/**", "/login")
//				.permitAll()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//				.loginPage("/login")
//				.usernameParameter("userName")
//				.passwordParameter("password")
//				.defaultSuccessUrl("/home", true)
//				.permitAll()
//				.and()
//				.logout()
//				.logoutSuccessUrl("/")
//				.invalidateHttpSession(true)
//				.deleteCookies("JSESSIONID")
//				.permitAll()
//				.and()
//				.sessionManagement()
//		        .maximumSessions(1);
//	}

//	@Override
//	protected void configure(final HttpSecurity http) throws Exception {
//
//		//@formatter:off
//	    http.authorizeRequests()
////	        .antMatchers("/login").hasRole("USER")    //.antMatchers("/login").permitAll()
////	    	.antMatchers("/login").anonymous()
//	    	.antMatchers("/bootstrap/**", "/script/**","/style/**","/images/**", "/login").permitAll()
////	    	.antMatchers("/*").authenticated()
////	        .anyRequest().authenticated()	
//	    	.and()
//	          .formLogin()
//	          .loginPage("/login")
//	          .usernameParameter("userName")
//	          .passwordParameter("password")
//	          .loginProcessingUrl("/")
////	          .defaultSuccessUrl("/home")
//	          .defaultSuccessUrl("/home", true)
//	          .failureUrl("/login")
//	          .permitAll()
//	        .and()
//	          .logout()
//	          .logoutSuccessUrl("/")
//	          .invalidateHttpSession(true)
//	          .deleteCookies("JSESSIONID")
//	          .permitAll()
//	        .and()
//	          .csrf()
//	          .disable();
//	    //@formatter:on
//	}
}
