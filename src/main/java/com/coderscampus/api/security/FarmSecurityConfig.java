package com.coderscampus.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import com.coderscampus.api.security.jwt.JwtAuthenticationFilter;
import com.coderscampus.api.security.jwt.UnauthorizedHandler;

@Configuration
@EnableWebSecurity
public class FarmSecurityConfig {

	@Autowired
	FarmUserDetailsService detailsService;

	@Autowired
	JwtAuthenticationFilter authenticationFilter;

	@Autowired
	UnauthorizedHandler unauthorizedHandler;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {
		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
		http.csrf().disable()
		.cors()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.exceptionHandling()
				.authenticationEntryPoint(unauthorizedHandler)
				.and()
				.securityMatcher("/**")	
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/login", "/get-details", "/send-details", "/logged", "/register",
								"/get-farmer-details", "/update-user", "/contact")
						.permitAll()
						.requestMatchers("/admin-dashboard").hasRole("ADMIN").
						anyRequest().authenticated())

				.logout() // This is where you configure logout
				.logoutUrl("/logout") // URL to trigger logout
				.logoutSuccessUrl("/login") // Redirect to this page after successful logout
				.invalidateHttpSession(true) // Invalidate session
				.deleteCookies("JSESSIONID"); // Remove cookies

		return http.build();

	}
//    @Bean
//    public AuthenticationEntryPoint authenticationEntryPoint(){
//        BasicAuthenticationEntryPoint entryPoint = 
//          new BasicAuthenticationEntryPoint();
//        entryPoint.setRealmName("admin realm");
//        return entryPoint;
//    }

//    @Bean
//	 public AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(detailsService);
//		authenticationProvider.setPasswordEncoder(passwordEncoder());
//	
//		return authenticationProvider;
//	}

	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(detailsService)
				.passwordEncoder(passwordEncoder())

				.and()

				.build();
	}

}
