package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.model.FichaTreino;
import com.personal.sistemaPersonal.service.AlunoService;
import com.personal.sistemaPersonal.service.AvaliacaoFisicaService;
import com.personal.sistemaPersonal.service.FichaTreinoService;
import com.personal.sistemaPersonal.service.TreinoService;
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

    @Autowired
    FichaTreinoService fichaTreinoService;

    @Autowired
    TreinoService treinoService;

    @RequestMapping("/formAluno")
    public String formAluno(Model model){
        Aluno aluno = new Aluno();
        FichaTreino fichaTreino = new FichaTreino();

        model.addAttribute("ficha_treino", fichaTreino);
        model.addAttribute("aluno", aluno);
        return "aluno/formAluno";
    }

    @RequestMapping("/showFormEdit/{idAluno}")
    public String showFormEdit(@PathVariable("idAluno") Integer idAluno, Model model){
        Aluno aluno = alunoService.getAlunoById(idAluno);

        model.addAttribute("ficha_treino", aluno.getFicha_treino());
        model.addAttribute("aluno", aluno);

        return "aluno/formAluno";
    }

    @RequestMapping("/addAluno")
    public String formAluno(@ModelAttribute("aluno") Aluno aluno, @ModelAttribute("ficha_treino") FichaTreino fichaTreino){
        if(fichaTreino.getId() == null){
            FichaTreino newFichaTreino = new FichaTreino();
            aluno.setFicha_treino(newFichaTreino);
        }else{
            aluno.setFicha_treino(fichaTreinoService.findById(fichaTreino.getId()));
        }

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
        model.addAttribute("treinos", treinoService.findByIdAluno(aluno.getId()));

        return "aluno/detailsAluno";
    }

    @RequestMapping("/deleteAluno/{id_aluno}")
    public String deleteAluno(@PathVariable("id_aluno") Integer idAluno){
        alunoService.delete(alunoService.getAlunoById(idAluno));

        return "redirect:/home";
    }
}
