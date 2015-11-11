package com.erikle2.childmanagement.utils;

import com.erikle2.childmanagement.login.views.ITalkToLoginActivity;

/**
 * Created by Erik on 04/11/2015.
 */
public class LoginValidator {
    public static boolean validateCredentials(String email, String password, ITalkToLoginActivity iTalkToLoginActivity){
        boolean valid = true;
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            iTalkToLoginActivity.invalidEmail();
            valid = false;
        }
        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            valid = false;
            iTalkToLoginActivity.invalidPassword();
        }
        return valid;
    }
}
