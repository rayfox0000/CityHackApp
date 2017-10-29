package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Parking")
public class Parking {
    private String parkingID;
    private String availability;

    public Parking(){

    }

    public Parking(String parkingID, String availability) {
        this.parkingID = parkingID;
        this.availability = availability;
    }

    public String getParkingID() {
        return parkingID;
    }

    public void setParkingID(String parkingID) {
        this.parkingID = parkingID;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Parking(ParkingDTO parkingDTO){
        this.parkingID =parkingDTO.getParkingID();
        this.availability = parkingDTO.getAvailability();
    }
    public ParkingDTO toDTO(){
        ParkingDTO parkingDTO = new ParkingDTO();
        parkingDTO.setParkingID(parkingID);
        parkingDTO.setAvailability(availability);
        return parkingDTO;
    }
//    public List<ParkingDTO> toDTO(){
//
//        ParkingDTO parkingDTO = new ParkingDTO();
//
//        parkingDTO.setParkingID(parkingID);
//        parkingDTO.setAvailability(availability);
//        return parkingDTO ;
//    }
}
