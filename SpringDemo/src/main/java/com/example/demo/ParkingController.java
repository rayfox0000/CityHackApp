package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
@Controller
public class ParkingController {
    @Autowired
    private ParkingService ParkingService;
    //Sensor Function
    @RequestMapping(value = "/parkingUpdate", method = RequestMethod.GET)
    //@RequestMapping(value = "/register",method=RequestMethod.POST)
    @ResponseBody
    public List<ParkingDTO> ParkingUpdate(@RequestParam(value = "parkingID") String parkingID) {

        ParkingDTO parkingDTO = ParkingService.findByID(parkingID);
        if(parkingDTO != null){
            if(parkingDTO.getAvailability().equals("true") ){
                parkingDTO.setAvailability("false");

            }
            else{
                parkingDTO.setAvailability("true");
            }
            ParkingService.save(parkingDTO);
        }
        List<ParkingDTO> parkingDTO1 = ParkingService.findByAvailability("true");
        return parkingDTO1;



//
//        parkingDTO.setParkingAvailability(parkingAvailability);
//        parkingDTO.setParkingName(parkingName);
//        parkingService.save(parkingDTO);
//
//        return parkingDTO;

    }

}
