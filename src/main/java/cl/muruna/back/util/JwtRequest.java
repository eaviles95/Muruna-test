package cl.muruna.back.util;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String name;
    private String mail;
    private String password;

    //default constructor for JSON Parsing
    public JwtRequest() {
    }

    public JwtRequest(String name, String password, String mail) {

        this.setName(name);
        this.setMail(mail);
        this.setPassword(password);
    }

    public String getMail() {
        return this.mail;
    }

    private void setMail(String mail) {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
