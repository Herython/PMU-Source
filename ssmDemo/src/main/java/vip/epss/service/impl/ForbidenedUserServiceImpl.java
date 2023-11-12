package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.ForbidenedUserMapper;
import vip.epss.domain.ForbidenedUser;
import vip.epss.service.ForbidenedUserService;

@Service(value="forbidenedUserService")
public class ForbidenedUserServiceImpl implements ForbidenedUserService {
    @Autowired
    ForbidenedUserMapper forbidenedUserMapper;

    @Override
    public ForbidenedUser selectByUserId(Integer id) {
        return forbidenedUserMapper.selectByUserId(id);
    }

    @Override
    public Integer deleteByUserId(Integer id) {
        return forbidenedUserMapper.deleteByUserId(id);
    }

    @Override
    public Integer insertUser(Integer userId) {
        ForbidenedUser forbidenedUser=new ForbidenedUser(userId);
        return forbidenedUserMapper.insert(forbidenedUser);
    }
}
