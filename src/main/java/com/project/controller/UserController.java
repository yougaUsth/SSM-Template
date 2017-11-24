package com.project.controller;

import com.project.po.User;
import com.project.po.UserData;
import com.project.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bright_ on 2017/6/7.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userservice;
    @RequestMapping(value = "/index")
    public String indexView() {
        return "user/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request,@RequestParam(value = "username")String username,@RequestParam(value = "password")String password) {
        List list = new ArrayList();
        boolean result = userservice.checkUserInfo(username,password);
        if(result){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            int user_id = userservice.getUserId(username,password);
            List<UserData> userdata = userservice.getUserDataById(user_id);
            for (UserData udata:userdata) {
                list.add(udata.getData());
            }
            request.setAttribute("userdata",list);
            return "user/main";
        }else{
            request.setAttribute("msg","user login error");
            return "user/login";
        }
    }
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String fileUpload(MultipartFile file){
        try{
            FileUtils.writeByteArrayToFile(new File("E:/file/"+file.getOriginalFilename()),file.getBytes());
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/index2",produces = "application/json;charset=UTF-8")
    public @ResponseBody String login1(HttpServletRequest request){
        int user_id = userservice.getUserId("admin","password");
        User user = userservice.getUserById(user_id);
        return "{url:"+"'"+request.getRequestURL()+" can access' , user_id:"+user_id+", user_telphone :"+user.getTelephone()+"}";
    }
    @RequestMapping(value = "/check",method = RequestMethod.GET)
    public @ResponseBody String checkUserName(@RequestParam(value = "username")String username){
        boolean result = userservice.checkUserName(username);
        System.out.println("username------"+username);
        if(result) {
            return "{res:'true'}";
        }else{
            return "{res:'false'}";
        }
    }

}
