package br.com.companyname.controllers;

import java.util.Map;

import br.com.companyname.model.Login;
import br.com.companyname.service.LoginService;
import br.com.companyname.service.MassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes("login")
public class WelcomeController {

	@Autowired
	private MassageService massageService;

	@Autowired
	private LoginService loginService;

	@GetMapping("/")
	public String index(Map<String, Object> model) {
		Login login = (Login)model.get("login");
		if(login != null && login.getEmail() != null){
			return setDefaultModelAttributes(model, login);
		}
		model.put("login", new Login());
		return "login";
	}

	private String setDefaultModelAttributes(Map<String, Object> model, Login login) {
		model.put("username", login.getEmail());
		model.put("myMassages", massageService.findAllByLogin(login));
		model.put("massages", massageService.list());
		return "welcome";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute final Login newUser, final BindingResult result, final ModelMap model) {

 		if(result.hasErrors()){
			model.put("error", "Informe os campos corretamente");
			return "login";
		}

		Login dbLogin = loginService.findByEmailAndPassword(newUser);
 		if(dbLogin != null){
			setDefaultModelAttributes(model, newUser);
			model.put("login", dbLogin);

			return "welcome";
		}

		model.put("error", "Usuário não encontrado");
		return "login";

	}

	@GetMapping("/logout")
	public String logout(Map<String, Object> model) {
		model.put("login", null);
		return index(model);
	}


}