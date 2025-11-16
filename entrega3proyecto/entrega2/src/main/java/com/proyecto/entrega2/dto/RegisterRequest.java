package com.proyecto.entrega2.dto;

import com.proyecto.entrega2.entity.possibleGenders;

public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private int age;
    private possibleGenders sex;

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public possibleGenders getSex() {
        return sex;
    }

    public void setSex(possibleGenders sex) {
        this.sex = sex;
    }
}