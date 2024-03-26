package com.example.autosales.repository;

import com.example.autosales.entity.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellersRepository extends JpaRepository<Sellers,Integer> {
}
