package com.swisscom.assignment.repository;

import com.swisscom.assignment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    @Query(value = "insert into Product p (p.type, p.name, p.description) values (:type, :name, :description)",
            nativeQuery = true)
    void insertProduct(@Param("type") String productType,
                       @Param("name") String name,
                       @Param("description") String description);

    void deleteById(Long id);

    Optional<Product> findById(Long id);

    @Modifying
    @Query("UPDATE Product p set p.availability = :availability WHERE p.id = :id")
    void updateStock(@Param("availability") int availability,
                     @Param("id") Long id);
}
