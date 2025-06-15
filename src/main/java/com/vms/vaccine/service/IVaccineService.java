package com.vms.vaccine.service;

import com.vms.vaccine.model.Vaccine;

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

    void findByVaccineName(String vaccineName);
    void findByVaccineCompany(String vaccineCompany);

    void findByVaccineNameContaining(String name);
    void findByVaccineCompanyContaining(String name);

}
