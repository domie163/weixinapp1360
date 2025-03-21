package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 老人信息：(ElderlyInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ElderlyInformation")
public class ElderlyInformation implements Serializable {

    // ElderlyInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "elderly_information_id")
    private Integer elderly_information_id;

    // 老人用户
    @Basic
    private Integer elderly_users;
    // 老人家属
    @Basic
    private Integer family_members_of_the_elderly;
    // 姓名
    @Basic
    private String full_name;
    // 性别
    @Basic
    private String gender;
    // 年龄
    @Basic
    private String age;
    // 身份证号
    @Basic
    private String id_number;
    // 联系方式
    @Basic
    private String contact_information;
    // 家庭住址
    @Basic
    private String home_address;
    // 备注信息
    @Basic
    private String remarks;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
