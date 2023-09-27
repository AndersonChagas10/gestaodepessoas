package com.andersonchagas.gerenciadepessoas.services;

import java.util.List;
import java.util.Optional;

import com.andersonchagas.gerenciadepessoas.domain.Address;
import com.andersonchagas.gerenciadepessoas.domain.People;
import com.andersonchagas.gerenciadepessoas.repositories.AddressRepository;
import com.andersonchagas.gerenciadepessoas.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;




@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private PeopleRepository peopleRepository;

    public List<Address> findAll() {
        return repository.findAll();
    }

    public Address findById(Long id) {
        Optional<Address> address = repository.findById(id);
        return address.get();
    }

    public Address createAddress(Long id, Address address) {
        People people = peopleRepository.getReferenceById(id);
        address.setPeople(people);
        validateMainAddress(address);
        return repository.save(address);
    }

    public Address updateAddress(Long id, Address address) {
        Address newAddress = repository.getReferenceById(id);
        updateData(newAddress, address);
        return repository.save(newAddress);
    }

    public void deleteAddress(Long id) {
        repository.deleteById(id);
    }

    private void updateData(Address newAddress, Address address) {
        // TODO Auto-generated method stub
        newAddress.setStreet(address.getStreet());
        newAddress.setPostalCode(address.getPostalCode());
        newAddress.setNumber(address.getNumber());
        newAddress.setCity(address.getCity());
    }

    /* Aqui define o end. principal */
    private void validateMainAddress(Address address) {
        if (address.getIsMain() == null) {
            address.setIsMain(false);
        }
        if (address.getIsMain()) {
            if (repository.findByIsMainAndPeople_Id(address.getIsMain(), address.getPeople().getId()).isPresent()) {

                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                        "Endereço principal já foi definido.");
            }
        }

    }
}