package rnd.mate00.springmappingtable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rnd.mate00.springmappingtable.entity.Region;

import java.util.Optional;

@Repository
public interface RegionRepository {//extends JpaRepository<Region, Integer> {

    Optional<Region> findByRegionName(String name);
}
