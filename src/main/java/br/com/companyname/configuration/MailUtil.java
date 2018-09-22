package br.com.companyname.configuration;

import br.com.companyname.model.Massage;
import com.sendgrid.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

public class MailUtil {

    final static Log LOG = LogFactory.getLog(MailUtil.class);

    public static void sendMail(Massage massage, String userChangedLogin, String sendGridKey) {
        Email from = new Email("sth-massage-trader@example.com");
        String emailTo = massage.getLogin().getEmail();
        Email to = new Email(emailTo);

        String subject = "Massage trader - Troca de massagem";
        String emailContent = String.format("Seu novo horário é : %s com %s. \nVocê trocou sua massagem com : %s", massage.getTime(), massage.getProfessional().toString() , userChangedLogin);

        Content content = new Content("text/plain", emailContent);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGridKey);

        Request request = new Request();
        try {

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            LOG.info(response.getStatusCode());
            LOG.info(response.getBody());
        } catch (IOException ex) {

        }
    }
}
