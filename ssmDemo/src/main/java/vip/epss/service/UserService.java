package vip.epss.service;

import vip.epss.domain.Post;
import vip.epss.domain.User;

import java.util.List;

public interface UserService {
    public Integer insertUser(String cardid, String nickname, String realname, Integer age, String password, String sex,
                              String screctquestion, String avaurl, String cardurl, String introduction);
    public User getUser(Integer id);
    public Integer postAPost(Integer userid, String type, String title, String source, String destination,
                             String time, String count, String imgurl, String content);
    public Integer postAMessage(String content,Integer userId,Integer postId);
//    public Integer getIdByUserName(String userName);
    public Integer getIdByCardId(String cardId);
    public String getPswdByUserName(String userName);
    public String getSQById(Integer id);
    public Integer updatePswdById(Integer id,String password);
    public String getPswdByCardId(String cardId);
    public String getRealNameByUserId(Integer id);
    public List<Post> getPostByUserId(Integer id);
    public Integer updateSelf(String nickName,String intro,Integer id);
}
