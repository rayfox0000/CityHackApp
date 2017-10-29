package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ticket")
public class Ticket {
    @Id
    private String idTicket;
    private String email;
    private String enterTime;
    private String exitTime;
    private double price;
    private Boolean paid;
    public Ticket(){

    }
    public Ticket(String idTicket, String email, String enterTime, String exitTime, double price,Boolean paid) {
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

    public Ticket(TicketDTO ticketDTO){
        this.idTicket = ticketDTO.getIdTicket();
        this.email = ticketDTO.getEmail();
        this.enterTime = ticketDTO.getEnterTime();
        this.exitTime = ticketDTO.getExitTime();
        this.price = ticketDTO.getPrice();
        this.paid = ticketDTO.getPaid();
    }
    public TicketDTO toDTO(){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setIdTicket(idTicket);
        ticketDTO.setEmail(email);
        ticketDTO.setEnterTime(enterTime);
        ticketDTO.setExitTime(exitTime);
        ticketDTO.setPrice(price);
        ticketDTO.setPaid(paid);
        return ticketDTO;
    }
}