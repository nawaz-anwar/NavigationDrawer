package models;

public class dataholder {

    String pimage, name, mail, password;

    public dataholder(String pimage, String name, String mail, String password) {
        this.pimage = pimage;
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
