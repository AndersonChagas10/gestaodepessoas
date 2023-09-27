package com.andersonchagas.gerenciadepessoas.repositories;

import java.util.Optional;

import com.andersonchagas.gerenciadepessoas.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByIsMainAndPeople_Id(Boolean isMain, Long id);

}