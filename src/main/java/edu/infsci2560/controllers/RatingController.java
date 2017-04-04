package edu.infsci2560.controllers;


import org.springframework.stereotype.Controller;
import edu.infsci2560.models.Recipe;
import edu.infsci2560.repositories.RecipeRepository;
import edu.infsci2560.repositories.RatingRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;

@Controller
public class RatingController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @RequestMapping(value = "recipes/edit/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("recipeEdit");
        Recipe recipe = recipeRepository.findOne(id);
        mv.addObject("recipe", recipe);
        mv.addObject("ratings", ratingRepository.findByRatingPkRecipeId(recipe.getId(), new PageRequest(0, 10)));
        return mv;
    }

    @RequestMapping(value = "recipes/edit/{id}",
            method = RequestMethod.PUT,
            consumes="application/x-www-form-urlencoded",
            produces = "application/json")
    public String update( @Valid Recipe recipe, BindingResult result) {
        recipeRepository.save(recipe);
        return "redirect:/recipes";
    }
    
    
    
}
