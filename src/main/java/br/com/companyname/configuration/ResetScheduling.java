package br.com.companyname.configuration;

import br.com.companyname.service.MassageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ResetScheduling {

    @Autowired
    MassageService massageService;

    Log LOG = LogFactory.getLog(ResetScheduling.class);

    //friday 18 at brazil time (-3)
    @Scheduled(cron = "0 0 21 * * FRI")
    public void eraseData(){
        LOG.info("#####ERASING ALL DATA#####");
        massageService.findAll().forEach(massage -> massageService.remove(massage));
    }

}
