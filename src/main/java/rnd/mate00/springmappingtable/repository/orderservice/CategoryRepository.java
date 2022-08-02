package rnd.mate00.springmappingtable.repository.orderservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rnd.mate00.springmappingtable.entity.orderservice.Category;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
