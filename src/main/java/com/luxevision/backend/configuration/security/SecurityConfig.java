package com.luxevision.backend.configuration.security;

import com.luxevision.backend.configuration.security.filter.JwtAuthenticationFilter;
import com.luxevision.backend.entity.util.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthenticationProvider daoAuthProvider;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(daoAuthProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests( auth -> {

                    auth.requestMatchers(HttpMethod.POST, "/users/register").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/users/login").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/users/logout").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/studios").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/studios/random").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/studios/{id}").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/specialties").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/specialties/{id}").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/features").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/features/{id}").permitAll();

                    auth.requestMatchers(HttpMethod.GET, "/users/profile").hasAuthority(RolePermission.READ_MY_PROFILE.name());
                    auth.requestMatchers(HttpMethod.PUT, "/users/self").hasAuthority(RolePermission.UPDATE_MY_PROFILE.name());

                    auth.requestMatchers(HttpMethod.POST, "/studios").hasAuthority(RolePermission.CREATE_ONE_STUDIO.name());
                    auth.requestMatchers(HttpMethod.PUT, "/studios").hasAuthority(RolePermission.UPDATE_ONE_STUDIO.name());
                    auth.requestMatchers(HttpMethod.DELETE, "/studios/{id}").hasAuthority(RolePermission.DELETE_ONE_STUDIO.name());
                    auth.requestMatchers(HttpMethod.POST, "/specialties").hasAuthority(RolePermission.CREATE_ONE_SPECIALTY.name());
                    auth.requestMatchers(HttpMethod.PUT, "/specialties").hasAuthority(RolePermission.UPDATE_ONE_SPECIALTY.name());
                    auth.requestMatchers(HttpMethod.DELETE, "/specialties/{id}").hasAuthority(RolePermission.DELETE_ONE_SPECIALTY.name());
                    auth.requestMatchers(HttpMethod.POST, "/features").hasAuthority(RolePermission.CREATE_ONE_FEATURE.name());
                    auth.requestMatchers(HttpMethod.PUT, "/features").hasAuthority(RolePermission.UPDATE_ONE_FEATURE.name());
                    auth.requestMatchers(HttpMethod.DELETE, "/features/{id}").hasAuthority(RolePermission.DELETE_ONE_FEATURE.name());
                    auth.requestMatchers(HttpMethod.GET, "/users").hasAuthority(RolePermission.READ_ALL_USERS.name());
                    auth.requestMatchers(HttpMethod.GET, "/users/{id}").hasAuthority(RolePermission.READ_ONE_USER.name());
                    auth.requestMatchers(HttpMethod.PUT, "/users").hasAuthority(RolePermission.UPDATE_ONE_USER.name());
                    auth.requestMatchers(HttpMethod.DELETE, "/users/{id}").hasAuthority(RolePermission.DELETE_ONE_USER.name());
                    auth.requestMatchers(HttpMethod.PUT, "/users/{id}/promote").hasAuthority(RolePermission.ASSIGN_ROLE_ADMINISTRATOR.name());
                    auth.requestMatchers(HttpMethod.PUT, "/users/{id}/demote").hasAuthority(RolePermission.REVOKE_ROLE_ADMINISTRATOR.name());

                    auth.anyRequest().authenticated();

                });

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:5173");
        configuration.addAllowedMethod(HttpMethod.GET);
        configuration.addAllowedMethod(HttpMethod.POST);
        configuration.addAllowedMethod(HttpMethod.PUT);
        configuration.addAllowedMethod(HttpMethod.DELETE);
        configuration.addAllowedMethod(HttpMethod.OPTIONS);
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}