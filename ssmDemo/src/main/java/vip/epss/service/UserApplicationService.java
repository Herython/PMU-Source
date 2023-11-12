package vip.epss.service;

import vip.epss.domain.UserApplication;

public interface UserApplicationService extends BaseService{
    public Integer deleteByKey(Integer id);
    public UserApplication selectByKey(Integer id);
}
