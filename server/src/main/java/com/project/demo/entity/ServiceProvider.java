package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 服务商：(ServiceProvider)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ServiceProvider")
public class ServiceProvider implements Serializable {

    // ServiceProvider编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_provider_id")
    private Integer service_provider_id;

    // 公司名称
    @Basic
    private String corporate_name;
    // 公司地址
    @Basic
    private String company_address;
    // 用户姓名
    @Basic
    private String user_name;



    // 审核状态
    @Basic
    private String examine_state;









    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;


    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
