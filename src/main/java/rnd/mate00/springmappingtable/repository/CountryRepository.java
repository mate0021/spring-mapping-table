package rnd.mate00.springmappingtable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rnd.mate00.springmappingtable.entity.Country;

import java.util.Optional;

@Repository
public interface CountryRepository {//extends JpaRepository<Country, Integer> {

    Optional<Country> findByCountryName(String name);
}
