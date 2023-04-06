package org.excercise.pizzeria.springlamiapizzeriacrud.controller;

import jakarta.validation.Valid;
import org.excercise.pizzeria.springlamiapizzeriacrud.model.Ingredient;
import org.excercise.pizzeria.springlamiapizzeriacrud.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("allIngredients", ingredientService.getAll());
        model.addAttribute("ingredientObj", new Ingredient());
        return "/ingredients/index";
    }

    @PostMapping("/save")
    public String doSave(@Valid @ModelAttribute(name = "ingredientObj") Ingredient ingredient,
                         BindingResult bs,
                         Model model) {
        if (bs.hasErrors()) {
            // ricreo la view ripassando l'ingrediente
            model.addAttribute("allIngredients", ingredientService.getAll());
            return "/ingredients/index";
        }
        // salvo i dati
        ingredientService.create(ingredient);
        return "redirect:/ingredients";
    }


}
