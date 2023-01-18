package com.example.new_relic_poc.user.model;

public class UserRequest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User converter(){
        return new User(this.name);
    }

    public User update(User user){
        user.setName(this.name);
        return user;
    }


}
