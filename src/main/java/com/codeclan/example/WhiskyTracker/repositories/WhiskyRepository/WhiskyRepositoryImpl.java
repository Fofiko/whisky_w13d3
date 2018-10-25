package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {


    @Autowired
    EntityManager entityManager;

    //TODO: get all the whiskies for a particular year
    @Transactional
    public List<Whisky> getAllWhiskiesFromYear(int year){
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));
            results = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            return results;
        }
    }

    //TODO: get all the whisky from a particular region
//    @Transactional
//    public List<Whisky> IncorrectgetAllWhiskiesFromRegion(String region){
//        List<Whisky> results = null;
//
//        Session session = entityManager.unwrap(Session.class);
//
//        try {
//            Criteria cr = session.createCriteria(Distillery.class);
//            cr.createAlias("whiskies", "whisky");
//            cr.add(Restrictions.eq("region", region));
//            results = cr.list();
//        }
//        catch (HibernateException ex){
//            ex.printStackTrace();
//        }
//        finally {
//            return results;
//        }
//    }

    @Transactional
    public List<Whisky> getAllWhiskiesFromRegion(String region){
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distilleries", "distillery");
            results = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            return results;
        }
    }




    //TODO: get all the whisky from a particular distillery that's a specific age (if any)
    @Transactional
    public List<Whisky> getAllWhiskiesFromDistilleryOfAge(Long distilleryId, int age) {

        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("distillery.id", distilleryId));
            if (age > 0) {cr.add(Restrictions.eq("age", age));}
            results = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            return results;
        }
    }

}
