package com.coforge.project.obs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coforge.project.obs.model.Passbook;


public interface PassbookRepository extends JpaRepository<Passbook,Long> {

}
