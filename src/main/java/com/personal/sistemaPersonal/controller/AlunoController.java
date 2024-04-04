package com.personal.sistemaPersonal.controller;

import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.model.Avalicao;
import com.personal.sistemaPersonal.model.FichaTreino;
import com.personal.sistemaPersonal.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    @Qualifier("alunoServiceImpl")
    AlunoService alunoService;

    @RequestMapping("/formAluno")
    public String formAluno(Model model){
        Aluno aluno = new Aluno();
        Avalicao avalicao = new Avalicao();
        avalicao.setAluno(aluno);
        aluno.adicionarAvalicao(avalicao);
        model.addAttribute("aluno", aluno);
        return "aluno/formAluno";
    }
    @RequestMapping("/addAluno")
    public String formAluno(@ModelAttribute Aluno aluno){
        alunoService.save(aluno);
        return "redirect:/home";
    }
}
