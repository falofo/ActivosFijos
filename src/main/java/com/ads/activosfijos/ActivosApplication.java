package com.ads.activosfijos;

import com.ads.activosfijos.security.JwtFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Created by Fabiani Lozano on 10/03/2018.
 */
@SpringBootApplication
public class ActivosApplication {
    @Value("${jwt.secret}")
    private String secret;
    public  static void main(String[] args){
        SpringApplication.run(ActivosApplication.class,args);
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

    @Bean
    public FilterRegistrationBean filterApiRequest(){
        FilterRegistrationBean filterRB = new FilterRegistrationBean();
        filterRB.setFilter(new JwtFilter(secret));
        filterRB.addUrlPatterns("/api/*");
        return filterRB;
    }
}
