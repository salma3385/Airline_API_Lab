package com.example.airline_api.repositories;

import com.example.airline_api.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepoitory extends JpaRepository<Passenger, Long> {
}
