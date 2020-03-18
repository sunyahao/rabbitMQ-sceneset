package com.sunhao.rabbitmqlog.mapper;

import com.sunhao.rabbitmqlog.bean.User;
import com.sunhao.rabbitmqlog.bean.UserLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author SunYaHao
 * @version 1.0
 * @date 2020/3/17  14:56
 */
@Mapper
public interface UserMapper {


    @Select("select * from user where id = #{id}")
    public User getById(@Param("id")long id);

    /**
     * 更新user表中最后一次登录时间并将登录次数+1
     * @param userLog
     */
    @Update("update user set last_login_date = #{loginDate},login_count = login_count+1 where id = #{id}")
    public void update(UserLog userLog);
}
