package com.bnta.chocolate.controllers;


import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateRepository chocolateRepository;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(){
        return new ResponseEntity<>(chocolateRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable int id){
//        Optional<Chocolate> chocolate = chocolateService.getChocolateById(id);
        return new ResponseEntity(chocolateRepository.findById(id), HttpStatus.OK);
    }
//Postmapping and then it should work
    @PostMapping
    public ResponseEntity<Chocolate> createChocolate(@RequestBody Chocolate chocolate1){
       Chocolate chocolate = chocolateRepository.save(chocolate1);

        return new ResponseEntity<>(chocolate, HttpStatus.CREATED);

    }



}
