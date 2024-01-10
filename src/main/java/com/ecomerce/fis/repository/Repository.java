package com.ecomerce.fis.repository;

import com.ecomerce.fis.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Persona, Long> {

}
