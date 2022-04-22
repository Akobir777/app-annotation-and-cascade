package com.example.appannotationandcascade.controller;

import com.example.appannotationandcascade.entity.Address;
import com.example.appannotationandcascade.entity.Person;
import com.example.appannotationandcascade.payload.AddressDto;
import com.example.appannotationandcascade.payload.PersonDto;
import com.example.appannotationandcascade.reository.AddressRepository;
import com.example.appannotationandcascade.reository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;

    @GetMapping

    @Transactional(noRollbackFor = NullPointerException.class)
    @PostMapping
    public HttpEntity<?> addPerson(@RequestBody PersonDto personDto) {

        //Personni saqladik
        Person person = new Person();
        person.setFullName(personDto.getFullName());

        //Addres yasab olamiz
        List<Address> addresses = new ArrayList<>();
        for (AddressDto addressDto : personDto.getAddressDtoList()) {
            Address address = new Address(
                    addressDto.getStreet(),
                    addressDto.getCity()
                    , person);
            addresses.add(address);
        }
        person.setAddresses(addresses);
        personRepository.save(person);
        String var = null;
        boolean test = var.equals("test");

        return ResponseEntity.ok("Saqlandi");
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editPerson(@PathVariable Integer id) {

        //Personni saqladik
        Person person = personRepository.getOne(id);
        person.setFullName("Ism o'zgardi");

        for (Address address : person.getAddresses()) {
            address.setStreet("Ko'cha nomi o'zgardi");
        }

        personRepository.save(person);
        return ResponseEntity.ok("Saqlandi");
    }

    //    @DeleteMapping("/{id}")
//    public HttpEntity<?> deletPerson(@PathVariable Integer id){
//
//    }
    @DeleteMapping("/forTransaction/{id}")
    public HttpEntity<?> deletPerson(@PathVariable Integer id) {
        personRepository.deleteById(id);
        throw new NullPointerException();
//        return ResponseEntity.ok("o'chirildi");
    }
}
