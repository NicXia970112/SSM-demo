package space.nicxia.web;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.RequestPartServletServerHttpRequest;
import space.nicxia.dto.ContactVo;
import space.nicxia.dto.UserVo;
import space.nicxia.entity.*;
import space.nicxia.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public @ResponseBody UserVo indexUser(HttpServletRequest request) { //获取用户信息
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = new User();
        user.setUserId(userId);
        UserVo userVo = new UserVo();
        userVo.setUser(user);
        UserVo userVoResponse = userService.getUserVoByUserVo(userVo);
        return userVoResponse;
    }

    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserVo userVo, HttpServletRequest httpServletRequest){ //编辑用户信息
        int userId = Integer.parseInt(httpServletRequest.getHeader("UserId"));
        if((userVo.getUser().getUserId() == userId) && (userVo.getUserInfo().getUserId() == userId)) { //确认身份和权限一致
            userService.updateUserByUservo(userVo);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void insertUser(@RequestBody UserVo userVo) { //注册用户
        userService.insertUserVo(userVo);
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public @ResponseBody List<ContactVo> indexContactVos(HttpServletRequest request) { //获取用户相关通讯鲁
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = new User();
        user.setUserId(userId);
        UserVo userVo = new UserVo();
        userVo.setUser(user);
        List<ContactVo> contactVos = userService.getContactVosByUserVo(userVo);
        return contactVos;
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public void insertContactOrContactInfo(@RequestBody ContactVo contactVo) { //添加通讯录
        userService.insertContactVoByContactVo(contactVo);
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.PUT)
    public void updateContactOrContactInfo(@RequestBody ContactVo contactVo, HttpServletRequest httpServletRequest) { //编辑通讯录
        int userId = Integer.parseInt(httpServletRequest.getHeader("UserId"));
        if(contactVo.getContact().getUserId() == userId) { //确认身份和访问权限一致
            userService.updateContactVoByContactVo(contactVo);
        }
    }

}
