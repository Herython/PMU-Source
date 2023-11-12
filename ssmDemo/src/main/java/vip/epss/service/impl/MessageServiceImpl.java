package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.MessageMapper;
import vip.epss.domain.Item;
import vip.epss.domain.Message;
import vip.epss.service.MessageService;

import java.util.List;

@Service(value="MessageService")
public class MessageServiceImpl implements MessageService {
    public MessageServiceImpl() {
        super();
    }

    @Autowired
    MessageMapper messageMapper;

    @Override
    public Integer deleteById(Integer id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Message selectOne(Integer id) {
        Message message=messageMapper.selectByPrimaryKey(id);
        return message;
    }

    @Override
    public List<Message> selectByUserId(Integer id) {
        return messageMapper.selectByUserid(id);
    }

    @Override
    public Integer deleteByPostId(Integer id) {
        return messageMapper.deleteByPostId(id);
    }
    
    @Override
    public List<Message> getMessageByPostId(Integer id) {
        return messageMapper.getMessageByPostId(id);
    }
}
