package com.vms.vaccine.repo;

import com.vms.vaccine.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByCostEquals(Double cost);
    List<Vaccine> findByCostLessThanEqual(Double cost);
    List<Vaccine> findByCostBetween(Double minCost, Double maxCost);

    List<Vaccine> findByVaccineNameIgnoreCase(String vaccineName);
    List<Vaccine> findByVaccineCompanyIgnoreCase(String vaccineCompany);

    @Query("SELECT v FROM Vaccine v WHERE v.vaccineName LIKE (LOWER(CONCAT('%', :name, '%')))")
    List<Vaccine> findByVaccineNameContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT v FROM Vaccine v WHERE v.vaccineCompany LIKE (LOWER(CONCAT('%', :name, '%')))")
    List<Vaccine> findByVaccineCompanyContainingIgnoreCase(@Param("name") String name);


}
