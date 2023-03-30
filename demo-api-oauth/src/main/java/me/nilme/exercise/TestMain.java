package me.nilme.exercise;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by taoshanchang on 16/3/1.
 */
public class TestMain {


    private static String  privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAOQHTVwOi8U89Y4l" +
            "9/5gmvhcvqlDOG6wmtoGTFioZwddRddDn3artKTuRlDknljuaMxJYau0qhacMQ+p" +
            "OCFWqwLDrX3q7ziHKpCsEEU4iQeTukQ7nNxaQo74iCqAY2RRLIxya+ApuN8jya3V" +
            "Z70si4yrUixCQKEkIlqM2n/WqxxdAgMBAAECgYBh1Vg1hPAm4a6hHF04QI58vJ34" +
            "1SRjKVZm8IjVCPubR0Ntxk+mhKjukmSM1Gmz0iYYb+t91feb18uc4od4lkysBYXB" +
            "QzzevO9c+1jUX/02zPzt0thfUcj78nHNbWPYMV0boUaEKgQ1TgkhNvYpJlW49VF7" +
            "qr6EOi4/60twb1fu6QJBAPmOMgtC3JSC6EkLwj7RwzrIN4yiwQP+XupHGPNrg/0t" +
            "3T0WR6R79ChJN5paYQNRvhDKSOi0k6GV75h2me1G1mcCQQDp6srx9DGdIF2mkxvQ" +
            "a/KNBpBMz4O1mxVZKw4ZKnJHvyBDroPr15dUAv2YalDZR8xIGEISITrmCbsmsHN6" +
            "ttSbAkEAqK01JClwQK1u5hidlapgpDW6XkOP5OwlKYMe2UFduF4swOJzUDk8IZLD" +
            "k3/tPLoeluizeR68/qYCiXH4vsl3lwJAEXivBdlmZ0UGma19M1kMucnWt1X8kXDu" +
            "7EUR/YE1HfTBlSyQv+nPbL/4bwzp0wDQ2kWtkasXuhzZ9K7TQUQspwJASMQgXuV7" +
            "m51KqE1c+6NIAWprU7wxQWEiT2VZmdf7av/hqyPcP5oPeokwm36zJxX40hPCBDsu" +
            "SuMvYF3Z+ZwKBA==";

    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDkB01cDovFPPWOJff+YJr4XL6p" +
            "QzhusJraBkxYqGcHXUXXQ592q7Sk7kZQ5J5Y7mjMSWGrtKoWnDEPqTghVqsCw619" +
            "6u84hyqQrBBFOIkHk7pEO5zcWkKO+IgqgGNkUSyMcmvgKbjfI8mt1We9LIuMq1Is" +
            "QkChJCJajNp/1qscXQIDAQAB";

    public static String input_charset = "utf-8";


    public static void main(String[] args) {
        String url = "http://hibabydance.com/";
        String api = "v1/user";

        //模拟测数据
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("username", "tsc");
        data.put("password", "12345678");
        data.put("nickname", "babydance");
        data.put("phone", "18066265836");
        data.put("email", "taoshanchang@foxmail.com");
        data.put("address", null);
        data.put("", "xxxxxx");

        Map<String, String> perData = Utils.paraFilter(data);
        String perSign = Utils.createLinkString(perData);

        String sign = RSA.sign(perSign, privateKey, input_charset);
        data.put("sign", sign);//将sign放入数据中,传给服务端


        Map<String, String> para = Utils.paraFilter(data);
        System.out.println("待验证数据:"+ para);

        String linkString = Utils.createLinkString(para);
        System.out.println("待验证串:"+ linkString);


        boolean isSign = RSA.verify(linkString, data.get("sign"), publicKey, input_charset);

        System.out.println("是否验证成功:"+isSign);
    }







}
