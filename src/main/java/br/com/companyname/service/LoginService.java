package br.com.companyname.service;

import br.com.companyname.model.Login;
import br.com.companyname.repository.LoginRepository;
import br.com.companyname.repository.MassageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private MassageRepository massageRepository;

    public Login findByEmailAndPassword(Login login){
        return this.loginRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
    }

    public void save(Login login){
        this.loginRepository.save(login);
    }

    public List<Login> findAll() {
        List<Login> allLogins = loginRepository.findAll();
        allLogins.sort(Comparator.comparing(Login::getEmail));
        return allLogins;
    }

    public void delete(String userId) {
        Login loginToDelete = loginRepository.findOne(userId);
        if(loginToDelete != null){
            massageRepository.findAllByLogin(loginToDelete.getEmail()).forEach(massageRepository::delete);
            loginRepository.delete(userId);
        }
    }
}
