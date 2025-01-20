package com.kafka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafka.Entity.CitizenSSnEntity;

@Repository
public interface CitizenSSnRepo extends JpaRepository<CitizenSSnEntity, Integer>{
	
	public CitizenSSnEntity findBySsn(String Ssn);

}
