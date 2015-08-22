package com.maplookup.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "zipcodes")
public class Zipcodes {

    @Id
    @Column(name = "zip", nullable = false)
    String zip;
    @Column(name = "city", nullable = false)
    String city;
    @Column(name = "state", nullable = false)
    String state;
    @Column(name = "latitude", nullable = false)
    double latitude;
    @Column(name = "longitude", nullable = false)
    double longitude;
    @Column(name = "timezone", nullable = false)
    String timezone;
    @Column(name = "dst", nullable = false)
    Boolean dst;
    
    
    public String getCity(){
        return city;
    }
    public void setCity( String city ){
        this.city = city;
    }
    public String getState(){
        return state;
    }
    public void setState( String state ){
        this.state = state;
    }
    
    public String getTimezone(){
        return timezone;
    }
    public void setTimezone( String timezone ){
        this.timezone = timezone;
    }
    public Boolean getDst(){
        return dst;
    }
    public void setDst( Boolean dst ){
        this.dst = dst;
    }
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setZip(String zip) {
		this.zip = zip;
	} 
}
