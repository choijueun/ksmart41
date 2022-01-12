package k1.smart.team.service.psb;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.psb.PurchaseTransaction;
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

			//비용거래명세서 등록
			public int addPurchaseTransaction(PurchaseTransaction purchaseTransaction) {
				int result = purchaseTransactionMapper.addPurchaseTransaction(purchaseTransaction);
				return result;
			}

			public List<PurchaseTransaction> getPurchaseTransactionList() {
				List<PurchaseTransaction> purchaseTransactionList = purchaseTransactionMapper.getPurchaseTransactionList();
				return null;
			} 
			
			
}
