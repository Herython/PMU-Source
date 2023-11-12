package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.UserApplicationMapper;
import vip.epss.dao.UserMapper;
import vip.epss.domain.User;
import vip.epss.domain.UserApplication;
import vip.epss.service.GuestService;

@Service(value="guestService")
public class GuestServiceImpl implements GuestService {
    @Autowired
    UserApplicationMapper userApplicationMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public Integer register(String cardid, String nickname, String realname, Integer age, String password,
                            String sex, String screctquestion, String avaurl, String cardurl, String introduction) {
//        UserApplication userApplication=new UserApplication(cardid,);
//        return userApplicationMapper.insert(userApplication);
        User user=new User(cardid,nickname,realname,age,password,sex,screctquestion,avaurl,cardurl,introduction);
        return userMapper.insert(user);
    }
}
