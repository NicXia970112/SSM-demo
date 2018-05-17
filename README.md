# SSM入门demo
## 介绍
前段时间学习了ssm框架，正好近期学校有个相关的作业，就使用了这套框架进行服务端的开发，我选择了RESTful接口的方式，也就是说，这个项目甚至不需要前端的页面也可以测试，因此，这是一个非常迷你的demo，但是入门ssm的大部分知识点都涉及了。希望对想要学习这个框架的同学提供一些参考，更希望得到大家的指正。
## 实现功能
- 客户端可通过提供的url接口对资源进行增删查改
- 对url做了一些简单的认证和权限管理
## 技术栈
```bash
Tomcat + Spring + SpringMVC + Mybatis + Mysql 
```
## 运行方式
```bash
# 将/out/artifacts/Contact_war文件夹解压到tomcat的/webapps目录，删除原有的ROOT文件夹，并重命名为ROOT。

# 进入tomcat的bin目录，linux运行./startup.sh,windows运行startup.bat。

```
