package com.maxdegree.dao;


import com.maxdegree.entity.Placement;
import com.maxdegree.entity.User;

import java.util.List;

public interface PlaceDao {

    void create(Placement place);
    void update(Placement place);
    Placement getById(Long placeId);
    List<Placement> getAll();
    Placement getByName(String name);
    List<Placement> getPlaceByUser(User user);

}
