package com.project.service;

import com.project.po.User;
import com.project.po.UserData;

import java.util.List;

/**
 * Created by Bright_ on 2017/6/7.
 */
public interface UserService {
    public boolean checkUserInfo(String username,String password);
    public int getUserId(String username,String password);
    public List<UserData> getUserDataById(int id);
    public User getUserById(int id);
    public boolean checkUserName(String username);
}
