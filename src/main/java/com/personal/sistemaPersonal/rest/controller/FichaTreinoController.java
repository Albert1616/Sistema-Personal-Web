package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.service.FichaTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ficha_treino")
public class FichaTreinoController {

    @Autowired
    FichaTreinoService fichaTreinoService;


}
