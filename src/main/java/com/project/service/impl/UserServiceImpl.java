package com.project.service.impl;

import com.project.mapper.UserDataMapper;
import com.project.mapper.UserMapper;
import com.project.po.User;
import com.project.po.UserData;
import com.project.po.UserDataExample;
import com.project.po.UserExample;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Bright_ on 2017/6/7.
 */
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDataMapper userDataMapper;


    public boolean checkUserInfo(String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> result = userMapper.selectByExample(example);
        if(result.size()>0){
            return true;
        }else{
            return false;
        }
    }

    public int getUserId(String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> result = userMapper.selectByExample(example);
        return result.get(0).getUserId();
    }

    public List<UserData> getUserDataById(int id) {
        UserDataExample example = new UserDataExample();
        example.createCriteria().andUserIdEqualTo(id);
        return userDataMapper.selectByExample(example);

    }

    public User getUserById(int id) {
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(id);
        List<User> userList = userMapper.selectByExample(example);
        return userList.get(0);
    }

    /**
     * check username exits
     * @param username
     * @return
     */
    public boolean checkUserName(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(example);
        if (userList.size()>0){
            return false;
        }else{
            return true;
        }
    }

}
