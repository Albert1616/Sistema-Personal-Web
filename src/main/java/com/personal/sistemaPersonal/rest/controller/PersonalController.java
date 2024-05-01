package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.model.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.personal.sistemaPersonal.service.PersonalService;

import java.util.List;

@RestController
@RequestMapping("/api/personal")
public class PersonalController {

    @Autowired
    PersonalService personalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Personal save(@RequestBody Personal personal){
        return personalService.save(personal);
    }
    @RequestMapping("/addPersonal")
    public String addPersonal(@ModelAttribute Personal personal){
        personalService.save(personal);
        return "redirect:/home";
    }
    @RequestMapping("/detailsPersonal")
    public String detailsPersonal(Model model){
        List<Personal> lst_personal = personalService.getAll();
        model.addAttribute("personal", lst_personal.get(0));
        return "personal/detailsPersonal";
    }
    @RequestMapping("deletePersonal")
    public String deletePersonal(){
        personalService.deleteAll();
        return "redirect:/";
    }
}
