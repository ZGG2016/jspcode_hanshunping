package com.example.myshopping.service;

import com.example.myshopping.domain.Users;
import com.example.myshopping.util.SqlHelper;

import java.util.ArrayList;

// 处理和userss表相关的业务逻辑
public class UserService {

    // 验证用户是否合法
    public boolean checkUser(Users user){

        String sql = "select * from userss where id=? and passwd=?";
        String[] params = {String.valueOf(user.getId()), user.getPasswd()};

        ArrayList al = new SqlHelper().executeQuery(sql, params);
        if(al.size()==0){
            return false;
        }else{
            Object[] object = (Object[]) al.get(0);
            user.setName(object[1].toString());
            user.setEmail(object[3].toString());
            user.setGrade(Integer.parseInt(object[5].toString()));
            return true;
        }
    }
}
