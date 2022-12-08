package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepoitory passengerRepoitory;

    public DataLoader() {

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Flight A1Flight = new Flight("Spain", 500, "09/12/2022", "00:00");
        flightRepository.save(A1Flight);
        Passenger passenger1 = new Passenger("Salma", "salma_2019@gmail.com");
        passengerRepoitory.save(passenger1);

        Passenger passenger2 = new Passenger("Lucy", "Lucy_2018@gamil.com");
        passenger2.addFlight(A1Flight);
        passengerRepoitory.save(passenger2);


        Flight A2Flight = new Flight("France", 400, "10/12/2022", "10:00");
        flightRepository.save(A1Flight);
        Passenger passenger3 = new Passenger("Sam", "sam_2019@gmail.com");
        passengerRepoitory.save(passenger3);

        Passenger passenger4 = new Passenger("Lilly", "Lilly_2018@gamil.com");
        passenger4.addFlight(A2Flight);
        passengerRepoitory.save(passenger4);
    }
}
