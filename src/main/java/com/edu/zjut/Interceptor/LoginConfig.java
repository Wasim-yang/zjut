package com.edu.zjut.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new AdminInterceptor());
        registration.addPathPatterns("/admin/**");                      //添加拦截路径
        registration.excludePathPatterns(       //添加不拦截路径
                "/**/login",
                "/**/authorization",
                "/**/static",
                "/**/*.js",              //js静态资源
                "/**/*.css",              //css静态资源
                "/**/*.jpg",
                "/**/*.png",
                "/**/*.jpeg"
        );
        InterceptorRegistration registration1 = registry.addInterceptor(new BusinessInterceptor());
        registration1.addPathPatterns("/business/**");
        registration1.excludePathPatterns(         //添加不拦截路径
                "/**/login",
                "/**/register",
                "/**/authorization",
                "/**/*.js",              //js静态资源
                "/**/*.css"            //css静态资源
        );
        InterceptorRegistration registration2 = registry.addInterceptor(new PleaderInterceptor());
        registration2.addPathPatterns("/pleader/**");
        registration2.excludePathPatterns(         //添加不拦截路径
                "/**/login",
                "/**/register",
                "/**/authorization",
                "/**/*.js",              //js静态资源
                "/**/*.css"            //css静态资源
        );
        InterceptorRegistration registration3 = registry.addInterceptor(new UsrInterceptor());
        registration3.addPathPatterns("/usr/**");
        registration3.excludePathPatterns(         //添加不拦截路径
                "/**/login",
                "/**/register",
                "/**/authorization",
                "/**/*.js",              //js静态资源
                "/**/*.css",         //css静态资源
                "/**/*.jpg",
                "/**/*.png",
                "/**/*.jpeg"
        );
    }
}
