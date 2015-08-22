package com.maplookup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maplookup.db.dao.ZipcodesDao;
import com.maplookup.db.domain.Zipcodes;
import com.maploopup.service.ZipcodesService;

@Service("zipcodesService")
public class ZipcodesServiceImp implements ZipcodesService {

	@Autowired
	ZipcodesDao zipcodesDao;

	public void persistZipCodes(Zipcodes zipcodes) {
		zipcodesDao.persistZipcodes(zipcodes);
	}

	public Zipcodes findZipCodesById(String id) {
		return zipcodesDao.findZipcodesById(id);
	}

	public List searchStatesByCity(String city) {
		StringBuilder queryString = new StringBuilder(
				"SELECT distinct t.state FROM Zipcodes t");
		queryString.append(" WHERE city ='");
		queryString.append(city);
		queryString.append("'");
		return zipcodesDao.findByQuery(queryString.toString());
	}

	public List searchCitiesBystate(String state) {
		StringBuilder queryString = new StringBuilder(
				"SELECT distinct t.city FROM Zipcodes t");
		queryString.append(" WHERE state ='");
		queryString.append(state);
		queryString.append("'");
		return zipcodesDao.findByQuery(queryString.toString());
	}

	public List searchZipsByCity(String city) {
		StringBuilder queryString = new StringBuilder(
				"SELECT distinct t.zip FROM Zipcodes t");
		queryString.append(" WHERE city ='");
		queryString.append(city);
		queryString.append("'");
		return zipcodesDao.findByQuery(queryString.toString());
	}

	public List searchTextInField(String field, String text) {
		StringBuilder queryString = new StringBuilder("SELECT distinct t."
				+ field + " FROM Zipcodes t");
		queryString.append(" WHERE " + field + " like ('%" + text + "%')");
		return zipcodesDao.findByQuery(queryString.toString());
	}

	public List findZipCodesByCity(String city) {
		List stateList = searchStatesByCity(city);
		return stateList;
	}

	public Zipcodes findZipCodesByStateAndCity(String state, String city) {

		StringBuilder queryString = new StringBuilder(
				"SELECT t FROM Zipcodes t");
		queryString.append(" WHERE city ='");
		queryString.append(city);
		queryString.append("'");
		queryString.append(" and state ='");
		queryString.append(state);
		queryString.append("'");

		return (Zipcodes) zipcodesDao.findByQuery(queryString.toString())
				.get(0);

	}

	public Zipcodes findZipCodesByState(String state) {
		StringBuilder queryString = new StringBuilder(
				"SELECT t FROM Zipcodes t");
		queryString.append(" WHERE state ='");
		queryString.append(state);
		queryString.append("'");
		List zipcodesList = zipcodesDao.findByQuery(queryString.toString());
		if (zipcodesList.size() > 0)
			return (Zipcodes) zipcodesList.get(0);
		return null;
	}

	public List<String> searchZipsByCityAndstate(String state, String city) {
		StringBuilder queryString = new StringBuilder(
				"SELECT distinct t.zip FROM Zipcodes t");
		queryString.append(" WHERE city ='");
		queryString.append(city);
		queryString.append("'");
		queryString.append(" and state ='");
		queryString.append(state);
		queryString.append("'");
		return zipcodesDao.findByQuery(queryString.toString());
	}

}
