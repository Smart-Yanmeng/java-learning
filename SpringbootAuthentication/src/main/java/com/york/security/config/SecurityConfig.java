package com.york.security.config;

import com.york.security.jwt.AuthEntryPointJwt;
import com.york.security.jwt.AuthTokenFilter;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Resource
    DataSource dataSource;

    @Resource
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {

        return new AuthTokenFilter();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests((requests) ->
                requests
                        .requestMatchers("/sign-in").permitAll()
                        .anyRequest().authenticated());
        http.sessionManagement(session ->
                session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler));
//        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        http.headers(headers ->
                headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails user1 = User.withUsername("user1")
//                .password(passwordEncoder().encode("password1"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("password2"))
//                .roles("ADMIN")
//                .build();
//
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        if (!userDetailsManager.userExists(user1.getUsername())) {
//            userDetailsManager.createUser(user1);
//        }
//        if (!userDetailsManager.userExists(admin.getUsername())) {
//            userDetailsManager.createUser(admin);
//        }
//
//        return userDetailsManager;
//        // return new InMemoryUserDetailsManager(user1, admin);
//    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public CommandLineRunner initData(UserDetailsService userDetailsService) {
        return args -> {
            JdbcUserDetailsManager manager = (JdbcUserDetailsManager) userDetailsService;

            UserDetails user1 = User.withUsername("user1")
                    .password(passwordEncoder().encode("password1"))
                    .roles("USER")
                    .build();
            UserDetails admin = User.withUsername("admin")
                    .password(passwordEncoder().encode("password2"))
                    .roles("ADMIN")
                    .build();

            JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

            if (!userDetailsManager.userExists(user1.getUsername())) {
                userDetailsManager.createUser(user1);
            }
            if (!userDetailsManager.userExists(admin.getUsername())) {
                userDetailsManager.createUser(admin);
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
