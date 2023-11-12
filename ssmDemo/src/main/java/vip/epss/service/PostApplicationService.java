package vip.epss.service;

import vip.epss.domain.Post;
import vip.epss.domain.PostApplication;
import vip.epss.domain.UserApplication;

import java.util.List;

public interface PostApplicationService {
    public Integer deleteByKey(Integer id);
    public PostApplication selectByKey(Integer id);

    public List<PostApplication> displayPostAPP();
}
