package com.example.login_demo.controller;

import com.example.login_demo.entity.tStudent;
import com.example.login_demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author wjb
 * @Date 2021-03-26
 */

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private UserService userService;
    //通过学号获取用户信息
    @RequestMapping("/getUser/{id}")
    public String getUser(@PathVariable String id){
        System.out.println(userService.Sel(id).toString());
        return userService.Sel(id).toString();
    }

    //通过学号删除用户信息
    @RequestMapping("/delById")
    public String delById(String studentCode) {
        int result = Integer.valueOf(userService.delById(studentCode));
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    //通过学号获取修改用户密码
    @RequestMapping("/update")
    public String update(tStudent tstudent){
        System.out.println(tstudent);
        int result = userService.update(tstudent);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

        @GetMapping("/findStudent")
        public PageInfo<tStudent> findStudent(tStudent t, @RequestParam int pageCount,@RequestParam int pageSize){
            return userService.findStudent(t,pageCount,pageSize);
        }

}
