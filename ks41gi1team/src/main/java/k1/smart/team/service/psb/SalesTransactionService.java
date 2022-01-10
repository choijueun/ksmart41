package k1.smart.team.service.psb;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.SalesTransaction;
import k1.smart.team.mapper.psb.SalesTransactionMapper;

@Service
public class SalesTransactionService {
	private SalesTransactionMapper salesTransactionMapper;
	private List<SalesTransaction> salesTransactionList;
	
	//생성자 메서드 주입
	public SalesTransactionService(SalesTransactionMapper salesTransactionMapper) {
		this.salesTransactionMapper = salesTransactionMapper;
	}
	
	//매출거래명세서 등록
	public int addSalesTransaction(SalesTransaction salesTransaction) {
		
		int result = salesTransactionMapper.addSalesTransaction(salesTransaction);
		
		return result;
	}
	
	public List<SalesTransaction> getSalesTransactionList(){
		List<SalesTransaction> salesTransactionList = salesTransactionMapper.getSalesTransactionList();
		
		return salesTransactionList;
	}
	

			//매출거래명세서 전체조회  조회
			public List<Map<String, Object>> getSalesTransactionHistory() {
				
				return salesTransactionMapper.getSalesTransactionHistoryList(null);
			} 
	
	
}

