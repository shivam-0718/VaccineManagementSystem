package com.vms.vaccine.rest;

import com.vms.vaccine.model.Vaccine;
import com.vms.vaccine.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VaccineController {

    @Autowired
    public VaccineService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerVaccine(@RequestBody Vaccine vaccine) {
        String response = service.registerVaccineInfo(vaccine);
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-vaccines")
    public ResponseEntity<List<Vaccine>> getVaccines() {
        List<Vaccine> vaccines = (List<Vaccine>) service.fetchAllVaccines();
        return new ResponseEntity<>(vaccines, HttpStatus.OK);
    }

    @GetMapping("/vaccine-stock/{id}")
    public ResponseEntity<String> vaccineStock(@PathVariable Long id) {
        String stockDetails = service.checkVaccineAvailability(id);
        return new ResponseEntity<String>(stockDetails, HttpStatus.OK);
    }

    @GetMapping("/get-vaccine/{id}")
    public ResponseEntity<List<Vaccine>> getVaccineById(@PathVariable("id") Long id) {
        List<Vaccine> vac = (List<Vaccine>) service.fetchVaccineById(id);
        return new ResponseEntity<>(vac, HttpStatus.OK);
    }

    @PatchMapping("/update-vaccine/{id}/{newCost}")
    public ResponseEntity<?> updateVaccineById(@PathVariable("id") Long id, @PathVariable("newCost") Double newCost) {
        String response = service.modifyCostById(newCost, id);
        return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
    }

}
