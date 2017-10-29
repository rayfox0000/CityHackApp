package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface TicketRepo extends MongoRepository<Ticket,String> {

    @Query("{email : ?0, paid:?1}")
    public Ticket findByEmailPaid(String email,Boolean paid);

    @Query("{email : ?0}")
    public Ticket findByEmail(String email);
}
