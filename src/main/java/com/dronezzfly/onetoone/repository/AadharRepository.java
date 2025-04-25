package com.dronezzfly.onetoone.repository;

import com.dronezzfly.onetoone.model.Aadhar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AadharRepository extends JpaRepository<Aadhar, Integer> {
    boolean existsByAadharNumber(Long aadharNumber);

    Optional<Aadhar> findByAadharNumber(Long aadharNumber);
}
