package com.example.prj;

import java.util.ArrayList;

public class Registery {
    ArrayList<Account> acc;

    public Registery() {
        this.acc = new ArrayList<Account>();
        Account e = new Account("calunod", "calunod");
        Account d = new Account("asd", "asd");
        acc.add(e);
        acc.add(d);
    }

    public void addAcc(Account e) {
        acc.add(e);
    }
}
