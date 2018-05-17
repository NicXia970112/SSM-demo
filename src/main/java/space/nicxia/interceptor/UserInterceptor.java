package space.nicxia.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import space.nicxia.dto.UserVo;
import space.nicxia.entity.UserPassword;
import space.nicxia.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(httpServletRequest.getMethod().equals("POST") && (httpServletRequest.getRequestURI().equals("/contacts") || httpServletRequest.getRequestURI().equals("/users")) ) {
            return true;
        }
        if(httpServletRequest.getRequestURI().equals("/users") || httpServletRequest.getRequestURI().equals("/contacts")) {
            String userId = httpServletRequest.getHeader("UserId");
            String userPassword = httpServletRequest.getHeader("UserPassword");
            System.out.println(userId + userPassword);
            UserPassword password = new UserPassword();
            password.setUserId(Integer.parseInt(userId));
            password.setUserPassword(userPassword);
            UserVo userVo = new UserVo();
            userVo.setUserPassword(password);
            if(userService.checkUserPasswordByUserVo(userVo)) { //提交的身份存在且有效，再检查请求的路径是否合法
                if(httpServletRequest.getMethod().equals("GET")) {
                    int id = Integer.parseInt(httpServletRequest.getParameter("id"));
                    if(id == Integer.parseInt(userId)) { //判断请求的资源与身份是否一致
                        return true;
                    } else return false;
                }
                if(httpServletRequest.getMethod().equals("PUT")) {
                    return true; //只要身份通过，放行再判断资源和身份是否一致
                }
            }
        }

        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
