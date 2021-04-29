package com.example.login_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ApiModel(value="TStudent对象", description="账户信息表")
public class tStudent {

    //private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "student_id", type = IdType.AUTO)
    private Integer studentId;

    @ApiModelProperty(value = "学号",required = true,example = "20131105834")
    @TableField("student_code")
    private String studentCode;


    @ApiModelProperty(value = "密码",required = true)
    @TableField("student_pwd")
    private String studentPwd;

    //姓名
    @ApiModelProperty(value = "姓名",required = true,example = "刘梅")
    @TableField("student_name")
    private String studentName;

    //学生性别
    @ApiModelProperty(value = "性别",required = true,example = "女")
    @TableField("student_sex")
    private String studentSex;

    //学生生日
    @ApiModelProperty(value = "生日",required = true,example = "2000-11-05")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("student_birthday")
    private LocalDate studentBirthday;

    //学生年级
    @ApiModelProperty(value = "年级",required = true,example = "2019")
    @TableField("student_grade")
    private String studentGrade;

    //学生班级
    @ApiModelProperty(value = "班级",required = true,example = "视觉传达与艺术")
    @TableField("student_class")
    private String studentClass;

    //学生专业
    @ApiModelProperty(value = "专业",required = true,example = "数字媒体专业")
    @TableField("student_major")
    private String studentMajor;

    //学生所属学院
    @ApiModelProperty(value = "学院",required = true,example = "国际现代艺术交流学院")
    @TableField("student_college")
    private String studentCollege;

    //教职工类型
    @ApiModelProperty(value = "类型(本科/研究生/教职工)",required = true,example = "本科")
    @TableField("student_type")
    private String studentType;

    //积分
    @ApiModelProperty(value = "积分")
    @TableField("student_score")
    private Integer studentScore;

    //账户状态
    @ApiModelProperty(value = "账户状态")
    @TableField("student_status")
    private String studentStatus;

    //绑定手机
    @ApiModelProperty(value = "绑定手机")
    @TableField("student_phone")
    private String studentPhone;

    //绑定邮箱
    @ApiModelProperty(value = "绑定邮箱")
    @TableField("student_email")
    private String studentEmail;

    //创建方式
    @ApiModelProperty(value = "创建方式",hidden = true)
    @TableField("create_type")
    private String createType;

    //注册时间
    @ApiModelProperty(value = "注册时间",hidden = true)
    @TableField("create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


}
