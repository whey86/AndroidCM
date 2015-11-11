package com.erikle2.childmanagement.login.presenters;

import com.erikle2.childmanagement.utils.LoginValidator;
import com.erikle2.childmanagement.login.views.ITalkToLoginActivity;

/**
 * Created by Erik on 04/11/2015.
 */
public class LoginController {

    /**
     * Reference to view, used to update view
     */
    private ITalkToLoginActivity loginView;

    /**
     * Constuctor requiers ref to view
     * @param loginView
     */
    public LoginController(ITalkToLoginActivity loginView) {
        this.loginView = loginView;
    }

    /**
     * Method to validate username and password, update UI and proceed with login.
     * @param username
     * @param password
     */
    public void validateCredentials(String username, String password) {
            if(LoginValidator.validateCredentials(username,password,loginView)){
                //TODO Networkrequest for authenticating username and password
                loginView.onSuccess();
            }else{
                loginView.onFalure();
            }
    }
}
