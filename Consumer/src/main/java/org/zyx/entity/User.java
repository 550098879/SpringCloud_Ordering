package org.zyx.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by SunShine on 2020/4/28.
 */
@Data
public class User {

    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;      //性别
    private String telephone;
    private Date registerdate; //注册日期
    private String address;

}
