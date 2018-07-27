package br.com.companyname.configuration;

import br.com.companyname.service.MassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ResetScheduling {

    @Autowired
    MassageService massageService;


    //@Scheduled(cron = "0 0 * * SAT")
//    @Scheduled(cron = "*/2 * * * *")
//    void eraseData(){
//        System.out.println("deleting all data :)");
//        massageService.findAll().forEach(massage -> massageService.remove(massage ));
//    }

    //friday 18 at brazil time (-3)
    @Scheduled(cron = "0 0 21 * * FRI")
    public void eraseData(){
        System.out.println("#####ERASING ALL DATA#####");
        massageService.findAll().forEach(massage -> massageService.remove(massage ));
    }

}
