package com.erikle2.childmanagement.views;

/**
 * Created by Erik on 04/11/2015.
 */
public interface ILoginView {
    void onSuccess();
    void onFalure();
    void invalidEmail();
    void invalidPassword();
}
