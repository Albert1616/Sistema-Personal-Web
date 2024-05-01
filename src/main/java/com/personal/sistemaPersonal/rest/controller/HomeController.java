package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.personal.sistemaPersonal.service.PersonalService;

@Controller
public class HomeController {
    @Autowired
    @Qualifier("personalServiceImpl")
    PersonalService personalService;
    @Autowired
    @Qualifier("alunoServiceImpl")
    AlunoService alunoService;
    @GetMapping("/")
    public String validateUser(){
        if(!personalService.getAll().isEmpty()){
            return "redirect:/home";
        }else{
            return "redirect:/personal/formPersonal";
        }
    };
    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("alunos",alunoService.getAll());
        return "home";
    }
}
