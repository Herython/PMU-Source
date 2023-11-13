package vip.epss.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import vip.epss.domain.Message;
import vip.epss.domain.Post;
import vip.epss.domain.ReportedPost;
import vip.epss.service.AttributesService;
import vip.epss.service.MessageService;
import vip.epss.service.PostService;
import vip.epss.service.ReportedPostService;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    PostService postService;
    
    @Autowired
    AttributesService attributesService;
    
    @Autowired
    ReportedPostService reportedPostService;
    
    @Autowired
    MessageService messageService;

//    @RequestMapping(value="opt/{num}",method = RequestMethod.GET)
//    Post getPostById(@PathVariable("num")Integer id, HttpSession session){
//        session.setAttribute("postId",id);
//        return postService.selectById(id);
//    }
    
    @RequestMapping(value="opt",method = RequestMethod.POST)
    Integer getPostById(@RequestParam("postId") Integer id){
        reportedPostService.deleteByPostId(id);
        messageService.deleteByPostId(id);
        return postService.deleteById(id);
    }
    
//    @RequestMapping(value="opt",method = RequestMethod.GET)
//    List<Post> getPostByUserId(){
//        Integer userId=attributesService.getUserId();
//        return postService.selectByUserId(userId);
//    }
    

    @RequestMapping(value="opt",method=RequestMethod.GET)
    List<Post> getPostByType(@RequestParam("type")String type){
        return postService.getPostByType(type);
    }


    @RequestMapping(value="message",method =RequestMethod.GET)
    List<Message> getPostMessages(HttpSession session){
        Integer postId=Integer.parseInt(session.getAttribute("postId").toString());
        return postService.getPostMessages(postId);
    }

}
