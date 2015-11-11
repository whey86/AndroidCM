package com.erikle2.childmanagement.UITestEspresso;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.erikle2.childmanagement.R;
import com.erikle2.childmanagement.activities.LoginActivity;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Erik on 05/11/2015.
 */

@RunWith(AndroidJUnit4.class)
public class LoginTest extends ActivityInstrumentationTestCase2<LoginActivity>{

    public static final String STRING_TO_BE_TYPED = "Espresso";



    @Rule
    public ActivityTestRule<LoginActivity> mainActivityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    public LoginTest() {
        super(LoginActivity.class);
    }

    @Test
    public void view(){
        onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(hasFocus()));
    }
}
