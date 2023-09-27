package testes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.andersonchagas.gerenciadepessoas.domain.Address;
import com.andersonchagas.gerenciadepessoas.domain.People;
import com.andersonchagas.gerenciadepessoas.repositories.AddressRepository;
import com.andersonchagas.gerenciadepessoas.repositories.PeopleRepository;
import com.andersonchagas.gerenciadepessoas.services.AddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @InjectMocks
    private AddressService service;

    @Mock
    private AddressRepository repository;

    @Mock
    private PeopleRepository peopleRepository;

    @Test
    void findAllAddressTest() {
        Address addresses = new Address(1L, "Rua 01", "58052188", "22", "João Pesoa", false);
        List<Address> listAddress = List.of(addresses);

        Mockito.when(repository.findAll()).thenReturn(listAddress);
        Assertions.assertNotNull(service.findAll());
    }

    @Test
    void findAddressByIdTest() {
        final Long id = 1L;
        Address address = new Address(1L, "Rua 01", "58052188", "22", "João Pesoa", false);

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(address));

        Assertions.assertNotNull(service.findById(id));

    }

    @Test
    void createAddressTest() {
        People people = new People(1L, "Alyson", LocalDate.now());
        Address address = new Address(1L, "Rua 01", "58052188", "22", "João Pesoa", false);
        address.setPeople(people);

        Mockito.when(peopleRepository.getReferenceById(1L)).thenReturn(people);
        Mockito.when(repository.findByIsMainAndPeople_Id(false, 1L)).thenReturn(Optional.empty());
        Mockito.when(repository.save(address)).thenReturn(address);

        Assertions.assertEquals(address, service.createAddress(1L, address));

    }

    @Test
    void updateAddressTest() {
        Long id = 1L;
        Address address = new Address(id, "Rua 01", "58052188", "22", "João Pesoa", false);
        Address newAddress = new Address(id, "Rua 05", "55554444", "145", "Itabaiana", true);

        Mockito.when(repository.getReferenceById(id)).thenReturn(address);
        Mockito.when(repository.save(newAddress)).thenReturn(newAddress);

        Assertions.assertEquals(newAddress, service.updateAddress(id, newAddress));

    }

    @Test
    void deleteAddressTest() {
        Long id = 1L;
        Address address = new Address(id, "Rua 01", "58052188", "22", "João Pesoa", false);

        service.deleteAddress(address.getId());
    }
}
