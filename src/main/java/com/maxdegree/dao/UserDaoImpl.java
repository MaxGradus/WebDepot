package com.maxdegree.dao;


import com.maxdegree.entity.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public User getById(Long userId) {
        return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }

    public List<User> getAll() {
        //noinspection JpaQlInspection
        return sessionFactory.getCurrentSession().createQuery("FROM User order by login").list();
    }

    public User getByLogin(String login) {
        //noinspection JpaQlInspection
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.login = ?");
        query.setString(0, login);
        return (User) query.list().get(0);
    }

    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public void addNewRole(Long id) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO user_roles(userId, AUTHORITY)  VALUES (:myId,'ROLE_USER')" );
//        query.setLong(1, id);
//        query.setString(2, "ROLE_USER");
        query.setParameter("myId", id);
        query.executeUpdate();
    }

}
