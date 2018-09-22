package br.com.companyname.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Login {

    @Id
    private String id;

    @NotNull
    @Size(min = 2)
    private String email;

    private Role role;

    @NotNull
    private String password;

    private String passwordConfirmation;


}
