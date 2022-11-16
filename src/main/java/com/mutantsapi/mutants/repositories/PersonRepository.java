package com.mutantsapi.mutants.repositories;

import com.mutantsapi.mutants.models.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository <Person, String> {
    boolean existsByDna(String[] dna);

    @Cacheable("Stats")
    Long countByIsMutant(boolean isMutant);
}
