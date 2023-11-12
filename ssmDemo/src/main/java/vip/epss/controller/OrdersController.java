package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vip.epss.domain.OrderWithItem;
import vip.epss.service.OrdersService;
import vip.epss.utils.MessageAndData;

@RestController
@RequestMapping(value="/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value="/opt/{num}",method = RequestMethod.GET)
    public MessageAndData getOrder(@PathVariable("num")Integer id){
        OrderWithItem orderWithItem=ordersService.selectWithItem(id);
        if(orderWithItem==null){
            return MessageAndData.error().setMessage("未查询到");
        }
        else{
            return MessageAndData.success().setMessage("查询成功");
        }
    }

}
