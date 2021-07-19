package com.example.taveproject0701;

public class User{
    private String username, email, pwd, gender, isFare, income, address, family, lifecycle, obstacle;
    private int id;

    public User(int id, String username, String email, String pwd, String gender,
                String isFare, String income, String address, String family, String lifecycle, String obstacle){
        this.id = id;
        this.username = username;
        this.email = email;
        this.pwd = pwd;
        this.gender = gender;
        this.isFare = isFare;
        this.income = income;
        this.address = address;
        this.family = family;
        this.lifecycle = lifecycle;
        this.obstacle = obstacle;
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

    public String getGender(){return gender;}
    public void setGender(String gender){this.gender = gender;}

    public String getIsFare(){return isFare;}
    public void setIsFare(String isFare){this.isFare = isFare;}

    public String getIncome(){return income;}
    public void setIncome(String income){this.income = income;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}

    public String getFamily(){return family;}
    public void setFamily(String family){this.family = family;}

    public String getLifecycle(){return lifecycle;}
    public void setLifecycle(String lifecycle){this.lifecycle = lifecycle;}

    public String getObstacle(){return obstacle;}
    public void setObstacle(String obstacle){this.obstacle = obstacle;}
}
