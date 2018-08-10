package br.com.companyname.service;

import br.com.companyname.model.Massage;
import br.com.companyname.repository.MassageRepository;
import br.com.companyname.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class MassageService {

    @Autowired
    private MassageRepository massageRepository;

    public List<Massage> list(){
        //Return only visible messages;
        return massageRepository.findAll().stream().filter(Massage::getVisible).collect(toList());
    }

    @Transactional
    public void save(Massage massage) {
        massageRepository.save(massage);
    }

    public Massage findUserMassage(Login login) {
        return massageRepository.findByLogin(login.getEmail());
    }

    public void remove(Massage m) {
        massageRepository.delete(m);
    }

    public Massage findMassageById(String messageToExchangeId) { return massageRepository.findOne(messageToExchangeId); }

    public List<Massage> findAllByLogin(Login login){
        return massageRepository.findAllByLogin(login.getEmail());
    }

    public List<Massage> findAll() { return massageRepository.findAll(); }
}
