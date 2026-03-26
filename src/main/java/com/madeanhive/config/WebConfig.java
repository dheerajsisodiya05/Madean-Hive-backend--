package com.madeanhive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS Configuration for allowing cross-origin requests from frontend to backend.
 * This enables the Vite frontend (port 5173) to make API calls to Spring Boot backend (port 5454).
 * Also handles image requests from Cloudinary.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                    "http://localhost:5173",      // Vite frontend dev server
                    "http://localhost:3000",      // React/Node dev server (if needed)
                    "http://localhost:8080",      // Alternative port
                    "https://localhost:5173",     // HTTPS variant
                    "https://res.cloudinary.com"  // Cloudinary image CDN
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
