package k1.smart.team.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component 
public class LoginInterceptor implements HandlerInterceptor {
	//log4j
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String requestUri = request.getRequestURI();
		
		String sessionId = (String) session.getAttribute("UID");
		int sessionLevel = (int) session.getAttribute("ULEVEL");
		
		//session에 ID가 없다면
		if(sessionId == null) {
			//index로 redirect
			response.sendRedirect("/"); 
			return false;
		} else {
			//URI 공백 제거
			requestUri = requestUri.trim();
			log.info("SESSION - ULEVEL :: {}", sessionLevel);
			//관리자가 아닌 경우
			if( sessionLevel != 1 || sessionLevel != 2 ) {
				if(requestUri.indexOf("loginList") > -1
						|| requestUri.indexOf("loginDetail") > -1 
						|| requestUri.indexOf("loginDelete") > -1) {
					//메인화면 redirect
					response.sendRedirect("/main");
					return false;
				}
			}
		}
		
		return true;
	}
}
