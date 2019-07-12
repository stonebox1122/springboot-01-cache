package com.stone.springboot.bean;

import lombok.*;

import java.io.Serializable;

/**
 * @author stone
 * @date 2019/7/11 13:58
 * description
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Emp implements Serializable {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;
}
