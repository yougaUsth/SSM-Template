package com.project.mapper;

import com.project.po.UserData;
import com.project.po.UserDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDataMapper {
    int countByExample(UserDataExample example);

    int deleteByExample(UserDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserData record);

    int insertSelective(UserData record);

    List<UserData> selectByExample(UserDataExample example);

    UserData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserData record, @Param("example") UserDataExample example);

    int updateByExample(@Param("record") UserData record, @Param("example") UserDataExample example);

    int updateByPrimaryKeySelective(UserData record);

    int updateByPrimaryKey(UserData record);
}