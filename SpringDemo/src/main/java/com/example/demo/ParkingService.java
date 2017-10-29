package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class ParkingService {

    @Autowired
    private ParkingRepo parkingRepo;

//    @Transactional
//    public TicketDTO findByEmailPaid(String email, Boolean paid){
//        System.out.println("username"+email + " "+paid);
//        Ticket ticket = ticketRepo.findByEmailPaid(email,paid);
//        if(ticket != null){
//            return ticket.toDTO();
//        }
//        else{
//            return null;
//        }
//    }
@Transactional
public ParkingDTO findByID(String parkingID){
    Parking parking = parkingRepo.findByID(parkingID);
    if(parking != null){
        return parking.toDTO();
    }
    else{
        return null;
    }


}


    @Transactional
    public List<ParkingDTO> findByAvailability(String availability) {
        List<Parking> parking = parkingRepo.findByAvailability(availability);
        List<ParkingDTO> parkingDTOS= new ArrayList<ParkingDTO>();
        for (Parking park:parking) {
            parkingDTOS.add(park.toDTO());
        }
        return parkingDTOS;
    }
//    @Transactional
//    public TicketDTO findByTicket(String ticketID){
//        Ticket ticket = ticketRepo.findByTicket(ticketID);
//        if(ticket != null){
//            return ticket.toDTO();
//        }
//        else{
//            return null;
//        }
//    }
    public void save(ParkingDTO parkingDTO){
        Parking parking = new Parking(parkingDTO);
        parkingRepo.save(parking);
    }

}