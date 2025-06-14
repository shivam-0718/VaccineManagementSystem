package com.vms.vaccine.service;

import com.vms.vaccine.model.Vaccine;
import com.vms.vaccine.repo.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Iterable<Vaccine> fetchVaccineByIds(Iterable<Long> vaccineIds) {
        return repo.findAllById(vaccineIds);
    }

    @Override
    public Iterable<Vaccine> fetchVaccineById(Long vaccineId) {
        Optional<Vaccine> optional = repo.findById(vaccineId);
        if(optional.isPresent()) {
            System.out.println("Vaccine with ID " + vaccineId + " found.");
            Vaccine vac = optional.get();
            return List.of(vac);
        } else {
            System.out.println("Vaccine with ID " + vaccineId + " not found.");
            return List.of();
        }
    }

    @Override
    public String removeVaccineById(Long vaccineId) {
        Optional<Vaccine> optional = repo.findById(vaccineId);
        if(optional.isPresent()) {
            repo.deleteById(vaccineId);
            return "Vaccine with ID " + vaccineId + " has been removed .";
        } else {
            return "There is no vaccine with ID " + vaccineId + " to remove .";
        }
    }

    @Override
    public Iterable<Vaccine> getVaccinesSortedByField(boolean status, String... properties) {
        Sort sort = Sort.by(status ? Sort.Direction.ASC : Sort.Direction.DESC, properties);
        return repo.findAll(sort);
    }

    @Override
    public void retrieveSortedVaccinePages(int pageSize, boolean status, String... properties) {
        // Retrieve vaccines in a paginated manner based on the provided page number, size, and sort order
        Sort sort = Sort.by(status ? Sort.Direction.ASC : Sort.Direction.DESC, properties); // Create sort object based on status and properties

        long count = getVaccineCount();
        long pageCount = count / pageSize;
        pageCount = count % pageSize == 0 ? pageCount : ++pageCount; //fetching total number of pages based on page size and count

        // Loop through each page and fetch the vaccines in sorted order in pages dynamically
        for (int i = 0; i < pageCount; i++) {
            PageRequest pageable = PageRequest.of(i, pageSize, sort); // Create pageable object with page number, size, and sort order
            Page<Vaccine> page = repo.findAll(pageable); // Fetch the page of vaccines
            List<Vaccine> vaccinePage = page.getContent(); // Return the content of the page as an Iterable<Vaccine>
            vaccinePage.forEach(v -> System.out.println(v));
            System.out.println("--------------------------------- Page " + (i + 1) + " ---------------------------------");
        }

    }

    @Override
    public void retrieveVaccinePages(int pageSize) {
        //dynamically I want number of pages to be fetched based on page size
        Long count = getVaccineCount(); // Get the total count of vaccines

        Long pageCount = count / pageSize;
        pageCount = count % pageSize == 0 ? pageCount : ++pageCount; //fetching total number of pages based on page size and count
        for(int i = 0; i < pageCount; i++) {
            PageRequest pageable = PageRequest.of(i, pageSize); // Create pageable object with current page and size
            Page<Vaccine> page = repo.findAll(pageable); // Fetch the page of vaccines
            List<Vaccine> vaccinePage = page.getContent(); // Get the content of the page
            vaccinePage.forEach(v -> System.out.println(v));
            System.out.println("--------------------------------- Page " + (i + 1) + " ---------------------------------");
        }
    }
}
