package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.ItemMapper;
import vip.epss.domain.Item;
import vip.epss.service.ItemService;

@Service(value="itemService")
public class ItemServiceImpl implements ItemService {
    public ItemServiceImpl() {
        super();
    }
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public Integer deleteById(Integer id) {
        return itemMapper.deleteByPrimaryKey(id);
    }
    @Override
    public Item selectOne(Integer id) {
        return itemMapper.selectByPrimaryKey(id);
    }
}
