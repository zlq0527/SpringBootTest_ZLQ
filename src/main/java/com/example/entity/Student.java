package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ Author     ：赵棱泉.
 * @ Date       ：Created in 09:15 2022/2/14
 * @ Description：
 */
@Data
public class Student implements Serializable {

    private Integer id;

    private String name;

    private Integer price;
}
