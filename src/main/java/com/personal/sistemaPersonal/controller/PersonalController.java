package com.personal.sistemaPersonal.controller;

import com.personal.sistemaPersonal.model.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.personal.sistemaPersonal.service.PersonalService;

@Controller
@RequestMapping("/personal")
public class PersonalController {
    @Autowired
    @Qualifier("personalServiceImpl")
    PersonalService personalService;

    @RequestMapping("/formPersonal")
    public String formPersonal(Model model){
        model.addAttribute("personal", new Personal());
        return "formCadastro";
    }
    @RequestMapping("/addPersonal")
    public String addPersonal(@ModelAttribute Personal personal){
        personalService.save(personal);
        return "home";
    }
}
