package br.com.companyname.service;

import br.com.companyname.model.Login;
import br.com.companyname.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login findByEmailAndPassword(Login login){
        return this.loginRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
    }

    public void save(Login login){
        this.loginRepository.save(login);
    }
}
