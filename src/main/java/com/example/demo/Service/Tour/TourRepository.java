package com.example.demo.Service.Tour;

import com.example.demo.Entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour,Long> {

    @Query(value = "SELECT * FROM Tour t WHERE t.censor = false", nativeQuery = true)
    List<Tour> getToursPending();

    @Query(value = "SELECT * FROM Tour t WHERE t.censor = true AND t.publish = true", nativeQuery = true)
    List<Tour> getToursActive();

}
