package com.dronezzfly.onetoone.model;

import jakarta.persistence.Entity;
// default package
// Generated 21-Apr-2025, 7:11:39 am by Hibernate Tools 6.2.24.Final


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "aadhar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aadhar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aadhar_id")
    private Integer aadharId;

    @Column(name = "aadhar_number", unique = true, nullable = false, precision = 10, scale = 0)
    private Long aadharNumber;


    // Optional: mappedBy for bi-directional
    @OneToOne(mappedBy = "aadhar")
    private Users user;
}


