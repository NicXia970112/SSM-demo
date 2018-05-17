package space.nicxia.dto;

import space.nicxia.entity.User;
import space.nicxia.entity.UserInfo;
import space.nicxia.entity.UserPassword;

public class UserVo {

    private User user;

    private UserInfo userInfo;

    private UserPassword userPassword;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserPassword getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(UserPassword userPassword) {
        this.userPassword = userPassword;
    }
}
