package k1.smart.team.interceptor;

import java.util.Set;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CommonInterceptor implements HandlerInterceptor {
	//log4j
	private static final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Set<String> paramKeySet = request.getParameterMap().keySet(); //key&value에서 key만
		
		StringJoiner param = new StringJoiner(", "); //구분자
		for(String key : paramKeySet) {
			param.add(key + "=" + request.getParameter(key));
		}
		
		log.info("CommonInte     rceptor=================================Start");
		log.info("Access Info=================================Start");
		log.info("PORT 	:: {}", request.getLocalPort());
		log.info("SERVERNAME 	:: {}", request.getServerName());
		log.info("HTTP METHOD :: {}", request.getMethod());
		log.info("URI 	:: {}", request.getRequestURI());
		log.info("PARAMETER 	:: {}", param);
		log.info("Access Info=================================End");
		
		//return HandlerInterceptor.super.preHandle(request, response, handler);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("CommonInterceptor=================================postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("CommonInterceptor=================================afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
