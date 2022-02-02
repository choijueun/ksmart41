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
			, LoginInterceptor loginInterceptor
			, StockInterceptor stockInterceptor) {
		this.commonInterceptor = commonInterceptor;
		this.loginInterceptor = loginInterceptor;
		this.stockInterceptor = stockInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commonInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("favicon.ico");
		
		//로그인 및 로그인내역
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("favicon.ico")
				.excludePathPatterns("/")
				.excludePathPatterns("/signUp")
				.excludePathPatterns("/login")
				.excludePathPatterns("/login2")
				.excludePathPatterns("/logout");
		
		//재고, 품목, 창고
		registry.addInterceptor(stockInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("favicon.ico")
				.excludePathPatterns("/")
				.excludePathPatterns("/signUp")
				.excludePathPatterns("/login")
				.excludePathPatterns("/login2")
				.excludePathPatterns("/logout");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
