package com.erikle2.childmanagement.presenters;

/**
 * Created by Erik on 04/11/2015.
 */
public class LoginPresenter implements ILoginPresenter {
    @Override
    public boolean validateCredentials(String username, String password) {
        return false;
    }
}
