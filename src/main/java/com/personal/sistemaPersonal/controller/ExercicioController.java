package com.personal.sistemaPersonal.controller;

import com.personal.sistemaPersonal.model.Exercicio;
import com.personal.sistemaPersonal.service.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exercicio")
public class ExercicioController {

    @Autowired
    ExercicioService exercicioService;

    @RequestMapping("/showForm")
    public String showFormExercicio(Model model) {
        model.addAttribute("exercicio", new Exercicio());

        return "exercicio/formExercicio";
    }

    @RequestMapping("/showFormEdit/{id}")
    public String showFormEditExercicio(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("exercicio", exercicioService.getAvaliacaoFisicaById(id));

        return "exercicio/formExercicio";
    }

    @RequestMapping("/addExercicio")
    public String addExercicio(@ModelAttribute Exercicio exercicio){
        exercicioService.save(exercicio);

        return "redirect:/exercicio/showListaExercicio";
    }

    @RequestMapping("/deleteExercicio/{id}")
    public String deleteExercicio(@PathVariable("id") Integer id) {
        exercicioService.delete(exercicioService.getAvaliacaoFisicaById(id));

        return "redirect:/exercicio/showListaExercicio";
    }

    @RequestMapping("/showDetailsExercicio/{id}")
    public String getDetailsExercicio(@PathVariable("id") Integer id, Model model) {
        model.addAttribute(exercicioService.getAvaliacaoFisicaById(id));

        return "exercicio/detailsExercicio";
    }

    @RequestMapping("/showListaExercicio")
    public String getAllExercicio(Model model) {
        model.addAttribute("exercicios", exercicioService.getAll());

        return "exercicio/listExercicios";
    }
}
