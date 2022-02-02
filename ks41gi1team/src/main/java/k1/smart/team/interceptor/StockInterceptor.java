package k1.smart.team.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class StockInterceptor implements HandlerInterceptor {
	//log4j
	private static final Logger log = LoggerFactory.getLogger(StockInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String requestUri = request.getRequestURI();
		
		String sessionId = (String) session.getAttribute("UID");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		
		if(sessionId == null) {
			response.sendRedirect("/"); //index로 redirect
			return false;
		} else {
			//URI 공백 제거
			requestUri = requestUri.trim();
			log.info("SESSION - ULEVEL :: {}", sessionLevel);
			
			//직원
			if("3".equals(sessionLevel)) {
				//품목
				if(	requestUri.indexOf("k1ItemRemove") 			> -1 || 
					requestUri.indexOf("k1ItemCategoryRemove") 	> -1) {
					response.sendRedirect("/k1Item");
					return false;
				}
				//재고
				if(	requestUri.indexOf("k1StockRemove") 	> -1 || 
						requestUri.indexOf("k1CleanStock") 	> -1) {
					response.sendRedirect("/k1Stock");
					return false;
				}
				//창고
				if(	requestUri.indexOf("/k1WarehouseRemove") > -1) {
					response.sendRedirect("/k1Warehouse");
					return false;
				}
			}
			
			//외부거래처
			if("4".equals(sessionLevel)) {
				if(	requestUri.indexOf("k1Stock") 	> -1 || 
						requestUri.indexOf("k1Item") 	> -1 || 
						requestUri.indexOf("k1Warehouse") 	> -1) {
					
					response.sendRedirect("/");
					return false;
				}
			}
		}
		
		return true;
	}
}
