package edu.co.icesi.introspringboot.repository;

import edu.co.icesi.introspringboot.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

    List<Country> findTop15DistinctByOrderByPlayers_FifaScoreDesc();
}
