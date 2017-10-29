package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class TicketService {
    @Autowired
    private TicketRepo ticketRepo;

    @Transactional
    public TicketDTO findByEmailPaid(String email, Boolean paid){
        System.out.println("username"+email + " "+paid);
        Ticket ticket = ticketRepo.findByEmailPaid(email,paid);
        if(ticket != null){
            return ticket.toDTO();
        }
        else{
            return null;
        }
    }
    @Transactional
    public TicketDTO findByEmail(String email){
        Ticket ticket = ticketRepo.findByEmail(email);
        if(ticket != null){
            return ticket.toDTO();
        }
        else{
            return null;
        }
    }

    public void save(TicketDTO TicketDTO){
        Ticket ticket = new Ticket(TicketDTO);
        ticketRepo.save(ticket);
    }
}