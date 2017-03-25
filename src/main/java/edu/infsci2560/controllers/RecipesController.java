/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.controllers;

import edu.infsci2560.models.Recipe;
import edu.infsci2560.repositories.RecipeRepository;
import edu.infsci2560.repositories.RatingRepository;
import edu.infsci2560.services.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RecipesController {
    @Autowired
    private RecipeRepository repository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private RatingService ratingService;
    
    //display all recipes
    @RequestMapping(value = "recipes", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("recipes", "recipes", repository.findAll());
    }
    
    //add a recipe
    @RequestMapping(value = "recipes/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid Recipe recipe, BindingResult result) {
        repository.save(recipe);
        return new ModelAndView("recipes", "recipes", repository.findAll());
    }
    
    //get all ratings of a recipe
    @RequestMapping(value="recipes/{recipeId}/ratings", method=RequestMethod.GET)
    public ModelAndView rating(@PathVariable("recipeId")Long recipeId){
        return new ModelAndView("ratings","ratings",ratingService.findAllRatingsForOne(recipeId));
    }

    

}
