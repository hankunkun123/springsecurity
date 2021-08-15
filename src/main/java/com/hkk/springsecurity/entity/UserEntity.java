package com.hkk.springsecurity.entity;

import lombok.Data;

/**
 * @author hankunkun
 * @version 1.0
 * @date 2021/8/14 17:37
 */

@Data
public class UserEntity {
    private Integer id;
    private String userName;
    private String password;
}
