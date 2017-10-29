package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService UserService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    //@RequestMapping(value = "/register",method=RequestMethod.POST)
    @ResponseBody
    public UserDTO Login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {

        UserDTO userDTO = UserService.findByEmailPassword(email, password);
        if (userDTO != null) {
            System.out.println("Coming in");
            return userDTO;
        } else {
            System.out.println("Coming NULL");

            return null;

        }
    }
    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    //@RequestMapping(value = "/register",method=RequestMethod.POST)
    @ResponseBody
    public UserDTO Register(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        UserDTO userDTO = UserService.findByEmail(email);
        //System.out.println(UserDTO);
        if(userDTO != null){
            return null;
        }
        else{
            userDTO = new UserDTO(email,password);
            UserService.save(userDTO);
            return userDTO;
        }

//        UserDTO UserDTO = UserService.findByEmail(email);
//        if (UserDTO != null) {
//            UserDTO UserDTO = new UserDTO(username, password, email);
//            return UserDTO;
//        }
//
//
//        UserDTO UserDTO = UserService.findByUsernamePassword(email, password);
//        if (UserDTO != null) {
//            System.out.println("Hello is me, the mel");
//
//            return UserDTO;
//        } else {
//            System.out.println("Hello is me, the ray");
//
//            return null;
//
//        }


    }




}