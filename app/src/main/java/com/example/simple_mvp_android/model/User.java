package com.example.simple_mvp_android.model;

public class User implements IUser {
    private final String password;
    private final String email;

    public User( String email, String password) {
        this.password = password;
        this.email = email;
    }
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }


}
