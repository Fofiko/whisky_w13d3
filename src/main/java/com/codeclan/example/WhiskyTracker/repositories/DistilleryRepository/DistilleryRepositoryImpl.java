package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

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

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;


    //TODO: get all the distilleries for a particular region
    @Transactional
    public List<Distillery> getAllDistilleriesFromRegion(String region){
        List<Distillery> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.add(Restrictions.eq("region", region));
            results = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            return results;
        }
    }

    //TODO: get disilleries that have whiskies that are 12 years old
    @Transactional
    public List<Distillery> getAllDistilleriesWithWhiskiesAgedTwelve(){
        List<Distillery> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskies", "whisky");
            cr.add(Restrictions.eq("whisky.age", 12));
            results = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            return results;
        }
    }

    @Transactional
    public List<Distillery> getAllDistilleriesWithCertainAgeWhiskies(int age){
        List<Distillery> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskies", "whisky");
            cr.add(Restrictions.eq("whisky.age", age));
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
