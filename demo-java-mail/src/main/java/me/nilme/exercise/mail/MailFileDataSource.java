package me.nilme.exercise.mail;

import javax.activation.DataSource;
import javax.activation.FileTypeMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by taoshanchang on 16/3/21.
 */
public class MailFileDataSource implements DataSource {

    private InputStream in = null;

    private FileTypeMap typeMap;


    public MailFileDataSource(String resources){
        in = TSCMailSender.class.getClassLoader().getResourceAsStream(resources);
    }

    public MailFileDataSource(InputStream in){
        this.in = in;
    }

    public InputStream getInputStream() throws IOException {
        return in;
    }

    public OutputStream getOutputStream() throws IOException {
        return null;
    }

    public String getContentType() {
        return null;
    }

    public String getName() {
        return null;
    }

}
