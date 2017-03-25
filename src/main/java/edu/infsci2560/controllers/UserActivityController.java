package edu.infsci2560.controllers;

import org.springframework.stereotype.Controller;
import edu.infsci2560.repositories.*;
import edu.infsci2560.services.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class UserActivityController {
    @Autowired
    private RatingService ratingService;
    
    //user rates a recipe with login
    @RequestMapping(value="users/{userId}/{recipeId}/rating",method=RequestMethod.PUT)
    public ModelAndView Rating(@PathVariable("userId") Long userId, @PathVariable("recipeId")Long recipeId,@RequestParam("score") Integer score, @RequestParam("comment") String comment){
        return new ModelAndView("rating", "rating",ratingService.create(recipeId, userId,score,comment));
    }
       
    
}
