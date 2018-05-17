package space.nicxia.service;

import org.springframework.transaction.annotation.Transactional;
import space.nicxia.dao.UserDao;
import space.nicxia.dto.ContactVo;
import space.nicxia.dto.UserVo;

import java.util.List;

public interface UserService {

    public int insertUserVo(UserVo userVo); //添加用户 返回用户Id

    public void updateUserByUservo(UserVo userVo); //编辑用户信息

    public void updateUserPasswordByUserVo(UserVo userVo); //更改密码

    public boolean checkUserPasswordByUserVo(UserVo userVo); //验证密码

    public UserVo getUserVoByUserVo(UserVo userVo); //根据用户Id获得用户信息

    public List<ContactVo> getContactVosByUserVo(UserVo userVo);//返回用户对应的所有通讯录及其包含的联系人

    public void insertContactVoByContactVo(ContactVo contactVo); //添加通讯录及其联系人

    public void updateContactVoByContactVo(ContactVo contactVo); //编辑联系人

}
