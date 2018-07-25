package br.com.companyname.configuration;
import br.com.companyname.model.Massage;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@PropertySource()
public class MailUtil {

    public static void sendMail(Massage massage, String userChangedLogin) {

        Email from = new Email("sth-massage-trader@example.com");
        String emailTo = massage.getLogin().getEmail();
        Email to = new Email(emailTo);

        String subject = "Massage trader - Troca de massagem";
        String emailContent = String.format("Seu novo horário é : %s com %s. \nVocê trocou sua massagem com : %s", massage.getTime(), massage.getProfessional().toString() , userChangedLogin);

        Content content = new Content("text/plain", emailContent);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");

        Request request = new Request();
        try {

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {

        }
    }
}
