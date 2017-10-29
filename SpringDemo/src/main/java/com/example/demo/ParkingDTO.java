package com.example.demo;

public class ParkingDTO {
    private String parkingID;
    private String availability;
    public ParkingDTO(){

    }

    public ParkingDTO(String parkingID, String availability) {
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
}
