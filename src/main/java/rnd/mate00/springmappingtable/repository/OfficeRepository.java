package rnd.mate00.springmappingtable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rnd.mate00.springmappingtable.entity.Office;

import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {

    Optional<Office> findByOfficeName(String name);
}
