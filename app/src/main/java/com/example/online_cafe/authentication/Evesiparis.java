package com.example.online_cafe.authentication;

public class Evesiparis {
    private String nameSurname;
    private String username;
    private String password;
    private String adres;
    private String tel;

    public Evesiparis(String nameSurname, String username, String password, String adres, String tel) {
        this.nameSurname = nameSurname;
        this.username = username;
        this.password = password;
        this.adres = adres;
        this.tel = tel;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
