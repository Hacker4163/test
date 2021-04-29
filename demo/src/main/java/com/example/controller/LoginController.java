package com.example.controller;



import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;


    //登陆操作
    @ResponseBody
    @PostMapping("/loginUser")
    public String login(User user, HttpServletRequest request){
        String userName = user.getUserName();
        String password = user.getPassWord();
        User u1 = userService.login(userName,password);
        if(u1==null){
            return "用户名或密码错误";
        }else {
            request.getSession().setAttribute("session_user", user);//登陆成功后将用户放入session中，用于后续的拦截
            return "登陆成功";
        }
    }

    //注册操作
    @RequestMapping("/register")
    public String register(User tstudent){
        List<User> list = userService.selectByName(tstudent.getUserName());
        if(list.size()==0){
            int su = userService.register(tstudent);
            if(su == 0){
                System.out.println("--------");
            }
            String i ="注册成功\n"+"username:"+ tstudent.getUserName()+"\npassword:"+ tstudent.getPassWord();
            return i;
        }
        return "用户已注册";
    }


    //退出登录
    @RequestMapping("/outUser")
    public void outUser(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.getSession().removeAttribute("session_user");
        response.sendRedirect("/user/toIndex");
        System.out.println("退出");
    }
}
