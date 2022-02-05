package k1.smart.team.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component 
public class StockInterceptor implements HandlerInterceptor {
	//log4j
	private static final Logger log = LoggerFactory.getLogger(StockInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String requestUri = request.getRequestURI();
		
		int sessionLevel = (int) session.getAttribute("ULEVEL");
		
		//URI 공백 제거
		requestUri = requestUri.trim();
		log.info("SESSION - ULEVEL :: {}", sessionLevel);
		//직원이 아닌 경우
		if( sessionLevel == 4 ) {
			if(requestUri.indexOf("k1Stock") > -1) {
				response.sendRedirect("/k1Stock");
				return false;
			}
			if(requestUri.indexOf("k1Item") > -1) {
				response.sendRedirect("/k1Item");
				return false;
			}
			if(requestUri.indexOf("k1Warehouse") > -1) {
				response.sendRedirect("/k1Warehouse");
				return false;
			}
		}
		//관리자가 아닌 경우
		if( sessionLevel == 3 || sessionLevel == 4 ) {
			if(requestUri.indexOf("k1StockRemove") > -1) {
				response.sendRedirect("/k1Stock");
				return false;
			}
			if(requestUri.indexOf("k1ItemRemove") > -1) {
				response.sendRedirect("/k1Item");
				return false;
			}
			if(requestUri.indexOf("k1ItemCategoryRemove") > -1 ) {
				response.sendRedirect("/k1ItemCategory");
				return false;
			}
			if(requestUri.indexOf("k1WarehouseRemove") > -1) {
				response.sendRedirect("/k1Warehouse");
				return false;
			}
		}
		
		return true;
	}
}
