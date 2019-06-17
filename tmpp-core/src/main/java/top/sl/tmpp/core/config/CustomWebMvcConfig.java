package top.sl.tmpp.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.sl.tmpp.common.mapper.CasMapper;
import top.sl.tmpp.security.cas.LoginUserArgumentResolver;

import java.util.List;

/**
 * @author itning
 * @date 2019/6/17 8:43
 */
@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer {
    private final CasMapper casMapper;

    public CustomWebMvcConfig(CasMapper casMapper) {
        this.casMapper = casMapper;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginUserArgumentResolver(casMapper));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .maxAge(3600);
    }
}
