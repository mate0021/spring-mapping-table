package rnd.mate00.springmappingtable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rnd.mate00.springmappingtable.entity.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByProductName(String name);
}
