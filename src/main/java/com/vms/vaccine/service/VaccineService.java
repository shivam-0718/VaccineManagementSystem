package com.vms.vaccine.service;

import com.vms.vaccine.model.Vaccine;
import com.vms.vaccine.repo.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineService implements IVaccineService{

    @Autowired
    private IVaccineRepo repo;

    @Override
    public String registerVaccineInfo(Vaccine vaccine) {
        Vaccine vac = repo.save(vaccine);
        return "Vaccine with ID " + vac.getId() + " registered successfully with name: " + vac.getVaccineName();
    }
}
