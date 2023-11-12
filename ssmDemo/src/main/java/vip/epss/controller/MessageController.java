package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.epss.domain.Message;
import vip.epss.service.MessageService;
import vip.epss.service.impl.MessageServiceImpl;
import vip.epss.utils.MessageAndData;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping(value="/opt",method = RequestMethod.GET)
    public List<Message> getMessage(@RequestParam("postId")Integer postId) {
//        Message message=messageService.selectOne(id);
        List<Message> messages=messageService.getMessageByPostId(postId);
        Collections.sort(messages, Comparator.comparing(Message::getTime).reversed());
        return messages;
    }
    
    
}
