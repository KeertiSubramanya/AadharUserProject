package com.dronezzfly.onetoone.service;

import com.dronezzfly.onetoone.dtos.UserDTO;
import com.dronezzfly.onetoone.model.Aadhar;
import com.dronezzfly.onetoone.model.Users;
import com.dronezzfly.onetoone.repository.AadharRepository;
import com.dronezzfly.onetoone.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UsersRepository usersRepository;
    private AadharRepository aadharRepository;

    public UserService(UsersRepository usersRepository, AadharRepository aadharRepository) {
        this.usersRepository = usersRepository;
        this.aadharRepository = aadharRepository;
    }


    public ResponseEntity<String> createUser(UserDTO dto) {


        Optional<Aadhar> byId1 = aadharRepository.findById(dto.getAadharId());

        if (!(byId1.isPresent())) {
            return new ResponseEntity<>("addhar id not prasent", HttpStatus.BAD_REQUEST);
        }

        try {
            if (byId1.isPresent()) {
                Users users = new Users();
                users.setUserName(dto.getUserName());
                Aadhar aadhar = byId1.get();
                users.setAadhar(aadhar);

                usersRepository.save(users);
                return new ResponseEntity<>("user account saved", HttpStatus.CREATED);
            }
        } catch (RuntimeException e) {
            return new ResponseEntity<>("this aadhar already assigned to person", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("addhar id not prasent", HttpStatus.BAD_REQUEST);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
