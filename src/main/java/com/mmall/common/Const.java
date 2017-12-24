package com.mmall.common;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by apple on 2017/12/23.
 */
public class Const {

    public static final String currentUser = "currentUser";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";

    public interface Role {
        int ROLE_CUSTOMER = 0;
        int ROLE_ADMIN = 1;
    }
}
