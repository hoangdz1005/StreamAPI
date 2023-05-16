package com.java.StreamAPI.controller;

import com.java.StreamAPI.model.Person;
import com.java.StreamAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @GetMapping("/api/persons/Vietnam")
    public ResponseEntity<List<Person>> getPersonFromVietnam() {
        return ResponseEntity.ok().body(personRepository.findPeopleFromVietnam());
    }
    @GetMapping("/api/person/ConvertNameToUppercase")
    public ResponseEntity<List<String>> convertName() {
        return ResponseEntity.ok().body(personRepository.convertNameToUppercase());
    }
    @GetMapping("/api/person/FilterOldAndName")
    public ResponseEntity<List<Person>> filterOldAndName() {
        return ResponseEntity.ok().body(personRepository.personOld30AndName4());
    }
    @GetMapping("/api/person/FindPeopleFromCountry")
    public ResponseEntity<Map<String, List<Person>>> findPeopleFromCountry() {
        return ResponseEntity.ok().body(personRepository.findPeopleFromContry());
    }
    @GetMapping("/api/person/GetFourPersonOld30")
    public ResponseEntity<List<Person>> getFourPersonOld30() {
        return ResponseEntity.ok().body(personRepository.getFourPersonOle30());
    }

}
