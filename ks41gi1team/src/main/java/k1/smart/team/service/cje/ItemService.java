package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.ItemMapper;

@Service
public class ItemService {
	private ItemMapper itemMapper;
	public ItemService(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

}
