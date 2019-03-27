package me.luocaca.model.controller;

import me.luocaca.model.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    AsynService asynService;

    @RequestMapping("/semdemail")
    public String sendEmail() {
        System.out.println("发送邮件------");
        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("Hello World");
        message.setText("text");

        message.setTo("471474615@qq.com");
        message.setFrom("992056013@qq.com");

        mailSender.send(message);

        asynService.hello();
        return "succeed sendEmail";


    }
}
