package com.madeanhive.repository;

import com.madeanhive.model.HomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeCategoryRepository extends JpaRepository<HomeCategory,Long> {
}
