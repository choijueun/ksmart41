package k1.smart.team.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	//log4j
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String requestUri = request.getRequestURI();
		
		String sessionId = (String) session.getAttribute("UID");
		String sessionLevelName = (String) session.getAttribute("ULEVEL");
		
		if(sessionId == null) {
			response.sendRedirect("/"); //index로 redirect
			return false;
		} else {
			//URI 공백 제거
			requestUri = requestUri.trim();
			log.info("SESSION - ULEVEL :: {}", sessionLevelName);
		}
		
		return true;
	}
}
