package com.sunhao.rabbitmqlog.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.sunhao.rabbitmqlog.bean.UserLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SunYaHao
 * @version 1.0
 * @date 2020/3/17  15:56
 */
@Service
public class MQLogSender {

    private static final Logger log = LoggerFactory.getLogger(MQLogSender.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendUserLogMessage(UserLog userLog,String exchange,String routingKey){
        String message = new String();
        if(log != null){
            message = JSON.toJSONString(userLog);
        }
        log.info("send message:  "+message);
        amqpTemplate.convertAndSend(exchange,routingKey,message);
    }
}
