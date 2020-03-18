package com.sunhao.rabbitmqlog.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunhao.rabbitmqlog.bean.User;
import com.sunhao.rabbitmqlog.bean.UserLog;
import com.sunhao.rabbitmqlog.config.MQConfig;
import com.sunhao.rabbitmqlog.rabbitmq.MQLogSender;
import com.sunhao.rabbitmqlog.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author SunYaHao
 * @version 1.0
 * @date 2020/3/17  16:18
 */
@Controller
@RequestMapping(value="/login")
public class LoginController {

    @Autowired
    private MQLogSender sender;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value="/do_login")
    @ResponseBody
    public Object toLogin(@RequestParam("username")String username,@RequestParam("password")String password)throws Exception{
        //将username数据类型转换为Long
        Long id = Long.parseLong(username);
        JSONObject data = new JSONObject();
        if(!userService.isUserExist(id)){
            data.put("message","用户不存在");
            throw new Exception("用户不存在");
        }
        User u = userService.getById(id);
        if(u.getPassword()!= password){
            data.put("message","密码错误");
        }
        UserLog userLog = new UserLog();
        userLog.setId(id);
        userLog.setLoginDate(new Date());
        //将用户日志和routingKey发送到指定的交换机上，由交换机根据相应规则选择路由到哪个队列里
        sender.sendUserLogMessage(userLog,MQConfig.LOG_USER_EXCHANGE_NAME,MQConfig.LOG_USER_ROUTING_KEY);
        data.put("message","日志已更新");
        return data;
    }
}
