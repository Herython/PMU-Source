package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vip.epss.domain.Item;
import vip.epss.service.ItemService;
import vip.epss.utils.MessageAndData;


//orders/del?id=8
//orders/haha/1 拿到orders主键为1的字段 --HTTP方法 GET DELETE
@RestController
@RequestMapping(value="/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value="opt/{num}",method= RequestMethod.DELETE)
    public MessageAndData deleteItem(@PathVariable("num")Integer id) {//前端传过来的都是字符串
        itemService.deleteById(id);
        return MessageAndData.success().setMessage("删除成功");
    }

    @RequestMapping(value= "opt/{num}",method= RequestMethod.GET)
    public MessageAndData getItem(@PathVariable("num")Integer id){//前端传过来的都是字符串
        Item item=itemService.selectOne(id);
        if(item==null){
            return MessageAndData.error().setMessage("未查询到");
        }
        else{
            return MessageAndData.success().setMessage("查询成功");
        }
    }
}
