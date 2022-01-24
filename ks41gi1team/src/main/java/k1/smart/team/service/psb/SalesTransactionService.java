package k1.smart.team.service.psb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import k1.smart.team.dto.psb.SalesTransaction;
import k1.smart.team.mapper.CodeMapper;
import k1.smart.team.mapper.psb.SalesTransactionMapper;

@Service
public class SalesTransactionService {
	private SalesTransactionMapper salesTransactionMapper;
	private List<SalesTransaction> salesTransactionList;
	
	@Autowired
	private CodeMapper codeMapper;
	
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
			
			//하나의 등록할때마다 매출거래 코드 새추가
			public String getSalesTransactionCode() {
				return salesTransactionMapper.getSalesTransactionCode();
			}
	
}

