package me.ExpenseEdge;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // Enables the Spring MVC @Controller programming model <annotation-driven />
@ComponentScan(basePackages = "me.ExpenseEdge")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("/static/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("/static/css/");
	    registry.addResourceHandler("/image/**").addResourceLocations("/static/image/");
	}
	
	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
	//파일이 포함된 multipart/form-data를 수신하고 해석하는 일을 담당하는 MultipartResolver 객체를 "multipartResolver"라는 이름으로 스프링에 등록
	@Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(-1);  // 파일 크기 제한 (무제한으로 설정)
        resolver.setMaxUploadSizePerFile(-1);  // 각 파일의 최대 크기 (무제한으로 설정)
        resolver.setDefaultEncoding("utf-8");  // 인코딩 설정
        resolver.setResolveLazily(true);  // lazy resolution 설정
        return resolver;
    }

}
