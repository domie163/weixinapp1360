package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 养老保险：(EndowmentInsurance)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EndowmentInsurance")
public class EndowmentInsurance implements Serializable {

    // EndowmentInsurance编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endowment_insurance_id")
    private Integer endowment_insurance_id;

    // 保险名称
    @Basic
    private String insurance_name;
    // 保险类型
    @Basic
    private String insurance_type;
    // 封面图片
    @Basic
    private String cover_photo;
    // 保险价格
    @Basic
    private String insurance_price;
    // 保险详情
    @Basic
    private String insurance_details;

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
