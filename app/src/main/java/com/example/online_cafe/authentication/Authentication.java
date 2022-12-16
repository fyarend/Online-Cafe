package com.example.online_cafe.authentication;


import android.widget.EditText;

public class Authentication {
    private String nameSurname;
    private String username;
    private String password;
    private String yorum;






    public Authentication(String yorum, String namesurname) {
        this.yorum = yorum;
        this.nameSurname = namesurname;

    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Authentication(String nameSurname, String username, String password) {
        this.nameSurname = nameSurname;
        this.username = username;
        this.password = password;
    }
}
