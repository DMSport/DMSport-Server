package com.project.dmsport.global.util.jms;

import com.project.dmsport.global.exception.MailSendException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JmsUtil {

    private final JmsProperties jmsProperties;
    private final JavaMailSender mailSender;

    public void sendMail(String email, String authenticationCode) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, false, "UTF-8");

            messageHelper.setTo(email);
            messageHelper.setFrom(jmsProperties.getUsername());
            messageHelper.setSubject("[DMSport] 이메일 인증");

            String text = getFormattedString(authenticationCode.split(""));
            boolean isHTML = true;

            messageHelper.setText(text,isHTML);

            mailSender.send(message);
        } catch (Exception e){
            throw MailSendException.EXCEPTION;
        }

    }

    private String getFormattedString(String[] codes) {
        return String.format(getMailTemplate(),
                codes[0],
                codes[1],
                codes[2],
                codes[3],
                codes[4],
                codes[5]);
    }

    private String getMailTemplate(){
        try {
            byte[] bytes = new ClassPathResource("static/email_template.html").getInputStream().readAllBytes();
            return new String(bytes);
        } catch (IOException e) {
            throw MailSendException.EXCEPTION;
        }
    }

}