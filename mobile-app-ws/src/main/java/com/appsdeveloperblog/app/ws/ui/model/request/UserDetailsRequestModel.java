package com.appsdeveloperblog.app.ws.ui.model.request;

import org.jetbrains.annotations.NotNull;

public class UserDetailsRequestModel {

    private String firstname = null;
    private String lastname = null;
    private String email = null;
    private String password = null;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
