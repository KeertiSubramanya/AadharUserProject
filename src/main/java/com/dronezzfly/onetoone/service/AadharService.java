package com.dronezzfly.onetoone.service;

import com.dronezzfly.onetoone.dtos.AadharDTO;
import com.dronezzfly.onetoone.model.Aadhar;
import com.dronezzfly.onetoone.repository.AadharRepository;
import com.dronezzfly.onetoone.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AadharService {
    @Autowired
    private AadharRepository aadharRepository;
    @Autowired
    private UsersRepository usersRepository;

    public ResponseEntity<String> createAadhar(AadharDTO dto) {
              Optional<Aadhar> aadharOptinal=aadharRepository.findByAadharNumber(dto.getAadharNumber());
              if(aadharOptinal.isPresent()){
                  return new ResponseEntity<>("Aadhar already exits",HttpStatus.OK);

              }
              else{
                  Aadhar aadhar=new Aadhar();
                  aadhar.setAadharNumber(dto.getAadharNumber());
                  aadharRepository.save(aadhar);
                  return new ResponseEntity<>("Aadhar savad", HttpStatus.CREATED);
              }

    }

    public String updateAadhar(Integer aadharId, AadharDTO dto) {

        try{
            Optional<Aadhar> aadharIdOptinal=aadharRepository.findById(aadharId);
            if(aadharIdOptinal.isPresent()){
                Aadhar       aadhar=aadharIdOptinal.get();
                aadhar.setAadharNumber(dto.getAadharNumber());
                aadharRepository.save(aadhar);
                return "adhar upodated";
            }
        }
        catch (RuntimeException e){
            throw new RuntimeException(e);

        }


        return "aadhar id is not available";
    }

    public List<Aadhar> getAllAadhars() {

             List<Aadhar>   allrecords=aadharRepository.findAll();
             return allrecords;
    }

    public String deleteAadhar(Integer aadharId) {
        Optional<Aadhar> aadharIdOptinal=aadharRepository.findById(aadharId);
        if(aadharIdOptinal.isPresent()){
            aadharRepository.deleteById(aadharId);
            return "aadhar deleted";
        }
        return "aadhar is not available";
    }
}
