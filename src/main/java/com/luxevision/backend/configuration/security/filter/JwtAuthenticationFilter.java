package com.luxevision.backend.configuration.security.filter;

import com.luxevision.backend.service.TokenService;
import com.luxevision.backend.service.auth.JwtService;
import com.luxevision.backend.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService userService;
    private final TokenService tokenService;

    @Autowired
    public JwtAuthenticationFilter(JwtService jwtService, UserService userService, TokenService tokenService) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String token = resolveToken(request);

        try {
            if (token != null && jwtService.validateToken(token)) {
                if (tokenService.isTokenRevoked(token)) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token has been revoked");
                    return;
                }

                String email = jwtService.extractEmail(token);
                UserDetails userDetails = userService.loadUserByEmail(email);

                if (userDetails != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception ex) {

            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed: " + ex.getMessage());
            return;
        }

        chain.doFilter(request, response);
    }


    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}