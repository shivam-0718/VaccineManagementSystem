package com.vms.vaccine.repo;

import com.vms.vaccine.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByCostEquals(Double cost);
    List<Vaccine> findByCostLessThanEqual(Double cost);
    List<Vaccine> findByCostBetween(Double minCost, Double maxCost);

    //Removing line 17 and 18 during v2
    List<Vaccine> findByVaccineNameIgnoreCase(String vaccineName);
    List<Vaccine> findByVaccineCompanyIgnoreCase(String vaccineCompany);

    @Query("SELECT v FROM Vaccine v WHERE v.vaccineName LIKE (LOWER(CONCAT('%', :name, '%')))")
    List<Vaccine> findByVaccineNameContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT v FROM Vaccine v WHERE v.vaccineCompany LIKE (LOWER(CONCAT('%', :name, '%')))")
    List<Vaccine> findByVaccineCompanyContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT v FROM Vaccine v WHERE v.availableDoses BETWEEN :minDoses AND :maxDoses")
    List<Vaccine> findByAvailableDoses(@Param("minDoses") Integer minDoses, @Param("maxDoses") Integer maxDoses);

    @Transactional
    @Modifying
    @Query("UPDATE Vaccine v SET v.cost = :newCost WHERE v.vaccineName = :vaccineName")
    int updateCostByVaccineName(@Param("newCost") Double newCost, @Param("vaccineName") String vaccineName);

    @Transactional
    @Modifying
    @Query("UPDATE Vaccine v SET v.cost = :newCost WHERE v.id = :id")
    int updateCostById(@Param("newCost") Double newCost, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Vaccine v WHERE v.vaccineName = :vaccineName")
    int deleteByVaccineName(@Param("vaccineName") String vaccineName);
}
