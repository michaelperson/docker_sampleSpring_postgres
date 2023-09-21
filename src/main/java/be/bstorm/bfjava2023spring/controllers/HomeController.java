package be.bstorm.bfjava2023spring.controllers;

import be.bstorm.bfjava2023spring.entities.PersonEntity;
import be.bstorm.bfjava2023spring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping(path = {"/home"})
public class HomeController {
    private final PersonRepository personRepository;

    @Autowired
    public HomeController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public String indexAction(Map<String, Object> model) {
        personRepository.findByFirstname("Flavian");
        model.put("user", Arrays.asList("Flavian", "Gregory", "Le Commercial"));

        return "home/index";
    }

    @PostMapping
    public String createAction(PersonEntity entity) {
        this.personRepository.save(entity);

        return "redirect:/home";
    }
}
