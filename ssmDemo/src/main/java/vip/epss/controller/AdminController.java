package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vip.epss.domain.*;
import vip.epss.service.*;
import vip.epss.utils.MessageAndData;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @Autowired
    UserApplicationService userApplicationService;

    @Autowired
    PostService postService;

    @Autowired
    PostApplicationService postApplicationService;
    @Autowired
    ForbidenedUserService forbidenedUserService;

    @Autowired
    ReportedPostService reportedPostService;

    @Autowired
    MessageService messageService;
    
    @Autowired
    AttributesService attributesService;

    @RequestMapping(value= "/display/UserApp",method= RequestMethod.GET)
    public List<UserApplication> displayUserApplication(){
        List<UserApplication> userApplication=adminService.displayAllAppication();
        return userApplication;
    }

    @RequestMapping(value="/display/PostApp",method=RequestMethod.GET)
    public List<PostApplication> displayPostApplicaiton(){
        List<PostApplication> postApplications=postApplicationService.displayPostAPP();
        return postApplications;
    }
    
    
    @RequestMapping(value="login",method=RequestMethod.POST)
    public MessageAndData adminLogin(@RequestParam("cardId")String cardId,
                                    @RequestParam("password")String password
//                                    HttpSession session
                                    ){
//        String pswd=adminService.getPswdByUserName(userName);
        String pswd=adminService.getPswdByCardId(cardId);
        if(pswd==null){
            return MessageAndData.success().setMessage("无此用户!");
        }
        if(password.equals(pswd)){
//            session.setAttribute("adminId",adminService.getIdByUserName(userName));
//            session.setAttribute("adminId",adminService.getIdByCardId(cardId));
            Integer adminId=adminService.getIdByCardId(cardId);
            attributesService.setAdminId(adminId);
            return MessageAndData.success().setMessage("登陆成功!");
        }
        else{
//            session.setAttribute("error","密码错误，请重新登录！");
            return MessageAndData.success().setMessage("密码错误!");
        }
    }

//    @RequestMapping(value= "userApp/{num}",method= RequestMethod.POST)
//    public MessageAndData passUserApplication(@PathVariable("num")Integer id){//前端传过来的都是字符串
//        UserApplication userApplication=userApplicationService.selectByKey(id);
//        if(userApplication!=null){
//            Integer flag=userService.insertUser(userApplication.getCardid(),userApplication.getName(),
//                    userApplication.getAge(),userApplication.getPassword(),userApplication.getSex(),
//                    userApplication.getScrectquestion(),userApplication.getImgurl());
//            if(1==flag){
//                userApplicationService.deleteByKey(id);
//                return MessageAndData.success().setMessage("申请成功通过");
//            }
//            else{
//                return MessageAndData.success().setMessage("申请通过失败");
//            }
//        }
//        else{
//            return MessageAndData.success().setMessage("未找到这条申请！");
//        }
//    }

    @RequestMapping(value="userApp/{num}",method=RequestMethod.DELETE)
    public MessageAndData refuseUserApplication(@PathVariable("num")Integer id){
        Integer flag=userApplicationService.deleteByKey(id);
        if(flag==1){
            return MessageAndData.success().setMessage("拒绝了申请");
        }
        else{
            return MessageAndData.success().setMessage("拒绝申请失败");
        }
    }


//    @RequestMapping(value="postApp/{num}",method=RequestMethod.PUT)
//    public MessageAndData passPostApplication(@PathVariable("num")Integer id){
//        PostApplication postApplication=postApplicationService.selectByKey(id);
//        if(postApplication!=null){
//            Integer flag=postService.insertPost(postApplication.getId(),postApplication.getContent(),postApplication.getTitle(),
//                    postApplication.getType(),postApplication.getUserid(),postApplication.getImgurl());
//            if(flag==1){
//                postApplicationService.deleteByKey(id);
//                return MessageAndData.success().setMessage("申请成功通过");
//            }
//            else{
//                return MessageAndData.success().setMessage("申请通过失败");
//            }
//        }
//        else{
//            return MessageAndData.success().setMessage("未找到这条申请！");
//        }
//    }

    @RequestMapping(value="postApp/{num}",method=RequestMethod.DELETE)
    public MessageAndData refusePostApplication(@PathVariable("num")Integer id){
        Integer flag=postApplicationService.deleteByKey(id);
        if(flag==1){
            return MessageAndData.success().setMessage("拒绝了申请");
        }
        else{
            return MessageAndData.success().setMessage("未找到这条申请!");
        }
    }

    @RequestMapping(value="/update/password",method=RequestMethod.POST)
    public MessageAndData updatePassword(@RequestParam("answer")String answer,
                                         @RequestParam("newPswd")String newPswd,
                                         HttpSession session) {
        Integer id = Integer.parseInt(session.getAttribute("adminId").toString());

        String oriSQ = adminService.getSQById(id);
        String splitSQ[] = oriSQ.split("\\?");
        String Q = splitSQ[0];
        String A = splitSQ[1];

        if (!A.equals(answer)) {
            return MessageAndData.success().setMessage("安全问题回答错误!");
        } else {
            Integer flag = userService.updatePswdById(id, newPswd);
            if (flag == 1) {
                return MessageAndData.success().setMessage("密码更新成功!");
            } else {
                return MessageAndData.success().setMessage("密码更新失败!");
            }
        }
    }

    @RequestMapping(value="/forbiden/{num}",method = RequestMethod.POST)
    public MessageAndData forbidenUser(@PathVariable("num")Integer id){
        Integer flag=forbidenedUserService.insertUser(id);
        if(flag==1){
            return MessageAndData.success().setMessage("成功禁言!");
        }
        else{
            return MessageAndData.success().setMessage("禁言失败!");
        }
    }

    @RequestMapping(value="/unforbiden/{num}",method = RequestMethod.POST)
    public MessageAndData unforbidenUser(@PathVariable("num")Integer id){
        Integer flag=forbidenedUserService.deleteByUserId(id);
        if(flag==1){
            return MessageAndData.success().setMessage("解禁成功!");
        }
        else{
            return MessageAndData.success().setMessage("解禁失败!");
        }
    }

    @RequestMapping(value="/check/reportedPost",method = RequestMethod.GET)
    public List<Post> checkReportedPost(){
        List<Integer> postIds=reportedPostService.getPostId();
        List<Post> posts=new ArrayList<>();
        for(Integer postId:postIds){
            Post post=postService.selectById(postId);
            posts.add(post);
        }
        return posts;
    }

    @RequestMapping(value="opt/deletePost",method = RequestMethod.POST)
    public MessageAndData deleteAPost(@RequestParam("postId")Integer postId){
        Integer flag1=reportedPostService.deleteByPostId(postId);
        Integer flag3=messageService.deleteByPostId(postId);
        Integer flag2=postService.deleteById(postId);
        if(flag1>=1&&flag2>=1){
            return MessageAndData.success().setMessage("删除成功!");
        }
        else{
            return MessageAndData.success().setMessage("删除失败!");
        }
    }

    @RequestMapping(value="opt/refuseDelete",method = RequestMethod.POST)
    public MessageAndData refuseAPost(@RequestParam("postId")Integer postId){
        Integer flag1=reportedPostService.deleteByPostId(postId);
        if(flag1>=1){
            return MessageAndData.success().setMessage("拒绝成功!");
        }
        else{
            return MessageAndData.success().setMessage("拒绝失败!");
        }
    }
    
    
}
