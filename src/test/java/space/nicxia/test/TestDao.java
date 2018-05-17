package space.nicxia.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import space.nicxia.dao.ContactDao;
import space.nicxia.dao.UserDao;
import space.nicxia.dto.ContactVo;
import space.nicxia.dto.UserVo;
import space.nicxia.entity.*;
import space.nicxia.service.UserService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDao extends BaseTest {

    @Autowired
    public UserDao userDao;

    @Autowired
    public ContactDao contactDao;

    @Autowired
    public UserService userService;

    @Test
    public void test() {


    }

}
