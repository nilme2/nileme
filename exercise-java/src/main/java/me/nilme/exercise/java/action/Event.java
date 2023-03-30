package me.nilme.exercise.java.action;


import lombok.Data;

@Data
public class Event {

    private String publishSubject;

    private String publishBuName;

    private String publishBuCname;

    private String publishProductName;

    private String publishProductCname;

    private String publishEnv;

    private String publishSvn;

    private String productSrcSvn;

    private String publishProductKey;


}