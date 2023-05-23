package com.example.prj;

public class WalletModel {
    String money;
    String date;

    public WalletModel(String money, String date) {
        this.money = money;
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
