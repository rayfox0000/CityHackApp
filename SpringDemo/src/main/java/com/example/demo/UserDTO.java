package com.example.demo;

public class UserDTO {
    private String id;
    //    private String username;
    private String password;
    private String email;
    private String memberType;


    public UserDTO() {

    }

    public UserDTO(String id, String email, String password, String memberType) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.memberType = memberType;

    }
    public UserDTO(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }
}

