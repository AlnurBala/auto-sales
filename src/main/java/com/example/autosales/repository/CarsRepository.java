package com.example.autosales.repository;

import com.example.autosales.entity.Cars;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarsRepository extends JpaRepository<Cars,Integer> {
    @Query(value = "select c from Cars c")
    Page<Cars> findAllPageable(Pageable pageable);

    Page<Cars> findAllByOrderByUploadDateDesc(Pageable pageable);

    @Query("SELECT c FROM Cars c ORDER BY c.price ASC")
    Page<Cars> findAllByOrderByPriceAsc(Pageable pageable);

    @Query("SELECT c FROM Cars c ORDER BY c.price DESC")
    Page<Cars> findAllByOrderByPriceDesc(Pageable pageable);

    @Query("SELECT c FROM Cars c ORDER BY CAST(REGEXP_REPLACE(c.mileage, '[^0-9]*', '', 'g') AS integer) ASC")
    Page<Cars> findAllByOrderByMileageAsc(Pageable pageable);

    Page<Cars> findAllByOrderByYearDesc(Pageable pageable);
}
