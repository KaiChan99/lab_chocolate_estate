package com.bnta.chocolate.controllers;


import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( value = "/estates")
public class EstateController {

    @Autowired
    EstateRepository estateRepository;

    @GetMapping
    public ResponseEntity<List<Estate>> getAllEstates(){

        return new ResponseEntity<>(estateRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Estate> getEstateById(@PathVariable Integer id){
       return new ResponseEntity(estateRepository.findById(id), HttpStatus.OK);

    }

// PostMapping

    public ResponseEntity<Estate> createEstate(@RequestBody Estate estate1){
        Estate estate = estateRepository.save(estate1);

        return new ResponseEntity<>(estate, HttpStatus.CREATED);

    }

}
