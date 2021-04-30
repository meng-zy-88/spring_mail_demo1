package com.offcn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Auther: lhq
 * @Date: 2020/11/19 15:15
 * @Description:
 */
public class SendMail02 {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-mail.xml");
        //创建邮件发送服务的对象
        JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");


        //创建发送附件邮件对象
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        //设置发送邮件的邮箱
        helper.setFrom("xiaoyao1052@126.com");
        //设置接收邮件的邮箱
        helper.setTo("xiaoyao1052@126.com");
        //设置邮件的标题
        helper.setSubject("ceshifujian");
        //设置邮件的正文
        helper.setText("hello mail");


        //读取本地文件
        File file1 = new File("C:\\1.jpg");
        File file2 = new File("C:\\2.txt");

        //加载附件
        helper.addAttachment("1.jpg", file1);
        helper.addAttachment("2.txt", file2);

        //发送邮件
        mailSender.send(message);
        System.out.println("邮件发送成功");


    }
}
