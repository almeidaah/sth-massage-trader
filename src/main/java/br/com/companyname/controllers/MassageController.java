package br.com.companyname.controllers;

import br.com.companyname.model.Login;
import br.com.companyname.model.Massage;
import br.com.companyname.service.MassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("login")
public class MassageController {

    @Autowired
    private MassageService massageService;

    @PostMapping("/addMassage")
    public String newMassage(@ModelAttribute("login") Login login, @ModelAttribute final Massage massage, final BindingResult result, final ModelMap model) {

        model.put("professionals", Massage.Professional.values());

        if (result.hasErrors()) {
            model.put("error", "Informe os campos corretamente");
            return "massageForm";
        }

        //if it's for donating (visible for exchange and no-owner)
        if(massage.getDonateMassage()){
            massage.setVisible(Boolean.TRUE);
            massage.setLogin(null);
        }else{
            massage.setVisible(Boolean.FALSE);
            massage.setLogin(login);
        }

        massageService.save(massage);

        model.put("username", login.getEmail());
        model.put("myMassages", massageService.findAllByLogin(login));
        model.put("massages", massageService.list());

        return "welcome";
    }

    /*Fix, this should be delete Mapping :) [problems with a:href at .jsp]*/
    @GetMapping("/massage/remove/{massageId}")
    public String removeMassage(@PathVariable String massageId, @ModelAttribute final Login login, final ModelMap model){

        Massage massage = massageService.findMassageById(massageId);
        massageService.remove(massage);

        model.put("username", login.getEmail());
        model.put("massages", massageService.list());
        model.put("message", "Massagem removida com sucesso");
        return "welcome";
    }
}
