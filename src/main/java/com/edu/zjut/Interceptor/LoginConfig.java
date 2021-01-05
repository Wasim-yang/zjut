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
        registration.addPathPatterns("/admin/**");                      //所有路径都被拦截
        registration.excludePathPatterns(       //添加不拦截路径
                "/**/login",
                "/**/authorization",
                "/**/*.js",              //js静态资源
                "/**/*.css"              //css静态资源
        );
        InterceptorRegistration registration1 = registry.addInterceptor(new UsrInterceptor());
        registration1.addPathPatterns("/usr/**");
        registration1.excludePathPatterns(         //添加不拦截路径
                "/**/login",
                "/**/register",
                "/**/authorization",
                "/**/*.js",              //js静态资源
                "/**/*.css"            //css静态资源
        );
    }
}
