/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.repositories;

import edu.infsci2560.models.Recipe;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecipeRepository extends PagingAndSortingRepository<Recipe,Long> {

  @Override
  @RestResource(exported = false)
  void delete(Long long);


  @Override
  @RestResource(exported = false)
  void delete(Recipe recipe);


  @Override
  @RestResource(exported = false)
  void delete(Iterable<? extends Recipe> iterable);


  @Override
  @RestResource(exported = false)
  void deleteAll();
}
