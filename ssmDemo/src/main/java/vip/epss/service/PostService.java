package vip.epss.service;

import vip.epss.domain.Message;
import vip.epss.domain.Post;

import java.util.List;

public interface PostService {
    public Integer insertPost(Integer userid, String type, String title, String source, String destination, String time, String count, String imgurl, String content);
    public Post selectById(Integer id);
    public List<Message> getPostMessages(Integer id);
    List<Post> selectByUserId(Integer id);
    Integer deleteById(Integer id);
    List<Post>getPostByType(String type);
}
