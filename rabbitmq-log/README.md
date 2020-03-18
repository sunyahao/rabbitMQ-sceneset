## 系统介绍
***
本项目是多个RabbitMQ应用场景下的系统集合，这些场景包括异步处理、应用
解耦以及流量削峰，对应的系统分别是简易用户登录日志系统、秒杀系统。
<br/><br/>
## 开发工具
***
IntelliJ IDEA + Navicat for MySQL+  Git + Chrome
<br/><br/>
## 压测工具
***
JMeter
<br/><br/>
## 开发技术
***
前端技术：Bootstrap + jQuery + Thymeleaf <br/>
后端技术 ：SpringBoot + MyBatis + MySQL <br/>
中间件技术 : Druid + Redis + RabbitMQ <br/>
<br/>
## RabbitMQ应用场景结合项目介绍
#### 1、异步处理与简易用户登录日志系统
场景简介：用户登录后，系统需要添加用户登录日志和更新用户登录次数与最后一次登录时间。<br/><br/>
业务逻辑介绍：用户登录后，将生成用户登录日志写入消息队列中，消息队列再将日志更新到数据库中。
