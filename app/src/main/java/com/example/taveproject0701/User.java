package com.example.taveproject0701;

public class User{
    private String username, email, pwd;
    private int id;

    public User(int id, String username, String email, String pwd){
        this.id = id;
        this.username = username;
        this.email = email;
        this.pwd = pwd;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }
}
