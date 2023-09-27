package com.andersonchagas.gerenciadepessoas.services;


import com.andersonchagas.gerenciadepessoas.domain.People;
import com.andersonchagas.gerenciadepessoas.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository repository;

    public List<People> findAll() {
        return repository.findAll();
    }

    public People findById(Long id) {
        Optional<People> obj = repository.findById(id);
        return obj.get();
    }

    public People createPeople(People obj) {

        return repository.save(obj);
    }

    public People updatePeople(Long id, People people) {
        People newPeople = repository.getReferenceById(id);
        updateData(newPeople, people);
        return repository.save(newPeople);
    }

    public void deletePeople(Long id) {
        repository.deleteById(id);
    }

    /*Atualiza os dados da pessoa*/
    private void updateData(People newData, People data) {
        // TODO Auto-generated method stub
        newData.setName(data.getName());
        newData.setBirthDate(data.getBirthDate());
    }
}