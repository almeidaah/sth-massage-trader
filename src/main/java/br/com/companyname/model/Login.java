package br.com.companyname.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
@NoArgsConstructor
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
