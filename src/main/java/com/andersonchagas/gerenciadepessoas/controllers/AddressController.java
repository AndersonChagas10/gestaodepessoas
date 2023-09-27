package com.andersonchagas.gerenciadepessoas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.andersonchagas.gerenciadepessoas.domain.Address;
import com.andersonchagas.gerenciadepessoas.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping(value = "/enderecos")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> findAll() {

        return service.findAll();
    }

    @GetMapping(value = "/enderecos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address findById(@PathVariable Long id) {

        return service.findById(id);
    }

    @PostMapping(value = "/pessoas/{id}/endereco")
    @ResponseStatus(HttpStatus.CREATED)
    public Address createAddress(@PathVariable Long id, @RequestBody @Valid Address address) {

        return service.createAddress(id, address);
    }

    @PutMapping(value = "/enderecos/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Address updateAddress(@PathVariable Long id, @RequestBody @Valid Address address) {

        return service.updateAddress(id, address);
    }

    @DeleteMapping(value = "/enderecos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable Long id) {

        service.deleteAddress(id);
    }

}
