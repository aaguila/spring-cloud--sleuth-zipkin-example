package com.qajungle.domain;

public class Account {

    String name;
    String lastname;
    String login;
    String type;

    public Account() {
    }

    public Account(String name, String lastname, String login, String type) {
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getType() {
        return type;
    }
}
