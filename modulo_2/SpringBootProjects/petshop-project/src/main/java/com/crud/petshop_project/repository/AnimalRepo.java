package com.crud.petshop_project.repository;

import com.crud.petshop_project.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepo extends JpaRepository<Animal, Long> {
}
