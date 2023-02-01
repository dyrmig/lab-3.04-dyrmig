package com.dyrmig.lab304.repository;

import com.dyrmig.lab304.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
    List<Aircraft> findByModelLike(String model);

}