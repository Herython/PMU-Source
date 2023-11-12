package vip.epss.service;

import org.springframework.stereotype.Service;
import vip.epss.domain.OrderWithItem;
import vip.epss.domain.Orders;

public interface OrdersService extends BaseService{
    public OrderWithItem selectWithItem(Integer id);
}
