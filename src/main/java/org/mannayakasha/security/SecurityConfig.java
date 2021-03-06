package org.mannayakasha.security;

import org.mannayakasha.security.jwt.JWTConfigurer;
import org.mannayakasha.security.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;

    public SecurityConfig(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .csrf()
                .disable()
                .cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //.httpBasic() // optional, if you want to access
                //  .and()     // the services from a browser
                .authorizeRequests()
                .antMatchers("/signup").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/authenticate").permitAll()

                .antMatchers("/public").permitAll()
                .antMatchers("/product/**").permitAll()
				.antMatchers("/user/**").permitAll()
				.antMatchers("/order/**").permitAll()
				.antMatchers("/orderItem/**").permitAll()
				.antMatchers("/shipmentInformation/**").permitAll()
				.antMatchers("/payment/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new JWTConfigurer(this.tokenProvider));
        // @formatter:on
    }

}