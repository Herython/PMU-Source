package vip.epss.service;

import java.util.List;

public interface ReportedPostService {
    Integer insertAPost(Integer postId);

    List<Integer> getPostId();
    Integer deleteByPostId(Integer postId);
}
