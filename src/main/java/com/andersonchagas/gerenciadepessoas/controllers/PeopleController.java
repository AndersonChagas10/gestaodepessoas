package com.andersonchagas.gerenciadepessoas.controllers;
import java.util.List;

import javax.validation.Valid;

import com.andersonchagas.gerenciadepessoas.domain.People;
import com.andersonchagas.gerenciadepessoas.services.AddressService;
import com.andersonchagas.gerenciadepessoas.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
public class PeopleController {

    @Autowired
    private PeopleService service;

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/pessoas")
    @ResponseStatus(HttpStatus.OK)
    public List<People> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/pessoas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public People findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/pessoas")
    @ResponseStatus(HttpStatus.CREATED)
    public People create(@RequestBody @Valid People people) {
        return service.createPeople(people);
    }

    @PutMapping(value = "/pessoas/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public People updatePeople(@PathVariable Long id, @RequestBody @Valid People people) {
        return service.updatePeople(id, people);
    }

    @DeleteMapping(value = "/pessoas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deletePeople(id);
    }
}
