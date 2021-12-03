package com.lightlance.simpleauth.utils;

import android.util.Patterns;

public abstract class Validator {
    public static boolean validateEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean validateCharLength(String value, int requireLength) {
        return value.length() >= requireLength;
    }
}
