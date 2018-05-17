package space.nicxia.dao;

import space.nicxia.dto.UserVo;
import space.nicxia.entity.User;
import space.nicxia.entity.UserInfo;
import space.nicxia.entity.UserPassword;

public interface UserDao {


    /*
    *User CURD
    * */

    public void insertUser(User user);

    public void deleteUserByUserId(int userId);

    public UserVo getUserVoByUserId(int userId);

    public void updateUserByUser(User user);


    /*
     *UserInfo CURD
     * */

    public void updateUserInfoByUserInfo(UserInfo userInfo);

    public void insertUserInfo(UserInfo userInfo);


    /*
     *UserPassword CURD
     * */

    public String getUserPasswordByUserId(int userId);

    public void updateUserPasswordByUserPassword(UserPassword userPassword);

    public void insertPasswordByUserPassword(UserPassword userPassword);

}
