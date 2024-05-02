package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.PersonalNaoEncontradoException;
import com.personal.sistemaPersonal.model.Personal;
import com.personal.sistemaPersonal.repository.PersonalRepository;
import com.personal.sistemaPersonal.rest.dto.response.PersonalResponseDTO;
import com.personal.sistemaPersonal.rest.dto.request.PersonalRequestDTO;
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
    public PersonalResponseDTO save(PersonalRequestDTO personal) {
        return convertToPersonalResponseDTO(personalRepository.save(Personal.convert(personal)));
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
    public void update(Integer id, PersonalRequestDTO personalDTO) {
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
    public List<PersonalResponseDTO> getAll() {
        return convertToPersonalResponseDTO(personalRepository.findAll());
    }

    @Override
    public PersonalResponseDTO convertToPersonalResponseDTO(Personal personal) {
        return PersonalResponseDTO
                .builder()
                .id(personal.getId())
                .nome(personal.getNome())
                .email(personal.getEmail())
                .dataNascimento(personal.getDataNascimento())
                .CREF(personal.getCREF())
                .build();
    }

    @Override
    public PersonalResponseDTO getInformacoesPersonalDTOById(Integer id) {
        return convertToPersonalResponseDTO(getById(id));
    }

    @Override
    public List<PersonalResponseDTO> convertToPersonalResponseDTO(List<Personal> personais) {
        if(CollectionUtils.isEmpty(personais)){
            return Collections.emptyList();
        }

        return personais.stream().map(
                personal -> PersonalResponseDTO
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
