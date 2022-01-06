package k1.smart.team.service.psb;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.psb.PurchaseTransactionMapper;

@Service
public class PurchaseTransactionService {

		private PurchaseTransactionMapper purchaseTransactionMapper;
		
		public PurchaseTransactionService(PurchaseTransactionMapper purchaseTransactionMapper) {
			this.purchaseTransactionMapper = purchaseTransactionMapper;
		}

		//전체 비용거래명세서 조회
			public List<Map<String, Object>> getPurchaseTransactionHistory() {
			
			return purchaseTransactionMapper.getPurchaseTransactionHistoryList(null);
		} 
}
