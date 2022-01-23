package k1.smart.team.dto.psb;

public class ContractCodeForMaterialOrderCode {
	private String contractCodeForMaterialOrderCode;

	public String getContractCodeForMaterialOrderCode() {
		return contractCodeForMaterialOrderCode;
	}

	public void setContractCodeForMaterialOrderCode(String contractCodeForMaterialOrderCode) {
		this.contractCodeForMaterialOrderCode = contractCodeForMaterialOrderCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContractCodeForMaterialOrderCode [contractCodeForMaterialOrderCode=");
		builder.append(contractCodeForMaterialOrderCode);
		builder.append("]");
		return builder.toString();
	}

	

}
