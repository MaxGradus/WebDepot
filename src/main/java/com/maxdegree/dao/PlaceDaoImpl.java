package com.maxdegree.dao;


import com.maxdegree.entity.Placement;
import com.maxdegree.entity.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlaceDaoImpl implements PlaceDao {

    @Autowired
    SessionFactory sessionFactory;

    public void create(Placement place) {
        sessionFactory.getCurrentSession().save(place);
    }

    public void update(Placement place) {
        sessionFactory.getCurrentSession().saveOrUpdate(place);
    }

    public Placement getById(Long placeId) {
        return (Placement) sessionFactory.getCurrentSession().get(Placement.class, placeId);
    }

    public List<Placement> getAll() {
        //noinspection JpaQlInspection
        return sessionFactory.getCurrentSession().createQuery("FROM Placement order by placeName").list();
    }

    public Placement getByName(String name) {
        //noinspection JpaQlInspection
        Query query = sessionFactory.getCurrentSession().createQuery("from Placement p where p.name = ?");
        query.setString(0, name);
        return (Placement) query.list().get(0);
    }

    public List<Placement> getPlaceByUser(User user) {

        Long userId = user.getUserId();
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select * from placements where userId=:reg");
        query.addEntity(Placement.class);
        query.setParameter("reg", userId);
        List<Placement> places = (List<Placement>)query.list();
        return places;
    }
}
