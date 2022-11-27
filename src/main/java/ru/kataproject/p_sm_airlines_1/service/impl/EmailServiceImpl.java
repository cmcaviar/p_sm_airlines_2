package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.service.EmailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public void sendEmail(@NonNull List<String> users, String subject, String message, String... attachments)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom(sender);
        messageHelper.setTo(users.toArray(new String[0]));
        messageHelper.setSubject(subject);
        messageHelper.setText(message);
        for (String attachment : attachments) {
            File file = new File(attachment);
            messageHelper.addAttachment(file.getName(), file);
        }

        mailSender.send(mimeMessage);
    }
}
