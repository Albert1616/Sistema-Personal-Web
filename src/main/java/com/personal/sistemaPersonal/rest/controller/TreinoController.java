package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.model.FichaTreino;
import com.personal.sistemaPersonal.model.Treino;
import com.personal.sistemaPersonal.service.AlunoService;
import com.personal.sistemaPersonal.service.ExercicioService;
import com.personal.sistemaPersonal.service.FichaTreinoService;
import com.personal.sistemaPersonal.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/treino")
public class TreinoController {

    @Autowired
    TreinoService treinoService;

    @Autowired
    ExercicioService exercicioService;

    @Autowired
    AlunoService alunoService;

    @Autowired
    FichaTreinoService fichaTreinoService;

    @RequestMapping("/showForm/{idAluno}")
    public String showForm(@PathVariable("idAluno") Integer idAluno, Model model) {
        Treino treino = new Treino();
        treino.setFicha_treino(alunoService.getAlunoById(idAluno).getFicha_treino());
        treino.setData_criacao(LocalDate.now());

        model.addAttribute("treino", treino);
        model.addAttribute("exercicios", exercicioService.getAll());

        return "treino/formTreino";
    }

    @RequestMapping("/showEditForm/{idTreino}")
    public String showEditForm(@PathVariable("idTreino") Integer idTreino, Model model) {
        model.addAttribute("treino", treinoService.findById(idTreino));
        model.addAttribute("exercicios", exercicioService.getAll());

        return "treino/formTreino";
    }

    @RequestMapping("/addTreino")
    public String addTreino(@ModelAttribute("treino") Treino treino) {
        treinoService.save(treino);
        FichaTreino fichaTreino = fichaTreinoService.findById(treino.getFicha_treino().getId());

        return "redirect:/aluno/detailsAluno/" + fichaTreino.getAluno().getId();
    }

    @RequestMapping("/deleteTreino/{id}")
    public String deleteTreino(@PathVariable("id") Integer idTreino) {
        Treino treino = treinoService.findById(idTreino);
        treinoService.delete(treino);

        return "redirect:/aluno/detailsAluno/" + treino.getFicha_treino().getAluno().getId();
    }
}
