package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.ForbidenedUser;
import vip.epss.domain.ForbidenedUserExample;

public interface ForbidenedUserMapper {
    long countByExample(ForbidenedUserExample example);

    int deleteByExample(ForbidenedUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ForbidenedUser record);

    int insertSelective(ForbidenedUser record);

    List<ForbidenedUser> selectByExample(ForbidenedUserExample example);

    ForbidenedUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ForbidenedUser record, @Param("example") ForbidenedUserExample example);

    int updateByExample(@Param("record") ForbidenedUser record, @Param("example") ForbidenedUserExample example);

    int updateByPrimaryKeySelective(ForbidenedUser record);

    int updateByPrimaryKey(ForbidenedUser record);

    ForbidenedUser selectByUserId(Integer id);
    int deleteByUserId(Integer id);

}