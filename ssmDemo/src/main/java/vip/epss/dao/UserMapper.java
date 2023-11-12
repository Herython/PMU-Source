package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Post;
import vip.epss.domain.User;
import vip.epss.domain.UserExample;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExampleWithBLOBs(UserExample example);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExampleWithBLOBs(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);

    String getPswdByUserName(String userName);
    String getPswdByCardId(String cardId);
//    Integer getIdByUserName(String userName);
    Integer getIdByCardId(String cardId);
    String getSQById(Integer id);
    int updatePswdById(@Param("id") Integer id, @Param("password") String password);
    String getRealNameByUserId(Integer id);
    List<Post> getPostByUserId(Integer id);
    int updateSelf(@Param("nickName") String nickName, @Param("intro") String intro, @Param("id")Integer id);
}