package vip.epss.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.epss.service.GuestService;
import vip.epss.service.UserService;
import vip.epss.utils.MessageAndData;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/guest")
public class GuestController {
    @Autowired
    GuestService guestService;
    
    @Autowired
    UserService userService;

//    String cardid, String nickname, String realname, Integer age, String password,
//    String sex, String screctquestion, String avaurl, String cardurl, String introduction
    @RequestMapping(value="register",method= RequestMethod.POST)
    public MessageAndData register(@RequestParam("cardId")String cardId,
                                                @RequestParam("nickName")String nickName,
                                                @RequestParam("realName")String realName,
                                                @RequestParam("age")Integer age,
                                                @RequestParam("password")String password,
                                                @RequestParam("sex")String sex,
                                                @RequestParam("secretQuestion")String secretQuestion,
                                                @RequestParam("avaUrl")String avaUrl,
                                                @RequestParam("cardUrl")String cardUrl,
                                                @RequestParam("introduction")String introduction
                                                ) {
//        Integer flag=guestService.register(cardId,name,age,password,sex,secretQuestion,imgUrl);
        String pswd=userService.getPswdByCardId(cardId);
        if(pswd!=null){
            return MessageAndData.success().setMessage("用户已被注册");
        }
        Integer flag=guestService.register(cardId,nickName,realName,age,password,sex,secretQuestion,avaUrl,cardUrl,introduction);
        if(flag==1){
            return MessageAndData.success().setMessage("注册成功");
        }
        else{
            return MessageAndData.success().setMessage("注册失败!");
        }
    }

}
