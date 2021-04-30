package com.offcn;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Auther: lhq
 * @Date: 2020/11/19 15:15
 * @Description:
 */
public class SendMail04 {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-mail.xml");
        //创建邮件发送服务的对象
        JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");


        //创建发送附件邮件对象
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "GBK");

        //设置发送邮件的邮箱
        helper.setFrom("xiaoyao1052@126.com");
        //设置接收邮件的邮箱
        helper.setTo("xiaoyao1052@126.com");
        //设置邮件的标题
        helper.setSubject("ceshifujian");
        //设置邮件的正文  参数二： true  只是带html样式的正文
        String html = IOUtils.toString(new FileInputStream("c:\\test.html"), "utf-8");

        helper.setText(html, true);


        //读取本地文件
        File file1 = new File("C:\\logo.jpg");


        helper.addInline("www", file1);

        //发送邮件
        mailSender.send(message);
        System.out.println("邮件发送成功");


    }
}
