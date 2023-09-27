package testes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.andersonchagas.gerenciadepessoas.domain.Address;
import com.andersonchagas.gerenciadepessoas.domain.People;
import com.andersonchagas.gerenciadepessoas.repositories.PeopleRepository;
import com.andersonchagas.gerenciadepessoas.services.PeopleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

public class PeopleServiceTest {

    @InjectMocks
    private PeopleService service;

    @Mock
    private PeopleRepository repository;

    @Test
    void findAllPeopleTest() {
        Long id = 1L;
        People people = new People(id, "Anderson Chagas", LocalDate.now());
        List<Address> addresses = List.of(new Address(id, "Rua Cristo Redentor", "45077660", "25", "Vitoria da Conquista", false));
        people.setAddress(addresses);
        List<People> peopleList = List.of(people);

        Mockito.when(repository.findAll()).thenReturn(peopleList);

        Assertions.assertNotNull(service.findAll());

    }

    @Test
    void findPeopleById() {
        Long id = 1L;
        People people = new People(id, "Anderson Chagas", LocalDate.now());

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(people));

        Assertions.assertNotNull(service.findById(id));

    }

    @Test
    void createPeopleTest() {
        Long id = 1L;
        People people = new People(id, "Anderson Chagas", LocalDate.now());

        Mockito.when(repository.save(people)).thenReturn(people);

        Assertions.assertNotNull(service.createPeople(people));
    }

    @Test
    void updatePeopleTest() {
        Long id = 1L;
        People people = new People(id, "Anderson Chagas", LocalDate.now());
        People newPeople = new People(id, "Anderson Almeida Chagas", LocalDate.now());

        Mockito.when(repository.getReferenceById(id)).thenReturn(people);
        Mockito.when(repository.save(newPeople)).thenReturn(newPeople);

        Assertions.assertEquals(newPeople, service.updatePeople(id, newPeople));

    }

    @Test
    void deletePeopleTest() {
        Long id = 1L;
        People people = new People(id, "Anderson Chagas", LocalDate.now());

        service.deletePeople(people.getId());
    }
}
