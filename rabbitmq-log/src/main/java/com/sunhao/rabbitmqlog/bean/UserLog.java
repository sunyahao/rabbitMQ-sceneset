package com.sunhao.rabbitmqlog.bean;

import java.util.Date;

/**
 * @author SunYaHao
 * @version 1.0
 * @date 2020/3/17  15:07
 */
public class UserLog {

    private Long id;
    private String nickname;
    private Date loginDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
