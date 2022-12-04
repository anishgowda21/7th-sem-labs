package com.mslab.theater_service.repository;

import com.mslab.theater_service.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater,String> {
}
