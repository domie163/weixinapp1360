package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 老人保险缴费：(ElderlyInsurancePayment)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ElderlyInsurancePayment")
public class ElderlyInsurancePayment implements Serializable {

    // ElderlyInsurancePayment编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "elderly_insurance_payment_id")
    private Integer elderly_insurance_payment_id;

    // 保险名称
    @Basic
    private String insurance_name;
    // 保险类型
    @Basic
    private String insurance_type;
    // 保险价格
    @Basic
    private String insurance_price;
    // 购买用户
    @Basic
    private Integer purchasing_users;
    // 用户姓名
    @Basic
    private String user_name;
    // 购买日期
    @Basic
    private Timestamp purchase_date;
    // 备注信息
    @Basic
    private String remarks;




    // 支付状态
    @Basic
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @Basic
    private String pay_type;










    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
