package com.example.appannotationandcascade.controller;

import com.example.appannotationandcascade.entity.Address;
import com.example.appannotationandcascade.payload.AddressDto;
import com.example.appannotationandcascade.reository.AddressRepository;
import com.example.appannotationandcascade.reository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public HttpEntity<?> addPerson(@RequestBody List<AddressDto> addressDtoList) {

        List<Address> addresses = new ArrayList<>();
        for (AddressDto addressDto : addressDtoList) {
            Address address = new Address(addressDto.getStreet(), addressDto.getCity(), personRepository.getOne(addressDto.getPersonId()));
            addresses.add(address);
        }
addressRepository.saveAll(addresses);
        return ResponseEntity.ok("Saqlandi");
    }
}
