package k1.smart.team.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import k1.smart.team.interceptor.CommonInterceptor;
import k1.smart.team.interceptor.LoginInterceptor;
import k1.smart.team.interceptor.StockInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	private final CommonInterceptor commonInterceptor;
	private final LoginInterceptor loginInterceptor;
	private final StockInterceptor stockInterceptor;
	
	/**
	 * 생성자 메서드
	 */
	public WebConfig(CommonInterceptor commonInterceptor
			,LoginInterceptor loginInterceptor
			,StockInterceptor stockInterceptor) {
		this.commonInterceptor = commonInterceptor;
		this.loginInterceptor = loginInterceptor;
		this.stockInterceptor = stockInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commonInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/dist/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/plugins/**")
				.excludePathPatterns("/SMARTORY/**")
				.excludePathPatterns("favicon.ico");
		
		//로그인 및 로그인내역
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/dist/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/plugins/**")
				.excludePathPatterns("/SMARTORY/**")
				.excludePathPatterns("favicon.ico")
				.excludePathPatterns("/")
				.excludePathPatterns("/signUp")
				.excludePathPatterns("/k1Login/login")
				.excludePathPatterns("/k1Login/login2")
				.excludePathPatterns("/k1Login/logout");
		
		//재고 관리
		registry.addInterceptor(stockInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/dist/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/plugins/**")
				.excludePathPatterns("/SMARTORY/**")
				.excludePathPatterns("favicon.ico")
				.excludePathPatterns("/")
				.excludePathPatterns("/signUp")
				.excludePathPatterns("/k1Login/login")
				.excludePathPatterns("/k1Login/login2")
				.excludePathPatterns("/k1Login/logout");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
