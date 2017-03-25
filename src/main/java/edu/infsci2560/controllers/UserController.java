package edu.infsci2560.controllers;

import edu.infsci2560.models.User;
import edu.infsci2560.services.*;
import edu.infsci2560.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class UserController {
    
    @Autowired
    private UserRepository repository;
    @Autowired 
    private UserService service;
    
    //user list
    @RequestMapping(value="users",method=RequestMethod.GET)
    public ModelAndView userlist(){
        return new ModelAndView("users","users",service.list());
    }
    
    //find user by userId
    @RequestMapping(value="users/{userId}",method=RequestMethod.GET)
    public ModelAndView user(@PathVariable("userId") Long userId){
        
        return new ModelAndView("users","users",service.findById(userId));    
    }
    
    //find users in the same city
    @RequestMapping(value="users/{city}",method = RequestMethod.GET)
    public ModelAndView userByCity(@PathVariable("city") String city){
        return new ModelAndView("users", "users", service.findByCity(city));
    }
    
    //add a user
    @RequestMapping(value="users/add", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam("username") String username, @RequestParam("email")String email, @RequestParam("password") String password,@RequestParam("city")String city){
        User newUser = new User(username,password,email,city);
        return new ModelAndView("users","users",service.create(newUser));      
    }
    
}
