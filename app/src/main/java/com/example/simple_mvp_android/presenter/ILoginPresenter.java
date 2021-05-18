package com.example.simple_mvp_android.presenter;

public interface ILoginPresenter {
    void onLogin(String email, String password);
    boolean isEmailValid(String email);
    boolean isPasswordValid(String password);


}
