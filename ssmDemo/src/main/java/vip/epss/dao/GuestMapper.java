package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Guest;
import vip.epss.domain.GuestExample;

public interface GuestMapper {
    long countByExample(GuestExample example);

    int deleteByExample(GuestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Guest record);

    int insertSelective(Guest record);

    List<Guest> selectByExample(GuestExample example);

    Guest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Guest record, @Param("example") GuestExample example);

    int updateByExample(@Param("record") Guest record, @Param("example") GuestExample example);

    int updateByPrimaryKeySelective(Guest record);

    int updateByPrimaryKey(Guest record);
}