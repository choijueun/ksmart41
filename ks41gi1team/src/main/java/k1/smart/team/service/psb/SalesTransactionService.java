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
	private SalesTransaction salesTransactionInfo;
	
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
			public List<SalesTransaction> getAllSalesTransactionList(String mainBusinessCode) {
				
				salesTransactionList = salesTransactionMapper.getAllSalesTransactionList(mainBusinessCode);
				if(salesTransactionList == null) {
					System.out.println("기타비용 조회결과 없음");
					return null;
				}
				
				
				String salesTransactionNum; 
				for(int i=0; i<salesTransactionList.size(); i++) { 
				salesTransactionInfo = salesTransactionList.get(i);
				salesTransactionNum = salesTransactionInfo.getSalesTsCode();
				salesTransactionNum = salesTransactionNum.substring(salesTransactionNum.length()-3, salesTransactionNum.length());
				salesTransactionList.get(i).setSalesTsCode(salesTransactionNum); }
				
				
				return salesTransactionList;
			}
			
			//하나의 등록할때마다 매출거래 코드 새추가
			public String getSalesTransactionCode() {
				return salesTransactionMapper.getSalesTransactionCode();
			}

			public List<Map<String, Object>> getSalesTransactionHistory() {
				// TODO Auto-generated method stub
				return null;
			}
			
			//매출거래 상세
			public SalesTransaction getSalesTransactionInfoByCode(String salesTsCode) {
				salesTransactionInfo = salesTransactionMapper.getSalesTransactionInfoByCode("salesTsCode_"+salesTsCode);
				
				if(salesTransactionInfo == null) {
					System.out.println("매출거래명세서 정보 조회결과 없음");
					return null;
				}
				salesTransactionInfo.setSalesTsCode(salesTsCode);
				return salesTransactionInfo;
			}
	
}

