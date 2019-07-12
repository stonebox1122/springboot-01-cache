package com.stone.springboot.bean;

import lombok.*;

import java.io.Serializable;

/**
 * @author stone
 * @date 2019/7/11 14:03
 * description
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Dept implements Serializable {
    private Integer id;
    private String deptName;
}

