package com.example.airline_api.controllers;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerRepoitory passengerRepoitory;

    // Display details of all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerRepoitory.findAll(), HttpStatus.OK);
    }

    // Display specific passenger details
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassengerById(@PathVariable Long id){
        return new ResponseEntity<>(passengerRepoitory.findById(id), HttpStatus.OK);
    }

    // Add a new passenger
    @PostMapping
    public ResponseEntity<Passenger> addNewPassenger(@RequestBody Passenger passenger){
        passengerRepoitory.save(passenger);
        return new ResponseEntity<>(passenger, HttpStatus.CREATED);
    }

}
