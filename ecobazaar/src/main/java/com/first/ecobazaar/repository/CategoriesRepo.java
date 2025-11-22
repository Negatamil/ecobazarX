package com.first.ecobazaar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.first.ecobazaar.entity.CategoriesEntity;

public interface CategoriesRepo extends JpaRepository<CategoriesEntity, Long> {
}
