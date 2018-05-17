package space.nicxia.serviceImpl;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import space.nicxia.dao.ContactDao;
import space.nicxia.dao.UserDao;
import space.nicxia.dto.ContactVo;
import space.nicxia.dto.UserVo;
import space.nicxia.entity.*;
import space.nicxia.service.UserService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ContactDao contactDao;

    @Transactional
    public int insertUserVo(UserVo userVo) {
        User user = userVo.getUser();
        UserInfo userInfo = userVo.getUserInfo();
        UserPassword userPassword = userVo.getUserPassword();
        userDao.insertUser(user);
        int userId = user.getUserId();
        userInfo.setUserId(userId);
        userDao.insertUserInfo(userInfo);
        userPassword.setUserId(userId);
        userDao.insertPasswordByUserPassword(userPassword);
        return userId;
    }

    @Transactional
    public void updateUserByUservo(UserVo userVo) {
        User user = userVo.getUser();
        UserInfo userInfo = userVo.getUserInfo();
        userDao.updateUserByUser(user);
        userDao.updateUserInfoByUserInfo(userInfo);
    }

    @Transactional
    public void updateUserPasswordByUserVo(UserVo userVo) {
        UserPassword userPassword = userVo.getUserPassword();
        userDao.updateUserPasswordByUserPassword(userPassword);
    }

    @Transactional
    public boolean checkUserPasswordByUserVo(UserVo userVo) {
        String userPassword = userVo.getUserPassword().getUserPassword();//获得传入的密码
        int userId = userVo.getUserPassword().getUserId();
        String truePassword = userDao.getUserPasswordByUserId(userId);
        if(truePassword.equals(userPassword)) {
            return true;
        } else return false;
    }

    @Transactional
    public UserVo getUserVoByUserVo(UserVo userVo) {
        int userId = userVo.getUser().getUserId();
        return userDao.getUserVoByUserId(userId);
    }

    @Transactional
    public List<ContactVo> getContactVosByUserVo(UserVo userVo) {
        int userId = userVo.getUser().getUserId();
        List<Integer> contactIds = contactDao.getContactIdsByUserId(userId);
        List<ContactVo> contactVos = new ArrayList<ContactVo>();
        Iterator<Integer> itr = contactIds.iterator();
        while(itr.hasNext()) {
            ContactVo contactVo = contactDao.getContactVoByContactId(itr.next());
            if(contactVo != null) {
                contactVos.add(contactVo);
            }
        }
        return contactVos;
    }

    @Transactional
    public void insertContactVoByContactVo(ContactVo contactVo) {
        Contact contact = contactVo.getContact();
        List<ContactInfo> contactInfos = contactVo.getContactInfos();
        if(contact.getContactId() == 0) { //还没有通讯录，需要先添加通讯录
            contactDao.insertContactByContact(contact);
        }
        int contactId = contact.getContactId();
        for(int i = 0; i < contactInfos.size(); i++) {
            contactInfos.get(i).setContactId(contactId);
            contactDao.insertContactInfoByContactInfo(contactInfos.get(i));
        }
    }

    @Transactional
    public void updateContactVoByContactVo(ContactVo contactVo) {
        Contact contact = contactVo.getContact();
        List<ContactInfo> contactInfos = contactVo.getContactInfos();
        contactDao.updateContactByContact(contact);
        for(int i = 0; i < contactInfos.size(); i++) {
            contactDao.updateContactInfoByContactInfo(contactInfos.get(i));
        }
    }

}
