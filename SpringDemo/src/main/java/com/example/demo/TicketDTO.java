package com.example.demo;

public class TicketDTO {
    private String idTicket;
    private String email;
    private String enterTime;
    private String exitTime;
    private double price;
    private Boolean paid;

    public TicketDTO(){

    }
    public TicketDTO(String email, String enterTime){
        this.email = email;
        this.enterTime = enterTime;
    }
    public TicketDTO(String idTicket, String email, String enterTime, String exitTime, double price,Boolean paid) {
        this.idTicket = idTicket;
        this.email = email;
        this.enterTime = enterTime;
        this.exitTime = exitTime;
        this.price = price;
        this.paid = paid;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}