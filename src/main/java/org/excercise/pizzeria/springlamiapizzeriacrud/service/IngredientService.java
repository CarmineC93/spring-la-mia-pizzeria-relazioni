package org.excercise.pizzeria.springlamiapizzeriacrud.service;

import org.excercise.pizzeria.springlamiapizzeriacrud.model.Ingredient;
import org.excercise.pizzeria.springlamiapizzeriacrud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getAll(){
        return ingredientRepository.findAll(Sort.by("name"));
    }

    public Ingredient create(Ingredient formIngredient) {
        Ingredient ingredientToCreate = new Ingredient();
        ingredientToCreate.setName(formIngredient.getName());
        ingredientToCreate.setDescription(formIngredient.getDescription());
        return ingredientRepository.save(ingredientToCreate);
    }

}
