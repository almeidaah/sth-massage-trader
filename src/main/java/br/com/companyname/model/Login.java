package br.com.companyname.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {

    @NotNull
    @Size(min = 2)
    private String email;

    @NotNull
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
