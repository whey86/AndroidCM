package com.erikle2.childmanagement;

import com.erikle2.childmanagement.activities.LoginActivity;
import com.erikle2.childmanagement.login.presenters.LoginController;
import com.erikle2.childmanagement.login.views.ITalkToLoginActivity;
import com.erikle2.childmanagement.utils.LoginValidator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Erik on 11/11/2015.
 */
public class LoginControllerUnitTest {

     private LoginController loginController;

     private LoginValidator loginValidator;
     private ITalkToLoginActivity iTalkToLoginActivity;

    private final String EMAIL = "erik@gmail.com";
    private final String PASSWORD = "pass1532";

    @Before public void setUp(){
        MockitoAnnotations.initMocks(this);
        iTalkToLoginActivity = mock(ITalkToLoginActivity.class);
        loginController = new LoginController(iTalkToLoginActivity);
        when(loginValidator.validateCredentials(EMAIL,PASSWORD,iTalkToLoginActivity)).thenReturn(true);

    }


    @Test
    public void LoginWithCorrectCredentials(){

        loginController.validateCredentials(EMAIL, PASSWORD);

        verify(iTalkToLoginActivity).onSuccess();
    }
    private void dummyMethod(){

    }
}
