package com.personal.sistemaPersonal.controller;

import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.model.FichaTreino;
import com.personal.sistemaPersonal.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.personal.sistemaPersonal.service.PersonalService;

import java.util.ArrayList;
import java.util.List;

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
        if(personalService.getAll().size()>0){
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
