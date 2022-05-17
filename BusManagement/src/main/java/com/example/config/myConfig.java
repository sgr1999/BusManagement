package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@ComponentScan("com.baeldung.security")
public class myConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());

	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// http.authorizeRequests().antMatchers("/user/**").fullyAuthenticated()
		// .antMatchers("/**").permitAll().and().csrf().disable();

		http.authorizeRequests().antMatchers("/user/**").hasRole("USER")
		.antMatchers("/**").permitAll().and()
		.formLogin().loginPage("/signin")
		.loginProcessingUrl("/dologin")
		.defaultSuccessUrl("/user/index")
		.and().csrf().disable();

		// http.authorizeRequests().antMatchers("/user/**").hasRole("USER")
		// .antMatchers("/**").permitAll().and().formLogin().and().csrf().disable();

		// http.csrf().disable()
		// .authorizeRequests()
		// .antMatchers("/user/**")
		// .permitAll()
		// .anyRequest().authenticated().and().httpBasic();

		//  http.csrf().disable()
		// .authorizeRequests()
		// .antMatchers("/user/**").hasRole("USER")
		// .antMatchers("/**").permitAll().anyRequest().authenticated()
		// .and()
		// .httpBasic();
	}
}
