package br.com.companyname.validation;

import br.com.companyname.model.Login;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Login.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "required.password", "Field name is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirmation",
                "required.passwordConfirmation", "Field name is required.");

        Login login = (Login)target;

        if(!(login.getPassword().equals(login.getPasswordConfirmation()))){
            errors.rejectValue("password", "notmatch.password");
        }
    }
}
