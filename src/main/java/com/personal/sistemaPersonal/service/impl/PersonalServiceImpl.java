package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.PersonalNaoEncontradoException;
import com.personal.sistemaPersonal.model.Personal;
import com.personal.sistemaPersonal.repository.PersonalRepository;
import com.personal.sistemaPersonal.rest.dto.InformacoesPersonalDTO;
import com.personal.sistemaPersonal.rest.dto.PersonalDTO;
import com.personal.sistemaPersonal.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    PersonalRepository personalRepository;

    @Override
    public InformacoesPersonalDTO save(PersonalDTO personal) {
        return convertToInformacoesPersonalDTO(personalRepository.save(Personal.convert(personal)));
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
    public List<InformacoesPersonalDTO> getAll() {
        return convertToInformacoesPersonalDTO(personalRepository.findAll());
    }

    @Override
    public InformacoesPersonalDTO convertToInformacoesPersonalDTO(Personal personal) {
        return InformacoesPersonalDTO
                .builder()
                .id(personal.getId())
                .nome(personal.getNome())
                .email(personal.getEmail())
                .dataNascimento(personal.getDataNascimento())
                .CREF(personal.getCREF())
                .build();
    }

    @Override
    public InformacoesPersonalDTO getInformacoesPersonalDTOById(Integer id) {
        return convertToInformacoesPersonalDTO(getById(id));
    }

    @Override
    public List<InformacoesPersonalDTO> convertToInformacoesPersonalDTO(List<Personal> personais) {
        if(CollectionUtils.isEmpty(personais)){
            return Collections.emptyList();
        }

        return personais.stream().map(
                personal -> InformacoesPersonalDTO
                        .builder()
                        .id(personal.getId())
                        .nome(personal.getNome())
                        .email(personal.getEmail())
                        .dataNascimento(personal.getDataNascimento())
                        .CREF(personal.getCREF())
                        .build()
        ).collect(Collectors.toList());
    }
}
