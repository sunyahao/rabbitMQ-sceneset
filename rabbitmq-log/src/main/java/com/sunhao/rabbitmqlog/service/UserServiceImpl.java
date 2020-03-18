package com.sunhao.rabbitmqlog.service;

import com.sunhao.rabbitmqlog.bean.User;
import com.sunhao.rabbitmqlog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SunYaHao
 * @version 1.0
 * @date 2020/3/17  17:50
 */
@Service
public class UserServiceImpl {

    @Autowired
    private UserMapper userMapper;

    public User getById(Long id){
        if(id != null){
            return userMapper.getById(id);
        }
        return null;
    }

    public Boolean isUserExist(Long id){
        if(userMapper.getById(id) == null) return false;
        return true;
    }
}
