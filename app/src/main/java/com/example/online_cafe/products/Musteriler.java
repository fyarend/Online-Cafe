package com.example.online_cafe.products;

public class Musteriler {
    public String nameSurname = "";
    public long totalAmount = 0;

    public Musteriler(long totalAmount, String nameSurname) {
        this.totalAmount = totalAmount;
        this.nameSurname = nameSurname;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }
}
