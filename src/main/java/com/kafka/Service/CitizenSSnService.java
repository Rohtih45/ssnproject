package com.kafka.Service;


import com.kafka.Entity.CitizenSSnEntity;
import com.kafka.Entity.IESform;

public interface CitizenSSnService {
	
	public CitizenSSnEntity getBySsnbybody(IESform form);
	
	public CitizenSSnEntity getBySsn(String ssn);
	
	public Boolean CreateIESForm(IESform form);
	
	public Boolean CreateCitizen(IESform form);

}
