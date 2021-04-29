package com.example.login_demo.mapper;

import com.example.login_demo.entity.tStudent;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Select("select *from t_student where student_code=#{studentCode}")
    tStudent Sel(String student_code);

    @Select("select *from t_student where student_code = #{param1} and student_pwd = #{param2}")
    tStudent login(String student_code, String student_pwd);

    @Insert("insert into t_student " +
            "(student_code,student_pwd," +
            "student_name,student_sex," +
            "student_birthday,student_grade," +
            "student_class,student_major," +
            "student_college,student_type," +
            "student_status,student_phone," +
            "student_email,create_type,create_time) " +
            "values (#{studentCode},#{studentPwd}," +
            "#{studentName},#{studentSex}," +
            "#{studentBirthday},#{studentGrade}," +
            "#{studentClass},#{studentMajor}," +
            "#{studentCollege},#{studentType}," +
            "#{studentStatus},#{studentPhone}," +
            "#{studentEmail},#{createType},#{createTime})")
    int register(tStudent tstudent);

    @Delete("delete from t_student where student_code=#{studentCode}")
    int delById(String student_code);

    @Update("update t_student set student_pwd=#{studentPwd} where student_code=#{studentCode}")
    int update(tStudent tstudent);

    @Select("select *from t_student where student_code=#{studentCode}")
    List<tStudent> selectByCode(String student_code);

    @Select("select *from t_student")
    List<tStudent> findStudentList(@Param("param") tStudent t,int pageCount,int pageSize);
}
