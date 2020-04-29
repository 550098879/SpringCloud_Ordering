package org.zyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * Created by SunShine on 2020/4/27.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private int code;
    private String msg;
    private int count;
    private Collection<User> data;

}
