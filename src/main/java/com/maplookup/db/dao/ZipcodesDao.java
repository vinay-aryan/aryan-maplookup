package com.maplookup.db.dao;

import java.util.List;

import com.maplookup.db.domain.Zipcodes;

public interface ZipcodesDao {

	    void persistZipcodes( Zipcodes zipcode );

	    Zipcodes findZipcodesById( String id );

	    public List findByQuery(String queryString);
}
