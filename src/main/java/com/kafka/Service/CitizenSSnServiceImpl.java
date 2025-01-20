package com.kafka.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.Entity.CitizenSSnEntity;
import com.kafka.Entity.IESform;
import com.kafka.repo.CitizenSSnRepo;
import com.kafka.repo.IESFormRepo;

@Service
public class CitizenSSnServiceImpl implements CitizenSSnService {

	@Autowired
	private CitizenSSnRepo repo;

	@Autowired
	private IESFormRepo formrepo;

	public CitizenSSnEntity getBySsnbybody(IESform form) {
		// TODO Auto-generated method stub

		formrepo.save(form);

		if (form.getSsn().length() == 12) {
			CitizenSSnEntity entity = repo.findBySsn(form.getSsn());
			System.out.println(form.getSsn());
			System.out.println(repo.findAll());
			return entity;

		}

		IESform bySsn = formrepo.findBySsn(form.getSsn());

		CitizenSSnEntity entity2 = new CitizenSSnEntity();

		BeanUtils.copyProperties(bySsn, entity2);

		return entity2;
	}

	public CitizenSSnEntity getBySsn(String ssn) {

		//formrepo.save(form);

		if (ssn.length() == 12) {
			CitizenSSnEntity entity = repo.findBySsn(ssn);
			
			return entity;

		}

		IESform bySsn = formrepo.findBySsn(ssn);

		CitizenSSnEntity entity2 = new CitizenSSnEntity();

		BeanUtils.copyProperties(bySsn, entity2);

		return entity2;

	}

	@Override
	public Boolean CreateIESForm(IESform form) {
		// TODO Auto-generated method stub
		formrepo.save(form);

		return true;
	}

	public Boolean CreateCitizen(IESform form) {
		// TODO Auto-generated method stub
		CitizenSSnEntity entity = new CitizenSSnEntity();
		entity.setFullname(form.getFullname());
		entity.setGender(form.getGender());
		entity.setDob(form.getDob());
		entity.setSsn(form.getSsn());
		entity.setCity(form.getCity());
		entity.setState(form.getState());
		entity.setHousenumber(form.getHousenumber());

		repo.save(entity);

		return true;
	}

}
