package com.maxdegree.service;

import com.maxdegree.dao.PlaceDao;
import com.maxdegree.dao.UserDao;
import com.maxdegree.entity.Placement;
import com.maxdegree.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PlaceService {
    @Autowired
    private PlaceDao placeDao;

    @Transactional
    public void create(Placement place) {
        placeDao.create(place);
    }


    @Transactional
    public void update(Placement place) {
        placeDao.update(place);
    }

    @Transactional
    public List<Placement> getAll() {
        return placeDao.getAll();
    }

    @Transactional
    public Placement getById(Long placeId) {
        return placeDao.getById(placeId);
    }

    @Transactional
    public Placement getByName(String name) {
        return placeDao.getByName(name);
    }

    @Transactional
    public List<Placement> getPlaceByUser(User user) {
        return placeDao.getPlaceByUser(user);
    }
}
