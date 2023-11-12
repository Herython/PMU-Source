package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.*;
import vip.epss.domain.*;
import vip.epss.service.UserService;

import java.util.List;

@Service(value="userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    PostApplicationMapper postApplicationMapper;
    @Autowired
    PostMapper postMapper;
    @Autowired
    MessageMapper messageMapper;
    @Override
    public Integer insertUser(String cardid, String nickname, String realname, Integer age, String password, String sex,
                              String screctquestion, String avaurl, String cardurl, String introduction) {
        User user=new User(cardid,nickname,realname,age,password,sex,screctquestion,avaurl,cardurl,introduction);
        Integer flag=userMapper.insert(user);
        if(1==flag){
            System.out.println("申请成功！");
            return 1;
        }
        else{
            System.out.println("申请失败！");
            return 0;
        }
    }
    @Override
    public User getUser(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public Integer getIdByCardId(String cardId) {
        return userMapper.getIdByCardId(cardId);
    }

    @Override
    public Integer postAPost(Integer userid, String type, String title, String source, String destination,
                             String time, String count, String imgurl, String content) {
//        PostApplication postApplication=new PostApplication(content,title,type,userid,"",imgUrl);
        Post post=new Post(userid,type,title,source,destination,time,count,imgurl,content);
//        Integer flag=postApplicationMapper.insert(postApplication);
        Integer flag=postMapper.insert(post);
        return flag;
    }

    @Override
    public Integer postAMessage(String content, Integer userId, Integer postId) {
        Message message=new Message(content,userId,postId);
        if(message==null){
            return 0;
        }
        else{
            messageMapper.insert(message);
            return 1;
        }
    }

//    @Override
//    public Integer getIdByUserName(String userName) {
//        return userMapper.getIdByUserName(userName);
//    }

    @Override
    public String getPswdByUserName(String userName) {
        return userMapper.getPswdByUserName(userName);
    }

    @Override
    public String getSQById(Integer id) {
        return userMapper.getSQById(id);
    }

    @Override
    public Integer updatePswdById(Integer id, String password) {
        return userMapper.updatePswdById(id,password);
    }

    @Override
    public String getPswdByCardId(String cardId) {
        return userMapper.getPswdByCardId(cardId);
    }

    @Override
    public String getRealNameByUserId(Integer id) {
        return userMapper.getRealNameByUserId(id);
    }
    
    @Override
    public List<Post> getPostByUserId(Integer id) {
        return userMapper.getPostByUserId(id);
    }
    
    @Override
    public Integer updateSelf(String nickName, String intro, Integer id) {
        return userMapper.updateSelf(nickName,intro,id);
    }
}
