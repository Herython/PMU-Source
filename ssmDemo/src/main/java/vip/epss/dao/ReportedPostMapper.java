package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.ReportedPost;
import vip.epss.domain.ReportedPostExample;

public interface ReportedPostMapper {
    long countByExample(ReportedPostExample example);

    int deleteByExample(ReportedPostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReportedPost record);

    int insertSelective(ReportedPost record);

    List<ReportedPost> selectByExample(ReportedPostExample example);

    ReportedPost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReportedPost record, @Param("example") ReportedPostExample example);

    int updateByExample(@Param("record") ReportedPost record, @Param("example") ReportedPostExample example);

    int updateByPrimaryKeySelective(ReportedPost record);

    int updateByPrimaryKey(ReportedPost record);

    List<Integer> getPostId();
    Integer deleteByPostId(Integer postId);
}