package vip.epss.service;

import vip.epss.domain.UserApplication;

import java.util.List;

public interface AdminService extends BaseService{
    public List<UserApplication> displayAllAppication();
    public String getPswdByUserName(String userName);

    public String getPswdByCardId(String cardId);

    public Integer getIdByUserName(String userName);
    public Integer getIdByCardId(String cardId);
    public String getSQById(Integer id);
    public Integer updatePswdById(Integer id,String password);
}
