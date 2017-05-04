package com.joni.dao;

import com.joni.model.HibernateUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shenjj on 2017/5/2.
 */
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(HibernateUser user) {
        getSession().save(user);
        return;
    }

    public void delete(HibernateUser user) {
        getSession().delete(user);
        return;
    }

    @SuppressWarnings("unchecked")
    public List<HibernateUser> getAll() {
        return getSession().createQuery("from User").list();
    }

    public HibernateUser getById(long id) {
        return (HibernateUser) getSession().load(HibernateUser.class, id);
    }

    public void update(HibernateUser user) {
        getSession().update(user);
        return;
    }

}
