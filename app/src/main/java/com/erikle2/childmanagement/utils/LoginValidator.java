package com.erikle2.childmanagement.utils;

import com.erikle2.childmanagement.views.ILoginView;

/**
 * Created by Erik on 04/11/2015.
 */
public class LoginValidator {
    public static boolean validateCredentials(String email, String password, ILoginView iLoginView){
        boolean valid = true;
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            iLoginView.invalidEmail();
//            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
//            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
//            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
            iLoginView.invalidPassword();
        } else {
//            _passwordText.setError(null);
        }

        return valid;
    }
}
