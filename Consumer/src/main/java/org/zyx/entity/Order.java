package org.zyx.entity;


import lombok.Data;

import java.util.Date;

/**
 * Created by SunShine on 2020/4/28.
 */
@Data
public class Order {

    private long id;
    private User user;
    private Menu menu;
    private Admin admin;

    private Date date;
    private int state;


}
