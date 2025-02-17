package com.springboot.www;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {

    @Query("SELECT t FROM TrainingCenter t WHERE t.address.city = :city")
    List<TrainingCenter> findByCity(@Param("city") String city);

    @Query("SELECT t FROM TrainingCenter t WHERE t.address.state = :state")
    List<TrainingCenter> findByState(@Param("state") String state);
}
