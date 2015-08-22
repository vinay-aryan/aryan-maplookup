package com.maplookup.db.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maplookup.db.dao.ZipcodesDao;
import com.maplookup.db.domain.Zipcodes;

@Repository("zipCodesDao")
public class ZipcodesDaoImpl implements ZipcodesDao{

    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public void persistZipcodes( Zipcodes zipcode ){
        sessionFactory.getCurrentSession().persist(zipcode);
    }

    @Transactional
    public List findByQuery(String queryString){
        Query query = sessionFactory.getCurrentSession().createQuery(queryString.toString());
        return query.list(); 
    }
    
    @Transactional
    public Zipcodes findZipcodesById( String id ){
        Zipcodes zipCodes = (Zipcodes) sessionFactory.getCurrentSession().get(Zipcodes.class, id);
        return zipCodes;
    }

}