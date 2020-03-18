package com.sunhao.rabbitmqlog.mapper;

import com.sunhao.rabbitmqlog.bean.UserLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author SunYaHao
 * @version 1.0
 * @date 2020/3/17  15:16
 */
@Mapper
public interface UserLogMapper {

    @Insert("insert into userlog(id,login_date) values(${id},#{loginDate})")
    public void insert(UserLog userLog);
}
