package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {
    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public TicketService ticketService(){return new TicketService();}
    @Bean
    public ParkingService parkingService(){return new ParkingService();}
}