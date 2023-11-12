package vip.epss.service;


import org.springframework.stereotype.Service;
import vip.epss.domain.Item;

public interface ItemService extends BaseService{
    public Integer deleteById(Integer id);
    public Item selectOne(Integer id);
}
