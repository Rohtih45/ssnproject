package com.kafka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafka.Entity.IESform;

@Repository
public interface IESFormRepo extends JpaRepository<IESform, Integer>{
	
	public IESform findBySsn (String ssn);

}
