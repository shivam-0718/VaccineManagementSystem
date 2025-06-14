package com.vms.vaccine.repo;

import com.vms.vaccine.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Long> {

}
