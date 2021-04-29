package com.example.login_demo.service;

import com.example.login_demo.entity.tStudent;
import com.example.login_demo.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public tStudent Sel(String student_code){
        return userMapper.Sel(student_code);
    }

    public tStudent login(String userName, String passWord) {
        return userMapper.login(userName,passWord);
    }

    public int register(tStudent tstudent){
        return userMapper.register(tstudent);
    }


    public int  delById(String student_code){
        return userMapper.delById(student_code);
    }

    public int update(tStudent tstudent){
        return userMapper.update(tstudent);
    }

    public List<tStudent> selectByCode(String student_code){
        return userMapper.selectByCode(student_code);
    }

    public PageInfo<tStudent> findStudent(tStudent t,int pageCount,int pageSize){
        PageHelper.startPage(pageCount,pageSize);
        List<tStudent> studentList = userMapper.findStudentList(t, pageCount, pageSize);
        return new PageInfo<>(studentList);
    }
}
