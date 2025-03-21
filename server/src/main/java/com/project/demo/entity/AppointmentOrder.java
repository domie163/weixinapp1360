package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 预约订单：(AppointmentOrder)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "AppointmentOrder")
public class AppointmentOrder implements Serializable {

    // AppointmentOrder编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_order_id")
    private Integer appointment_order_id;

    // 订单编号
    @Basic
    private String order_number;
    // 公司名称
    @Basic
    private String corporate_name;
    // 服务名称
    @Basic
    private String service_name;
    // 服务类型
    @Basic
    private String service_type;
    // 服务价格
    @Basic
    private String service_price;
    // 预约用户
    @Basic
    private Integer appointment_users;
    // 用户姓名
    @Basic
    private String user_name;
    // 老人用户
    @Basic
    private Integer elderly_users;
    // 预约时间
    @Basic
    private Timestamp time_of_appointment;
    // 预约备注
    @Basic
    private String appointment_notes;
    // 订单状态
    @Basic
    private String order_status;




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
