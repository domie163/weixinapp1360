package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 生活服务：(LifeServices)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "LifeServices")
public class LifeServices implements Serializable {

    // LifeServices编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "life_services_id")
    private Integer life_services_id;

    // 服务商
    @Basic
    private Integer service_provider;
    // 公司名称
    @Basic
    private String corporate_name;
    // 服务名称
    @Basic
    private String service_name;
    // 服务类型
    @Basic
    private String service_type;
    // 封面图片
    @Basic
    private String cover_photo;
    // 服务价格
    @Basic
    private String service_price;
    // 服务详情
    @Basic
    private String service_details;

    // 点击数
    @Basic
    private Integer hits;

    // 点赞数
    @Basic
    private Integer praise_len;












    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
