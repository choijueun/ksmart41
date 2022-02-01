package k1.smart.team.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import k1.smart.team.interceptor.CommonInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	private final CommonInterceptor commonInterceptor;
	
	/**
	 * 생성자 메서드
	 */
	public WebConfig(CommonInterceptor commonInterceptor) {
		this.commonInterceptor = commonInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commonInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/css/**")
		.excludePathPatterns("/js/**")
		.excludePathPatterns("favicon.ico");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
