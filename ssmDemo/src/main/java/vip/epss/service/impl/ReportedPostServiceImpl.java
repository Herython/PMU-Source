package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.ReportedPostMapper;
import vip.epss.domain.ReportedPost;
import vip.epss.service.ReportedPostService;

import java.util.List;

@Service(value="reportedPostService")
public class ReportedPostServiceImpl implements ReportedPostService {
    @Autowired
    ReportedPostMapper reportedPostMapper;
    @Override
    public Integer insertAPost(Integer postId) {
        ReportedPost reportedPost=new ReportedPost(postId);
        return reportedPostMapper.insert(reportedPost);
    }

    @Override
    public List<Integer> getPostId() {
        return reportedPostMapper.getPostId();
    }

    @Override
    public Integer deleteByPostId(Integer postId) {
        return reportedPostMapper.deleteByPostId(postId);
    }
}
