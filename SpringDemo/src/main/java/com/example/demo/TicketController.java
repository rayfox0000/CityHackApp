package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TicketController {
    @Autowired
    private TicketService TicketService;

    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    //@RequestMapping(value = "/register",method=RequestMethod.POST)
    @ResponseBody
    public TicketDTO TicketCheckAndCreate() {
        Boolean paid = false;
        String email = "system";
//        TicketDTO ticketDTO = TicketService.findByEmailPaid(email, paid);
        //System.out.println(UserDTO);
        Date current = new Date();
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setEnterTime(current.toString());
        ticketDTO.setEmail(email);
        ticketDTO.setPaid(paid);

        if (ticketDTO != null) {
            //If ticket has unpaid ticket, then send null back to android.

            return null;
        } else {

            Date date = new Date();
            String now = date.toString();
            ticketDTO = new TicketDTO(email, now);
            TicketService.save(ticketDTO);
            return ticketDTO;
        }
    }
    //Calculate Ticket price
    @RequestMapping(value = "/calculatePrice", method = RequestMethod.GET)
    //@RequestMapping(value = "/register",method=RequestMethod.POST)
    @ResponseBody
    public TicketDTO calculatePrice(@RequestParam(value = "email")String email) {
        TicketDTO ticketDTO = TicketService.findByEmail(email);
        //System.out.println(UserDTO);
        Date now = new Date();
        ticketDTO.setPaid(false);
        ticketDTO.setExitTime(now.toString());
        String Time1 = ticketDTO.getEnterTime();
        String Time2 = ticketDTO.getExitTime();

        // date format
        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(Time1);
            d2 = format.parse(Time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        long diff = d2.getTime() - d1.getTime();
        long diffHours = diff / (60 * 60 * 1000);
        double price = 1+(diffHours -3);
        if(price <0.9){
            ticketDTO.setPrice(0);

        }else {
            ticketDTO.setPrice(price);
        }
        if (ticketDTO != null) {
            TicketService.save(ticketDTO);

            return ticketDTO;
        } else {

            return null;
        }
    }

    //After Calculate and Press MasterCard payment
    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    //@RequestMapping(value = "/register",method=RequestMethod.POST)
    @ResponseBody
    public TicketDTO Pay(@RequestParam(value = "ticketID")String ticketID) {
        TicketDTO ticketDTO = TicketService.findByEmail(ticketID);
        //System.out.println(UserDTO);
        if (ticketDTO != null) {
            ticketDTO.setPaid(true);
            TicketService.save(ticketDTO);
            return ticketDTO;
        } else {

            return null;
        }
    }



    @RequestMapping(value = "/ticketCheck", method = RequestMethod.GET)
    @ResponseBody
    public TicketDTO TicketCheck(@RequestParam(value = "email") String email) {
        Boolean paid = false;
        TicketDTO ticketDTO = TicketService.findByEmailPaid(email, paid);
        //System.out.println(UserDTO);
        if(ticketDTO != null){
            //If ticket has unpaid ticket, then send null back to android.
            return ticketDTO;
        }
        else{

            return null;
        }



    }
}
