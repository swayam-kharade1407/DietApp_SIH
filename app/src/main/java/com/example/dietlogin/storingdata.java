package com.example.dietlogin;

public class storingdata {
    String name,username,phoneno,email,password;

    public storingdata() {
    }

    public storingdata(String fullname, String username, String email, String phonenumber, String password) {
        this.name = fullname;
        this.username = username;
        this.email = email;
        this.phoneno = phonenumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
