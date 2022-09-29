package com.project.dmsport.global.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RegexpProperty {

    public static final String EMAIL = "^.+@dsm.hs.kr$";

    public static final String PASSWORD = "(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+-=?/])[a-zA-Z0-9~!@#$%^&*()_+-=?/]{8,30}$";

}