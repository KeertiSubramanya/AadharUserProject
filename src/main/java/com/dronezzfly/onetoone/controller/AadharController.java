package com.dronezzfly.onetoone.controller;

import com.dronezzfly.onetoone.dtos.AadharDTO;
import com.dronezzfly.onetoone.model.Aadhar;
import com.dronezzfly.onetoone.service.AadharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Aadhar")
public class AadharController {
    @Autowired
    private AadharService aadharService;

    @PostMapping("/save")
    public ResponseEntity<String> createAadhar(@RequestBody AadharDTO dto) {
        return aadharService.createAadhar(dto);
    }

    @PutMapping("/update/{aadharId}")
    public String updateAadhar(@PathVariable Integer aadharId, @RequestBody AadharDTO dto) {
        return aadharService.updateAadhar(aadharId, dto);
    }

    @GetMapping("/all")
    public List<Aadhar> getAllAadhars() {
        return aadharService.getAllAadhars();
    }

    @DeleteMapping("/delete/{aadharId}")
    public String deleteAadhar(@PathVariable Integer aadharId) {
        return aadharService.deleteAadhar(aadharId);
    }


}
