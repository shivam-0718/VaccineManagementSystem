package com.vms.vaccine.service;

import com.vms.vaccine.model.Vaccine;
import com.vms.vaccine.repo.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class VaccineService implements IVaccineService{

    @Autowired
    private IVaccineRepo repo;

    @Override
    public String registerVaccineInfo(Vaccine vaccine) {
        Vaccine vac = repo.save(vaccine);
        return "Vaccine with ID " + vac.getId() + " registered successfully with name: " + vac.getVaccineName();
    }

    @Override
    public Iterable<Vaccine> registerMultipleVaccineInfo(Iterable<Vaccine> vaccines) {
        return repo.saveAll(vaccines);
    }

    @Override
    public Long getVaccineCount() {
        return repo.count();
    }

    @Override
    public String checkVaccineAvailability(Long vaccineId) {
        Optional<Vaccine> optional = repo.findById(vaccineId);
        if(optional.isPresent()) {
            Vaccine vac = optional.get();
            Integer doses = vac.getAvailableDoses();
            if(doses > 0) {
                return "Vaccine with ID " + vaccineId + " is available with " + doses + " doses.";
            } else {
                return "Vaccine with ID " + vaccineId + " is currently out of stock.";
            }
        } else {
            return "Vaccine with ID " + vaccineId + " does not exist.";
        }
    }

    @Override
    public Iterable<Vaccine> fetchAllVaccines() {
        return repo.findAll();
    }

    @Override
    public Iterable<Vaccine> fetchVaccineByIds(Iterable<Long> ids) {
        return repo.findAllById(ids);
    }


}
