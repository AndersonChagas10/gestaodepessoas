package com.andersonchagas.gerenciadepessoas.repositories;


import java.util.List;

import com.andersonchagas.gerenciadepessoas.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PeopleRepository extends JpaRepository<People, Long> {

    List<People> findAll();

}