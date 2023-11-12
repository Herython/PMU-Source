package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.PostApplication;
import vip.epss.domain.PostApplicationExample;

public interface PostApplicationMapper {
    long countByExample(PostApplicationExample example);

    int deleteByExample(PostApplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PostApplication record);

    int insertSelective(PostApplication record);

    List<PostApplication> selectByExample(PostApplicationExample example);

    PostApplication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PostApplication record, @Param("example") PostApplicationExample example);

    int updateByExample(@Param("record") PostApplication record, @Param("example") PostApplicationExample example);

    int updateByPrimaryKeySelective(PostApplication record);

    int updateByPrimaryKey(PostApplication record);

    List<PostApplication> displayPostAPP();
}