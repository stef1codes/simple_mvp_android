package com.example.simple_mvp_android.presenter;

import android.util.Patterns;

import com.example.simple_mvp_android.model.User;
import com.example.simple_mvp_android.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    private final ILoginView view;

    public LoginPresenter(ILoginView view){
        this.view = view;
    }

    @Override
    public void onLogin( String email, String password) {
       //create a user object.
        User user = new User(email,password);

        // check is email is valid
        boolean checkedUsername = isEmailValid( user.getEmail());
        // check is password is valid
        boolean checkedPassword = isPasswordValid( user.getPassword());

        /*if both checkedUsername and checkedPassword is  'true' return 'Login success'
         Otherwise return 'Login Error'*/
        view.onLoginResults( checkedUsername && checkedPassword ? "Login success" : "Login Error");


    }

    @Override
    public boolean isEmailValid(String email) {
        if( email == null)  return false;

        if(email.contains("@")) return Patterns.EMAIL_ADDRESS.matcher(email).matches();

        else return !email.trim().isEmpty();
    }

    @Override
    public boolean isPasswordValid(String password) {
        return password!=null && password.length() > 5;
    }
}
