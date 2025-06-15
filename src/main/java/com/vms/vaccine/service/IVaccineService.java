package com.vms.vaccine.service;

import com.vms.vaccine.model.Vaccine;
import org.springframework.data.repository.query.Param;

public interface IVaccineService {
    String registerVaccineInfo(Vaccine vaccine);
    Iterable<Vaccine> registerMultipleVaccineInfo(Iterable<Vaccine> vaccines);
    Long getVaccineCount();
    String checkVaccineAvailability(Long vaccineId);
    Iterable<Vaccine> fetchAllVaccines();
    Iterable<Vaccine> fetchVaccineByIds(Iterable<Long> vaccineIds);
    Iterable<Vaccine> fetchVaccineById(Long vaccineId);
    String removeVaccineById(Long vaccineId);

    Iterable<Vaccine> getVaccinesSortedByField(boolean status, String... properties);
    void retrieveSortedVaccinePagesByField(int pageSize, boolean status, String... properties);
    void retrieveVaccinePages(int pageSize);

    void searchByCostEquals(Double cost);
    void searchByCostLessThanEqual(Double cost);
    void searchByCostBetween(Double minCost, Double maxCost);

    void searchByVaccineName(String vaccineName);
    void searchByVaccineCompany(String vaccineCompany);

    void searchByVaccineNameContaining(String name);
    void searchByVaccineCompanyContaining(String name);

    void searchByAvailableDoses(Integer minDoses, Integer maxDoses);

    void modifyCostByVaccineName(Double newCost, String vaccineName);
    void modifyCostById(Double newCost, Long id);

    void deleteVaccineByName(String vaccineName);

}
