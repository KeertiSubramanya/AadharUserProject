package com.dronezzfly.onetoone.repository;
import com.dronezzfly.onetoone.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
