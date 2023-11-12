package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.PostApplicationMapper;
import vip.epss.domain.Post;
import vip.epss.domain.PostApplication;
import vip.epss.service.PostApplicationService;

import java.util.List;

@Service(value="postApplicationSerice")
public class PostApplicationServiceImpl implements PostApplicationService {
    @Autowired
    PostApplicationMapper postApplicationMapper;

    @Override
    public Integer deleteByKey(Integer id) {
        Integer flag=postApplicationMapper.deleteByPrimaryKey(id);
        return flag;
    }

    @Override
    public PostApplication selectByKey(Integer id) {
        return postApplicationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PostApplication> displayPostAPP() {
        return postApplicationMapper.displayPostAPP();
    }
}
