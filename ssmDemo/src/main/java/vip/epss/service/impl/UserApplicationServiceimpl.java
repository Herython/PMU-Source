package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.UserApplicationMapper;
import vip.epss.domain.UserApplication;
import vip.epss.service.UserApplicationService;

@Service(value="userApplicationService")
public class UserApplicationServiceimpl implements UserApplicationService {

    @Autowired
    UserApplicationMapper userApplicationMapper;

    @Override
    public UserApplication selectByKey(Integer id) {
        return userApplicationMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer deleteByKey(Integer id) {
        return userApplicationMapper.deleteByPrimaryKey(id);
    }
}
