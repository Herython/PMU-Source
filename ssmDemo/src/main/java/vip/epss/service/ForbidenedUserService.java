package vip.epss.service;

import vip.epss.domain.ForbidenedUser;

public interface ForbidenedUserService {
    public ForbidenedUser selectByUserId(Integer id);
    public Integer deleteByUserId(Integer userId);
    public Integer insertUser(Integer userId);
}
