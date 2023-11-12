package vip.epss.service;

public interface GuestService {
    public Integer register(String cardid, String nickname, String realname, Integer age, String password,
                            String sex, String screctquestion, String avaurl, String cardurl, String introduction);
}
