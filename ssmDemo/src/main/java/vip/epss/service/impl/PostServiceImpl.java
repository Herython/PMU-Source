package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.PostMapper;
import vip.epss.domain.Message;
import vip.epss.domain.Post;
import vip.epss.service.PostService;

import java.util.List;

@Service(value = "postService")
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;

    @Override
    public Integer insertPost(Integer userid, String type, String title, String source, String destination, String time, String count, String imgurl, String content) {
        Post post=new Post(userid,type,title,source,destination,time,count,imgurl,content);
        return postMapper.insert(post);
    }

    @Override
    public Integer deleteById(Integer id) {
        return postMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Post selectById(Integer id) {
        return postMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Message> getPostMessages(Integer id) {
        return postMapper.getPostMessages(id);
    }

    @Override
    public List<Post> selectByUserId(Integer id) {
        return postMapper.selectByUserId(id);
    }

    @Override
    public List<Post> getPostByType(String type) {
        return postMapper.getPostByType(type);
    }
}
