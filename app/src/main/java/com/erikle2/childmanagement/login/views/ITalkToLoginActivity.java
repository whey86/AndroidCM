package com.erikle2.childmanagement.login.views;

/**
 * Created by Erik on 04/11/2015.
 */
public interface ITalkToLoginActivity {
    void onSuccess();
    void onFalure();
    void invalidEmail();
    void invalidPassword();
}
