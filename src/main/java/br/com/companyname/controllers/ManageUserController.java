package br.com.companyname.controllers;

import br.com.companyname.model.Login;
import br.com.companyname.service.LoginService;
import br.com.companyname.validation.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("newUser")
public class ManageUserController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginValidator loginValidator;

    @GetMapping("/manageUsers")
    private String manageUsers(Map<String, Object> model){
        model.put("users", loginService.findAll());
        return "manageUsers";
    }

    @GetMapping("/addUserForm")
    private String addUserForm(Map<String, Object> model){
        model.put("newUser", new Login());
        return "addUser";
    }

    @PostMapping("/addUser")
    private String addUser(@Valid @ModelAttribute final Login login, final BindingResult result, final ModelMap model){
        loginValidator.validate(login, result);

        if(result.hasErrors()) {
            model.put("error", "Informe os campos corretamente");
            return "addUser";
        }

        //this aims to not save the user confirmpassword
        login.setPasswordConfirmation(null);

        //ADD USER EFETIVELY
        loginService.save(login);

        model.put("success", "Usuário adicionado com sucesso");

        return manageUsers(model);
    }

    @GetMapping("/delete/{userId}")
    private String deleteUser(@PathVariable String userId, Map<String, Object> model){
        loginService.delete(userId);
        model.put("users", loginService.findAll());
        model.put("success", "Usuário removido com sucesso");
        return "manageUsers";
    }


}
