package ru.kataproject.p_sm_airlines_1.service;

import lombok.NonNull;

import javax.mail.MessagingException;
import java.util.List;

public interface EmailService {
    void sendEmail(@NonNull List<String> users, String subject, String message, String... attachment)
            throws MessagingException;
}
