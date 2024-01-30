package com.example.Spring.Boot.repositories;

import com.example.Spring.Boot.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepositories extends JpaRepository<ProductModel , UUID> {


}
