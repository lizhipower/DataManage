package Infomations;

/**
 * Created by ZhiLI on 2016/3/2.
 */
public class InfoClassMonitor {
    private String name, telLong, telShort, mail;

    public InfoClassMonitor(String name, String telLong, String telShort, String mail) {
        this.name = name;
        this.telLong = telLong;
        this.telShort = telShort;
        this.mail = mail;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelLong() {
        return telLong;
    }

    public void setTelLong(String telLong) {
        this.telLong = telLong;
    }

    public String getTelShort() {
        return telShort;
    }

    public void setTelShort(String telShort) {
        this.telShort = telShort;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
