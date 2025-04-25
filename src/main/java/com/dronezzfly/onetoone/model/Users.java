package com.dronezzfly.onetoone.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", length = 100)
    private String userName;

    @OneToOne
    @JoinColumn(name = "aadhar_id", unique = true, referencedColumnName = "aadhar_id")
    private Aadhar aadhar;
}

