package com.vms.vaccine.rest;

import com.vms.vaccine.model.Vaccine;
import com.vms.vaccine.service.VaccineService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "POST Operation", description = "This method is used to register a new vaccine and return the response with the created status.")
    public ResponseEntity<String> registerVaccine(@RequestBody Vaccine vaccine) {
        String response = service.registerVaccineInfo(vaccine);
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-vaccines")
    @Operation(summary = "GET Operation", description = "This method is used to fetch all vaccines and return them to the user in a list.")
    public ResponseEntity<List<Vaccine>> getVaccines() {
        List<Vaccine> vaccines = (List<Vaccine>) service.fetchAllVaccines();
        return new ResponseEntity<>(vaccines, HttpStatus.OK);
    }

    @GetMapping("/vaccine-stock/{id}")
    @Operation(summary = "GET Operation", description = "This method is used to check the availability of a vaccine by its ID as input and return the stock details.")
    public ResponseEntity<String> vaccineStock(@PathVariable Long id) {
        String stockDetails = service.checkVaccineAvailability(id);
        return new ResponseEntity<String>(stockDetails, HttpStatus.OK);
    }

    @GetMapping("/get-vaccine/{id}")
    @Operation(summary = "GET Operation", description = "This method is used to fetch a vaccine by its ID and return about it in a detailed form.")
    public ResponseEntity<List<Vaccine>> getVaccineById(@PathVariable("id") Long id) {
        List<Vaccine> vac = (List<Vaccine>) service.fetchVaccineById(id);
        return new ResponseEntity<>(vac, HttpStatus.OK);
    }

    @PatchMapping("/update-vaccine/{id}/{newCost}")
    @Operation(summary = "PATCH Operation", description = "This method is used to update the cost of a vaccine by its ID and return the response with the accepted status.")
    public ResponseEntity<?> updateVaccineById(@PathVariable("id") Long id, @PathVariable("newCost") Double newCost) {
        String response = service.modifyCostById(newCost, id);
        return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
    }

}
