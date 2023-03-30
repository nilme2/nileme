package me.nilme.exercise.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author taoshanchang
 */
public class TSCMailSender {
    private static TSCMailSender tscMailSender;
    private static ReentrantLock lock = new ReentrantLock();
    Logger logger = LoggerFactory.getLogger(TSCMailSender.class);
    //发送邮件的props文件
    private final transient Properties props = System.getProperties();
    //邮件服务器登录验证
    private transient MailAuthenticator authenticator;
    //邮箱session
    private transient Session session;
    private TSCMailSender() {
    }

    public static TSCMailSender getSender() throws Exception {
        if (tscMailSender == null) {
            lock.lock();
            if (tscMailSender == null) {
                Properties prop = new Properties();
                InputStream in = TSCMailSender.class.getClassLoader().getResourceAsStream("mail.properties");
                prop.load(in);
                tscMailSender = new TSCMailSender(prop.getProperty("host"), prop.getProperty("username"), prop.getProperty("password"));
            }
        }
        return tscMailSender;
    }

    /**
     * 初始化邮件发送器
     *
     * @param smtpHostName SMTP邮件服务器地址
     * @param username     发送邮件的用户名(地址)
     * @param password     发送邮件的密码
     */
    private TSCMailSender(final String smtpHostName, final String username, final String password) {
        init(username, password, smtpHostName);
    }

    /**
     * 初始化邮件发送器
     *
     * @param username 发送邮件的用户名(地址)，并以此解析SMTP服务器地址
     * @param password 发送邮件的密码
     */
    private TSCMailSender(final String username, final String password) {
        final String smtpHostName = "smtp." + username.split("@")[1];
        init(username, password, smtpHostName);

    }

    /**
     * 初始化
     *
     * @param username     发送邮件的用户名(地址)
     * @param password     密码
     * @param smtpHostName SMTP主机地址
     */
    private void init(String username, String password, String smtpHostName) {
        logger.info("连接信息: username=" + username + ";" + "password=" + password + ";" + "smtpHostName=" + smtpHostName);
        // 初始化props
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", smtpHostName);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "false");
        // 验证
        authenticator = new MailAuthenticator(username, password);
        // 创建session
        session = Session.getInstance(props, authenticator);
        session.setDebug(true);
    }

    /**
     * 发送邮件
     *
     * @param recipient 收件人邮箱地址
     * @param subject   邮件主题
     * @param content   邮件内容
     * @throws AddressException
     * @throws MessagingException
     */
    public void send(String recipient, String subject, Object content) throws MessagingException {
        // 创建mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        // 设置发信人
        message.setFrom(new InternetAddress(authenticator.getUsername()));
        // 设置收件人
        message.setRecipient(RecipientType.TO, new InternetAddress(recipient));
        // 设置主题
        message.setSubject(subject);
        // 设置邮件内容
        message.setContent(content.toString(), "text/html;charset=utf-8");
        // 发送
        Transport.send(message);
    }

    /**
     * 群发邮件
     *
     * @param recipients 收件人们
     * @param subject    主题
     * @param content    内容
     * @throws AddressException
     * @throws MessagingException
     */
    public void send(List<String> recipients, String subject, Object content) throws MessagingException {
        // 创建mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        // 设置发信人
        message.setFrom(new InternetAddress(authenticator.getUsername()));
        // 设置收件人们
        final int num = recipients.size();
        InternetAddress[] addresses = new InternetAddress[num];
        for (int i = 0; i < num; i++) {
            addresses[i] = new InternetAddress(recipients.get(i));
        }
        message.setRecipients(RecipientType.TO, addresses);
        // 设置主题
        message.setSubject(subject);
        // 设置邮件内容
        message.setContent(content.toString(), "text/html;charset=utf-8");
        // 发送
        Transport.send(message);
    }

    public void sendWithMultipart(String recipient, String subject, Object content) throws MessagingException {
        // 创建mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        // 设置发信人
        message.setFrom(new InternetAddress(authenticator.getUsername()));
        // 设置收件人
        message.setRecipient(RecipientType.TO, new InternetAddress(recipient));
        // 设置主题
        message.setSubject(subject);


        // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
        Multipart mainPart = new MimeMultipart();
        // 创建一个包含HTML内容的MimeBodyPart
        BodyPart bodyPart = new MimeBodyPart();
        // 设置HTML内容
        bodyPart.setContent(content.toString(), "text/html; charset=utf-8");
        mainPart.addBodyPart(bodyPart);

        //设置信件的附件(用本地上的文件作为附件)
        bodyPart = new MimeBodyPart();
        FileDataSource fds = new FileDataSource("/Users/taoshanchang/Sites/Blog/_config.yml");
        DataHandler dh = new DataHandler(fds);
        bodyPart.setFileName("_config.yml");
        bodyPart.setDataHandler(dh);
        mainPart.addBodyPart(bodyPart);

        // 将MiniMultipart对象设置为邮件内容
        message.setContent(mainPart);
        message.saveChanges();

        // 发送邮件
        Transport.send(message);
    }



}
