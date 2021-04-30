package com.offcn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SendEmail01 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-mail.xml");
        //创建邮件发送服务的对象
        JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");

        //创建邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        //设置发送邮件的邮箱
        message.setFrom("meng5188888@126.com");
        //设置接收邮件的邮箱
        message.setTo("meng5188888@126.com");
        //设置邮件的标题
        message.setSubject("ceshiyoujian");
        //设置邮件的正文
        message.setText("hello mail");

        //发送邮件
        mailSender.send(message);
        System.out.println("邮件发送成功");
    }
}
