package com.erikle2.childmanagement.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.erikle2.childmanagement.R;
import com.erikle2.childmanagement.login.presenters.LoginController;
import com.erikle2.childmanagement.login.views.ITalkToLoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ITalkToLoginActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private LoginController presenter;
    private ProgressDialog progressDialog;

    @Bind(R.id.input_email)
    EditText _emailText;
    @Bind(R.id.input_password)
    EditText _passwordText;
    @Bind(R.id.btn_login)
    Button _loginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        _emailText.requestFocus();

        presenter = new LoginController(this);
        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
                Toast.makeText(v.getContext(),"CLICK",Toast.LENGTH_SHORT).show();
                presenter.validateCredentials(_emailText.getText().toString(), _passwordText.getText().toString());
            }
        });
    }
    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }
    @Override
    public void onSuccess() {
        progressDialog.dismiss();
        Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity.class));
    }
    private void showProgressDialog(){
         progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
    }

    @Override
    public void onFalure() {
        progressDialog.dismiss();
        Toast.makeText(this,"LOGIN FAIL",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void invalidEmail() {
        _emailText.setError("enter a valid email address");
    }

    @Override
    public void invalidPassword() {
        _passwordText.setError("between 4 and 10 alphanumeric characters");
    }
}