package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.AdminMapper;
import vip.epss.domain.UserApplication;
import vip.epss.service.AdminService;

import java.util.List;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<UserApplication> displayAllAppication() {
        List<UserApplication> allApplication=adminMapper.displayAllApplication();
        return allApplication;
    }

    @Override
    public String getPswdByUserName(String userName) {
        return adminMapper.getPswdByUserName(userName);
    }

    @Override
    public String getPswdByCardId(String cardId) {
        return adminMapper.getPswdByCardId(cardId);
    }

    @Override
    public Integer getIdByCardId(String cardId) {
        return adminMapper.getIdByCardId(cardId);
    }

    @Override
    public Integer getIdByUserName(String userName) {
        return adminMapper.getIdByUserName(userName);
    }

    @Override
    public String getSQById(Integer id) {
        return adminMapper.getSQById(id);
    }

    @Override
    public Integer updatePswdById(Integer id, String password) {
        return adminMapper.updatePswdById(id,password);
    }

}
