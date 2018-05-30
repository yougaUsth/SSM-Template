package com.project.controller;

import com.project.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userservice;

    @RequestMapping(value = "/main",method = RequestMethod.POST)
    public String login(@RequestParam(value = "username")String username,@RequestParam(value = "password")String password) {

        boolean result = userservice.checkUserInfo(username, password);
        if(result){
            return "/user/dashboard";
        }else{
            return "/user/index";
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

}
