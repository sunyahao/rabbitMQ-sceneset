package com.sunhao.rabbitmqlog.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.sunhao.rabbitmqlog.bean.UserLog;
import com.sunhao.rabbitmqlog.config.MQConfig;
import com.sunhao.rabbitmqlog.mapper.UserLogMapper;
import com.sunhao.rabbitmqlog.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author SunYaHao
 * @version 1.0
 * @date 2020/3/17  16:07
 */
@Service
public class MQLogReceiver {

    private static final Logger log = LoggerFactory.getLogger(MQLogReceiver.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserLogMapper userLogMapper;

    @RabbitListener(queues = MQConfig.LOG_USER_QUEUE_NAME)
    @Transactional
    public void receiveUserLog(String message){
        System.out.println("receive message   "+message);
        UserLog userLog = JSON.toJavaObject(JSON.parseObject(message),UserLog.class);
        Long id = userLog.getId();
        Date date = userLog.getLoginDate();
        String nickname = userLog.getNickname();
        userMapper.update(userLog);
        userLogMapper.insert(userLog);
    }
}
