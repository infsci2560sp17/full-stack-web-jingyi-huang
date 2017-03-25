package edu.infsci2560.controllers;

import edu.infsci2560.repositories.*;
import edu.infsci2560.services.*;
import edu.infsci2560.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes/{recipeId}/ratings")
public class RatingController {
    
    @Autowired
    private RatingRepository ratingRepository;
    
    @Autowired    
    private RatingService ratingService;
    
     
    
    /*@RequestMapping(method=RequestMethod.GET)
    public modle
    @ResponseBody Rating find(@PathVariable("recipeId")Long recipeId){
        return ratingService.findAllRatingsForOne(recipeId);
    }*/
}
