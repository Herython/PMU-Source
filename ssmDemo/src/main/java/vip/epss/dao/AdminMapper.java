package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Admin;
import vip.epss.domain.AdminExample;
import vip.epss.domain.UserApplication;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    List<UserApplication> displayAllApplication();
    String getPswdByUserName(String userName);

    Integer getIdByUserName(String userName);
    String getSQById(Integer id);
    int updatePswdById(@Param("id") Integer id, @Param("password") String password);
    String getPswdByCardId(String cardId);
    Integer getIdByCardId(String cardId);
}