package edu.infsci2560.controllers;

import edu.infsci2560.repositories.*;
import edu.infsci2560.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class RatingController {
    
    @Autowired
    private RatingRepository ratingRepository;
    
    @Autowired    
    private RatingService ratingService;
    
     
    
    @RequestMapping(value="/recipes/{recipeId}/ratings", method=RequestMethod.GET)
    public ModelAndView Ratings(@PathVariable("recipeId") Long recipeId){
        return new ModelAndView("ratings","ratings",ratingService.findAllRatingsForOne(recipeId));
    }
    
    
}
