package com.vms.vaccine.repo;

import com.vms.vaccine.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByCostEquals(Double cost);
    List<Vaccine> findByCostLessThanEquals(Double cost);
    List<Vaccine> findByCostBetween(Double minCost, Double maxCost);

    List<Vaccine> findByVaccineNameEquals(String vaccineName);
    List<Vaccine> findByVaccineCompanyEquals(String vaccineCompany);
}
