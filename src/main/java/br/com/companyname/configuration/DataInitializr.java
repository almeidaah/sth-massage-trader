package br.com.companyname.configuration;

import br.com.companyname.model.Login;
import br.com.companyname.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class DataInitializr  implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private LoginService loginService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Login admin = new Login();
        admin.setEmail("admin@suntech.com.br");
        admin.setPassword("999");


        Login dbAdmin = loginService.findByEmailAndPassword(admin);
        if(dbAdmin != null){
            System.out.println("####################################Admin criado!####################################");
            loginService.save(admin);
        }

    }
}
