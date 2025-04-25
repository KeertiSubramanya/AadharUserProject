package com.dronezzfly.onetoone.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "aadhar")
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "aadharId")
public class Aadhar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aadhar_id")
    private Integer aadharId;

    @Column(name = "aadhar_number", unique = true, nullable = false, precision = 10, scale = 0)
    private Long aadharNumber;


    // Optional: mappedBy for bi-directional
    @OneToOne(mappedBy = "aadhar")
    //@ToString.Exclude

    private Users user;
}


