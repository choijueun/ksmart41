package k1.smart.team.mapper.csh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.csh.MainBusiness;
@Mapper
public interface MainBusinessMapper {
	
	//사업장 전체목록 조회
	public List<MainBusiness> getAllMainBusinessList();
	
	//사업자 대표번호 중복검사
	public int getBusinessByCode(String mainBusinessCode);

	//사업자번호 중복검사
	public int getBusinessByNum(String businessNum);
	
	//사업장정보 상세
	public MainBusiness getMainBusinessDetail(String mainBusinessCode);


}
