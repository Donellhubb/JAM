package com.bob.jamserver.config;

import com.sendgrid.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class EmailConfig {
    public void emails(String email)throws IOException{
        Mail mail = emailSent(email);
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
            throw ex;
        }

    }
    public Mail emailSent(String email) {
        Email from = new Email("bobigbarumah@gmail.com");
        String subject = "Sup Joss you the real MVP";
        Email to = new Email(email);
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);
        return mail;
    }
}
