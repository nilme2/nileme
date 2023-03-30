package me.nilme.exercise.mail;

/**
 * Created by taoshanchang on 16/3/21.
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        TSCMailSender.getSender().send("taoshanchang@foxmail.com","Active Email","注册成功");
//        TSCMailSender.getSender().sendWithMultipart("18066265836@163.com","Active Email","注册成功");
    }
}
