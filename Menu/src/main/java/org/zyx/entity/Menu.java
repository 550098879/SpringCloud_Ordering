package org.zyx.entity;

import lombok.Data;

/**
 * Created by SunShine on 2020/4/27.
 */
@Data
public class Menu {

    private long id;
    private String name;
    private double price;
    private String flavor;  //口味
    private int tid;
    private Type type;//类型


}
