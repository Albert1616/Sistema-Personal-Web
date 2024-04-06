package com.personal.sistemaPersonal.controller;

import com.personal.sistemaPersonal.model.AvalicaoFisica;
import com.personal.sistemaPersonal.service.AlunoService;
import com.personal.sistemaPersonal.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
@RequestMapping("/avaliacao_fisica")
public class AvaliacaoFisicaController {

    @Autowired
    AvaliacaoFisicaService avaliacaoFisicaService;

    @Qualifier("alunoServiceImpl")
    @Autowired
    private AlunoService alunoService;

    @RequestMapping("/showForm/{idAluno}")
    public String showForm(@PathVariable("idAluno") Integer idAluno, Model model) {
        AvalicaoFisica avalicaoFisica = new AvalicaoFisica();
        avalicaoFisica.setData(LocalDate.now());
        avalicaoFisica.setAluno(alunoService.getAlunoById(idAluno));

        model.addAttribute("avaliacao_fisica", avalicaoFisica);

        return "avaliacao_fisica/formAvaliacaoFisica";
    }

    @RequestMapping("/showFormEdit/{idAvaliacaoFisica}")
    public String showFormEdit(@PathVariable("idAvaliacaoFisica") Integer idAvaliacaoFisica, Model model) {
        model.addAttribute("avaliacao_fisica", avaliacaoFisicaService.getAvaliacaoFisicaById(idAvaliacaoFisica));

        return "avaliacao_fisica/formAvaliacaoFisica";
    }

    @RequestMapping("/addAvaliacaoFisica")
    public String addAvaliacaoFisica(@ModelAttribute AvalicaoFisica avaliacaoFisica) {
        avaliacaoFisicaService.save(avaliacaoFisica);

        return "redirect:/aluno/detailsAluno/" + avaliacaoFisica.getAluno().getId();
    }

    @RequestMapping("/deleteAvaliacaoFisica/{id}")
    public String deleteAvaliacaoFisica(@PathVariable("id") Integer id) {
        AvalicaoFisica avaliacaoFisica = avaliacaoFisicaService.getAvaliacaoFisicaById(id);
        avaliacaoFisicaService.delete(avaliacaoFisica);

        return "redirect:/aluno/detailsAluno/" + avaliacaoFisica.getAluno().getId();
    }

    @RequestMapping("/showDetails/{id}")
    public String getDetailsAvaliacaoFisica(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("avaliacao_fisica", avaliacaoFisicaService.getAvaliacaoFisicaById(id));

        return "/avaliacao_fisica/detailsAvaliacaoFisica";
    }
}
