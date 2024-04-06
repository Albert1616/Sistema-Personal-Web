package com.personal.sistemaPersonal.controller;

import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.model.AvalicaoFisica;
import com.personal.sistemaPersonal.model.FichaTreino;
import com.personal.sistemaPersonal.service.AlunoService;
import com.personal.sistemaPersonal.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    @Qualifier("alunoServiceImpl")
    AlunoService alunoService;

    @Autowired
    AvaliacaoFisicaService avaliacaoFisicaService;

    @RequestMapping("/formAluno")
    public String formAluno(Model model){
        model.addAttribute("aluno", new Aluno());
        return "aluno/formAluno";
    }

    @RequestMapping("/showFormEdit/{idAluno}")
    public String showFormEdit(@PathVariable("idAluno") Integer idAluno, Model model){
        model.addAttribute("aluno", alunoService.getAlunoById(idAluno));

        return "aluno/formAluno";
    }

    @RequestMapping("/addAluno")
    public String formAluno(@ModelAttribute("aluno") Aluno aluno){
        alunoService.save(aluno);

        return "redirect:/aluno/detailsAluno/" + aluno.getId();
    }

    @RequestMapping("/getAlunos")
    public String getListaAlunos(Model model){
        model.addAttribute(alunoService.getAll());

        return "aluno/listAlunos";
    }

    @RequestMapping("/detailsAluno/{id_aluno}")
    public String getDetailsAluno(@PathVariable("id_aluno") Integer id, Model model){
        Aluno aluno = alunoService.getAlunoById(id);
        model.addAttribute("aluno", aluno);
        model.addAttribute("avaliacoes_fisicas", avaliacaoFisicaService.getAvaliacoesFisicasByIdAluno(aluno.getId()));

        return "aluno/detailsAluno";
    }

    @RequestMapping("/deleteAluno/{id_aluno}")
    public String deleteAluno(@PathVariable("id_aluno") Integer idAluno){
        alunoService.delete(alunoService.getAlunoById(idAluno));

        return "redirect:/home";
    }
}
