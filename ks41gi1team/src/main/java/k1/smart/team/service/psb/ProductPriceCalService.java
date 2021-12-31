package k1.smart.team.service.psb;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.psb.ProductPriceCalMapper;

@Service
public class ProductPriceCalService {
	private ProductPriceCalMapper productPriceCalMapper;
	public ProductPriceCalService(ProductPriceCalMapper productPriceCalMapper) {
		this.productPriceCalMapper = productPriceCalMapper;
	}
}
