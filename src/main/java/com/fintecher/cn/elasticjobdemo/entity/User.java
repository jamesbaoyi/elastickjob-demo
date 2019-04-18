package com.fintecher.cn.elasticjobdemo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/18 14:41
 * @Description:
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private Long id;

    private String city;

    private String name;

}
