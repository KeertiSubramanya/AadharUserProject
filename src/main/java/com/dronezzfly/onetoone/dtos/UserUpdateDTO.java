package com.dronezzfly.onetoone.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdateDTO {

    private Integer userId;
    private String userName;
    private Long aadharNumber;
}
