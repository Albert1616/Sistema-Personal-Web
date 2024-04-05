package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.AvalicaoFisica;
import com.personal.sistemaPersonal.model.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.personal.sistemaPersonal.repository.PersonalRepository;

import java.util.List;
import java.util.Optional;

@Component
public class PersonalServiceImpl implements PersonalService {
    @Autowired
    PersonalRepository personalRepository;

    @Override
    public boolean save(Personal personal) {
        try{
            personalRepository.save(personal);
            return true;
        }catch (Exception e){
            System.out.printf(e.toString());
            return false;
        }
    }

    @Override
    public boolean delete(Personal personal) {
        if(personalRepository.findById(personal.getId()).isPresent()){
            personalRepository.delete(personal);
            return true;
        }
        System.out.printf("Personal não encontrado!");
        return false;
    }

    @Override
    public boolean update(Integer id) {
        if(personalRepository.findById(id).isPresent()){
            Optional<Personal> personal = personalRepository.findById(id);
            personalRepository.save(personal.get());
            return true;
        }
        System.out.printf("Personal não encontrado!");
        return false;
    }

    @Override
    public List<Personal> getAll() {
        return personalRepository.findAll();
    }
}
