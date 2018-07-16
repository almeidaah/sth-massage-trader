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
        return massageRepository.findAll().stream().filter( f -> f.getVisible()).collect(toList());

//        Massage m1 = new Massage();
//        m1.setId("1");
//        m1.setDetail("Massagem bacana!");
//        m1.setProfessional(Massage.Professional.DIEGO);
//        m1.setTime(LocalTime.now());
//
//        Massage m2 = new Massage();
//        m2.setId("2");
//        m2.setDetail("Massagem ruim!");
//        m2.setProfessional(Massage.Professional.ANA);
//        m2.setTime(LocalTime.now());
//
//        Massage m3 = new Massage();
//        m3.setId("3");
//        m3.setDetail("Massagem top!");
//        m3.setProfessional(Massage.Professional.SAMA);
//        m3.setTime(LocalTime.now());
//
//        return Arrays.asList(m1, m2, m3);
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

    public Massage findMassageById(String messageToExchangeId) {
        return massageRepository.findOne(messageToExchangeId);
    }

    public List<Massage> findAllByLogin(Login login){
        return massageRepository.findAllByLogin(login.getEmail());
    }

    public List<Massage> findAll() {
        return massageRepository.findAll();
    }
}
