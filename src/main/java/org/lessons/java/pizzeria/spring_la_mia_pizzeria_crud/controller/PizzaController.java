package org.lessons.java.pizzeria.spring_la_mia_pizzeria_crud.controller;

import java.util.List;
import java.util.Optional;

import org.lessons.java.pizzeria.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.pizzeria.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @PostConstruct
    public void init() {
        // Controlla se ci sono già pizze nel database
        if (pizzaRepository.count() == 0) {
            // Popola il database con alcune pizze di esempio
            Pizza pizza1 = new Pizza();
            pizza1.setNome("Margherita");
            pizza1.setDescrizione("Pizza classica con pomodoro e mozzarella");
            pizza1.setUrlFoto("https://example.com/margherita.jpg");
            pizza1.setPrezzo(7.50);
            pizzaRepository.save(pizza1);

            Pizza pizza2 = new Pizza();
            pizza2.setNome("Pepperoni");
            pizza2.setDescrizione("Pizza con salame piccante e mozzarella");
            pizza2.setUrlFoto("https://example.com/pepperoni.jpg");
            pizza2.setPrezzo(8.00);
            pizzaRepository.save(pizza2);
        }
    }

    @GetMapping("")
    public String getPizza(Model model) {

        // Recupero tutte le pizze
        List<Pizza> pizze = pizzaRepository.findAll();

        // Passo le pizze alla view
        model.addAttribute("pizze", pizze);

        // Restituisco la view
        return "index";
    }

    @GetMapping("/{id}")
    public String showPizza(@PathVariable("id") Integer id, Model model) {
        Optional<Pizza> result = pizzaRepository.findById(id);

        if (result.isPresent()) {
            model.addAttribute("pizza", result.get());
            return "show"; 
        } else {
            return "not-found";
        }
    }

}
