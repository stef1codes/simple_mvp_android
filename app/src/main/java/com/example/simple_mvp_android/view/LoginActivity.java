package com.example.simple_mvp_android.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.simple_mvp_android.R;
import com.example.simple_mvp_android.presenter.ILoginPresenter;
import com.example.simple_mvp_android.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    private EditText usernameEditText,passwordEditText;

    private ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the id's from the view
        initView();

        //initialize the presenter class
        initPresenter();


    }

    @Override
    public void onLoginResults(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initView() {
        usernameEditText   = findViewById(R.id.username);
        passwordEditText   = findViewById(R.id.password);
    }

    @Override
    public void initPresenter() {
        presenter = new LoginPresenter(this);

    }

    public void onClick(View view) {
        presenter.onLogin(usernameEditText.getText().toString(),passwordEditText.getText().toString());
    }
}