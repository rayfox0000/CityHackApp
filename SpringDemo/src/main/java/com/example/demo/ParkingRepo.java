package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ParkingRepo extends MongoRepository<Parking,String> {
//
//    @Query("{email : ?0, paid:?1}")
//    public Ticket findByEmailPaid(String email,Boolean paid);
//
//    @Query("{ticketID : ?0}")
//    public Ticket findByTicket(String ticketID);

    @Query("{parkingID:?0}")
    public Parking findByID(String parkingID);

    @Query("{availability:?0}")
    public List<Parking> findByAvailability(String availability);

}
