package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.OrdersMapper;
import vip.epss.domain.OrderWithItem;
import vip.epss.domain.Orders;
import vip.epss.service.OrdersService;

@Service(value = "ordersService")
public class OrdersServiceImpl implements OrdersService {
    public OrdersServiceImpl() {
        super();
    }

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public OrderWithItem selectWithItem(Integer id) {
        OrderWithItem orderWithItem=ordersMapper.selectByPrimaryKeyWithItem(id);
        return orderWithItem;
    }
}
