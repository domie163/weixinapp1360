package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 服务分类：(ServiceClassification)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ServiceClassification")
public class ServiceClassification implements Serializable {

    // ServiceClassification编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_classification_id")
    private Integer service_classification_id;

    // 服务类型
    @Basic
    private String service_type;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
