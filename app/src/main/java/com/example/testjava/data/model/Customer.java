package com.example.testjava.data.model;

public class Customer {
    private String id;
    private String name;
    private String phone;
    private String email;
    private boolean isVisited;

    public Customer(String id, String name, String phone, String email, boolean isVisited) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.isVisited = isVisited;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
