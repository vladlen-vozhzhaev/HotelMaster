package model;

public class Client {
    private static int nextId = 1;

    private int id;
    private String fullName;
    private String phone;
    private String passport;
    private String email;

    public Client(String fullName, String phone, String passport, String email) {
        this.id = nextId++;
        this.fullName = fullName;
        this.phone = phone;
        this.passport = passport;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
