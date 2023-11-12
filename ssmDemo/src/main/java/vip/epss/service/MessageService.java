package vip.epss.service;

import vip.epss.domain.Item;
import vip.epss.domain.Message;

import java.util.List;

public interface MessageService extends BaseService{
    public Integer deleteById(Integer id);
    public Message selectOne(Integer id);
    public List<Message> selectByUserId(Integer id);
    public Integer deleteByPostId(Integer id);
    
    public List<Message> getMessageByPostId(Integer id);
}
