package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vip.epss.domain.ForbidenedUser;
import vip.epss.domain.Message;
import vip.epss.domain.Post;
import vip.epss.domain.User;
import vip.epss.service.*;
import vip.epss.utils.MessageAndData;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PostService postService;
    @Autowired
    MessageService messageService;

    @Autowired
    ForbidenedUserService forbidenedUserService;
    @Autowired
    ReportedPostService reportedPostService;
    @Autowired
    AttributesService attributesService;

    @RequestMapping(value="login",method=RequestMethod.POST)
    public MessageAndData userLogin(@RequestParam("cardId")String cardId,
                                     @RequestParam("password")String password
//                                     HttpSession session
    ){
        String pswd=userService.getPswdByCardId(cardId);
        if(pswd==null){
            return MessageAndData.success().setMessage("无此用户!");
        }
        if(password.equals(pswd)){
//            session.setAttribute("userId",userService.getIdByCardId(cardId));
            attributesService.setUserId(userService.getIdByCardId(cardId));
            return MessageAndData.success().setMessage("登陆成功!");
        }
        else{
//            session.setAttribute("error","密码错误，请重新登录！");
            return MessageAndData.success().setMessage("密码错误!");
        }
    }

    @RequestMapping(value="/info",method = RequestMethod.GET)
    public User getUser(){
//        Integer id=Integer.parseInt(session.getAttribute("userId").toString());
        Integer id=attributesService.getUserId();
        User user=userService.getUser(id);
        return user;
    }
    
    @RequestMapping(value="/get",method = RequestMethod.GET)
    public User getUser(@RequestParam("id")Integer id){
//        Integer id=Integer.parseInt(session.getAttribute("userId").toString());
        User user=userService.getUser(id);
        return user;
    }

    @RequestMapping(value="/cardMapping/{num}",method=RequestMethod.GET)
    public String getRealNameByUserId(@PathVariable("num")Integer id){
        return userService.getRealNameByUserId(id);
    }
    
    @RequestMapping(value="/post",method =RequestMethod.GET)
    public List<Post> getPostByUserId(){
        Integer userId=attributesService.getUserId();
        List<Post> posts=userService.getPostByUserId(userId);
        return posts;
    }

    @RequestMapping(value="/update/password",method=RequestMethod.GET)
    public MessageAndData getSQ(HttpSession session){
        Integer id=Integer.parseInt(session.getAttribute("userId").toString());
        String oriSQ=userService.getSQById(id);
        String splitSQ[]=oriSQ.split("\\?");
        String Q=splitSQ[0];
        String A=splitSQ[1];

        return MessageAndData.success().setMessage(Q+"?");
    }

    @RequestMapping(value="/update/password",method=RequestMethod.POST)
    public MessageAndData updatePassword(@RequestParam("answer")String answer,
                                @RequestParam("newPswd")String newPswd,
                                HttpSession session){
        Integer id=Integer.parseInt(session.getAttribute("userId").toString());
        String oriSQ=userService.getSQById(id);
        String splitSQ[]=oriSQ.split("\\?");
        String Q=splitSQ[0];
        String A=splitSQ[1];

        if(!A.equals(answer)){
            return MessageAndData.success().setMessage("安全问题回答错误!");
        }
        else{
            Integer flag=userService.updatePswdById(id,newPswd);
            if(flag==1){
                return MessageAndData.success().setMessage("密码更新成功!");
            }
            else{
                return MessageAndData.success().setMessage("密码更新失败!");
            }
        }
    }

    @RequestMapping(value="/post",method=RequestMethod.POST)
    public MessageAndData postAPost(@RequestParam("type")String type,
                                    @RequestParam("title")String title,
                                    @RequestParam("source")String source,
                                    @RequestParam("destination")String destination,
                                    @RequestParam("time")String time,
                                    @RequestParam("count")String count,
                                    @RequestParam("content")String content,
                                    @RequestParam("imgUrl")String imgUrl
//                                    HttpSession session
                                    ){
//        Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
        Integer userId= attributesService.getUserId();
        ForbidenedUser condition=forbidenedUserService.selectByUserId(userId);
        if(condition!=null){
            return MessageAndData.success().setMessage("你已被禁言，请联系管理员!");
        }
//        Integer flag=userService.postAPost(content,title,type,userId,imgUrl);
        Integer flag=userService.postAPost(userId,type,title,source,destination,time,count,imgUrl,content);
        if(flag==1){
            return MessageAndData.success().setMessage("发布成功!");
        }
        else{
            return MessageAndData.success().setMessage("发布失败!");
        }
    }
    @RequestMapping(value="/jubao",method=RequestMethod.POST)
    public MessageAndData reportAPost(@RequestParam("id")Integer id){
        Integer flag=reportedPostService.insertAPost(id);
        if(flag==1){
            return MessageAndData.success().setMessage("举报成功!");
        }
        else{
            return MessageAndData.success().setMessage("举报失败!");
        }
    }

    @RequestMapping(value="/message",method=RequestMethod.POST)
    public MessageAndData postAMessage(@RequestParam("content")String content,
                                       @RequestParam("postId")Integer postId
                                       ){
//        Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
        Integer userId=attributesService.getUserId();
        ForbidenedUser condition=forbidenedUserService.selectByUserId(userId);
        if(condition!=null){
            return MessageAndData.success().setMessage("你已被禁言，请联系管理员!");
        }
//        Integer postId=Integer.parseInt(session.getAttribute("postId").toString());
        Integer flag=userService.postAMessage(content, userId, postId);
        if(flag==1){
            return MessageAndData.success().setMessage("跟贴成功!");
        }
        else{
            return MessageAndData.success().setMessage("跟贴失败!");
        }
    }

    @RequestMapping(value="/check/post",method=RequestMethod.GET)
    public List<Post> checkPost(HttpSession session){
        Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
        List<Post> posts=postService.selectByUserId(userId);
        return posts;
    }

    @RequestMapping(value="/check/message",method=RequestMethod.GET)
    public List<Message> checkMessage(HttpSession session){
        Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
        List<Message> messages=messageService.selectByUserId(userId);
        return messages;
    }

    @RequestMapping(value="/post/{num}",method=RequestMethod.DELETE)
    public MessageAndData deletePost(@PathVariable("num")Integer id,HttpSession session){
        Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
        Post post=postService.selectById(id);
        if(userId!=post.getUserid()){
            return MessageAndData.success().setMessage("删除失败!");
        }
        else{
            Integer postId=post.getId();
            Integer flag1=messageService.deleteByPostId(postId);
            Integer flag2=postService.deleteById(postId);
            if(flag1>=1&&flag2>=1){
                return MessageAndData.success().setMessage("删除失败!");
            }
            else{
                return MessageAndData.success().setMessage("删除成功!");
            }
        }
    }
    
    @RequestMapping(value="/update",method=RequestMethod.POST)
    public Integer updateSelf(@RequestParam("nickName")String nickname,
                                     @RequestParam("intro")String intro)
    {
        Integer userId=attributesService.getUserId();
        return userService.updateSelf(nickname,intro,userId);
    }

}
