package com.maploopup.service;

import java.util.List;

import com.maplookup.db.domain.Zipcodes;

public interface ZipcodesService {

	public void persistZipCodes(Zipcodes zipcodes);
    public Zipcodes findZipCodesById(String id);
    public List findZipCodesByCity(String city);
    public Zipcodes findZipCodesByStateAndCity(String state,String city );
    public Zipcodes findZipCodesByState(String state);
    public List searchStatesByCity( String city );
    public List searchZipsByCity( String city );
    public List searchCitiesBystate( String state );
    public List searchTextInField(String field, String text);
    public List<String> searchZipsByCityAndstate( String state,String city );
}
