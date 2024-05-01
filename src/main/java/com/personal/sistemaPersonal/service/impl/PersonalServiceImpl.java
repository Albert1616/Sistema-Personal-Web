package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.PersonalNaoEncontradoException;
import com.personal.sistemaPersonal.model.Personal;
import com.personal.sistemaPersonal.repository.PersonalRepository;
import com.personal.sistemaPersonal.rest.dto.PersonalDTO;
import com.personal.sistemaPersonal.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    PersonalRepository personalRepository;

    @Override
    public Personal save(PersonalDTO personal) {
        return personalRepository.save(Personal.convert(personal));
    }

    @Override
    public Personal getById(Integer id){
        Optional<Personal> personal = personalRepository.findById(id);
        if(personal.isPresent()) {
            return personal.get();
        }
        else throw new PersonalNaoEncontradoException();
    }

    @Override
    public void delete(Integer id) {
        Optional<Personal> personal = personalRepository.findById(id);
        if(personal.isPresent()) {
            personalRepository.delete(personal.get());
        }
        else throw new PersonalNaoEncontradoException();
    }

    @Override
    public void update(Integer id, PersonalDTO personalDTO) {
        Optional<Personal> personalOptional = personalRepository.findById(id);
        if(personalOptional.isPresent()) {
            Personal personal = personalOptional.get();
            personal.setNome(personalDTO.getNome());
            personal.setEmail(personalDTO.getEmail());
            personal.setDataNascimento(personalDTO.getDataNascimento());
            personal.setCREF(personalDTO.getCREF());
            personalRepository.save(personal);
        }
        else throw new PersonalNaoEncontradoException();
    }

    @Override
    public List<Personal> getAll() {
        return personalRepository.findAll();
    }
}
