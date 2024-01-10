package com.ecomerce.fis.repository;

import com.ecomerce.fis.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoProduct extends JpaRepository<Producto,Long> {
}
