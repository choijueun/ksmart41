package k1.smart.team.service.psb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import k1.smart.team.dto.psb.PurchaseTransaction;
import k1.smart.team.mapper.CodeMapper;
import k1.smart.team.mapper.psb.PurchaseTransactionMapper;

@Service
public class PurchaseTransactionService {

		private PurchaseTransactionMapper purchaseTransactionMapper;
		private List<PurchaseTransaction> purchaseTransactionList;
		private PurchaseTransaction purchaseTransactionInfo;
		
		@Autowired
		private CodeMapper codeMapper;
		
		public PurchaseTransactionService(PurchaseTransactionMapper purchaseTransactionMapper) {
			this.purchaseTransactionMapper = purchaseTransactionMapper;
		}

		//전체 비용거래명세서 조회
			public List<Map<String, Object>> getPurchaseTransactionHistory() {
			
			return purchaseTransactionMapper.getPurchaseTransactionHistoryList(null);
		}
			//비용거래명세서 상세
			/*public PurchaseTransaction getPurchaseTransactionInfo(String purchaseTsCode) {
				purchaseTransactionInfo = purchaseTransactionMapper.getPurchaseTransactionInfo(purchaseTsCode);

				System.out.println("purchaseTransactionInfo 세팅전-->:" + purchaseTransactionInfo);
				if(purchaseTransactionInfo == null) {
					System.out.println("비용 거래서 정보 조회결과 없음");
					return null;
				}

				purchaseTransactionInfo.setPurchaseTsCode(purchaseTsCode);
				return purchaseTransactionInfo;
			}
			*/
			
			
			//비용거래명세서 등록
			public int addPurchaseTransaction(PurchaseTransaction purchaseTransaction) {
				int result = purchaseTransactionMapper.addPurchaseTransaction(purchaseTransaction);
				return result;
			}
			
			public String getPurchaseTransactionCode() {
				
				return purchaseTransactionMapper.getPurchaseTransactionCode();
			}
			

			public List<PurchaseTransaction> getPurchaseTransactionList() {
				List<PurchaseTransaction> purchaseTransactionList = purchaseTransactionMapper.getPurchaseTransactionList();
				return null;
			}

			public List<PurchaseTransaction> getAllPurchaseTransactionList(String mainBusinessCode) {
				purchaseTransactionList = purchaseTransactionMapper.getAllPurchaseTransactionList(mainBusinessCode);
				if(purchaseTransactionList == null) {
					System.out.println("비용거래명세서 조회결과 없음");
					return null;
				}
				
				
				String purchaseTransactionNum; 
				for(int i=0; i<purchaseTransactionList.size(); i++) { 
				purchaseTransactionInfo = purchaseTransactionList.get(i);
				purchaseTransactionNum = purchaseTransactionInfo.getPurchaseTsCode();
				purchaseTransactionNum = purchaseTransactionNum.substring(purchaseTransactionNum.length()-3, purchaseTransactionNum.length());
				purchaseTransactionList.get(i).setPurchaseTsCode(purchaseTransactionNum); }
				
				
				return purchaseTransactionList;
			}

			public PurchaseTransaction getPurchaseTransactionInfoByCode(String purchaseTsCode) {
				purchaseTransactionInfo = purchaseTransactionMapper.getPurchaseTransactionInfoByCode("purchase_ts_stCode_"+purchaseTsCode);
				
				if(purchaseTransactionInfo == null) {
					System.out.println("비용거래명세서 조회결과 없음");
					return null;
				}
				purchaseTransactionInfo.setPurchaseTsCode(purchaseTsCode);
				return purchaseTransactionInfo;
			}

		
			
			
}
