package com.coderscampus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coderscampus.api.domain.FarmDetails;
import com.coderscampus.api.domain.User;

public interface FarmDetailsRepository extends JpaRepository <FarmDetails, Long> {
	
	FarmDetails findByUser(User user);
	
	@Query(value="select * from farm_details where farm_name = :farmName", nativeQuery=true)
	FarmDetails findFarmDetailsByFarmName(@Param("farmName") String farmName);

}
