package com.maxdegree.controller;

import com.maxdegree.entity.Placement;
import com.maxdegree.entity.User;
import com.maxdegree.service.PlaceService;
import com.maxdegree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/places")
    public String getAllUsers(ModelMap model) {
        List<Placement> places = placeService.getAll();
        model.put("places", places);
        return "places";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/places/{id}")
    public ModelAndView getPlace(@PathVariable("id") String placeId, ModelMap model) { //�� ��� ������ � URL ����� /places/ ������� � String placeId
        model.put("place", placeService.getById(Long.parseLong(placeId)));
        return new ModelAndView("place", model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/free_places")
    public String freePlaces(ModelMap model) {
        List<Placement> places = placeService.getAll();
        List<Placement> myPlaces = new ArrayList<Placement>();
        for (Placement placement : places) {
            if (placement.getDate()== null) {
                myPlaces.add(placement);
            }
        }
        model.put("places", myPlaces);
        return "free_places";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/my_places")
    public String getMyPlaces(User user, ModelMap model, Principal principal) {
        String login = principal.getName();
        user = userService.getByLogin(login);
        List<Placement> places = placeService.getPlaceByUser(user);
        Integer size = places.size();
        model.put("places", places);
        model.put("size", size);
        return "personal_acc";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/places/buy")
    public String buyPlace(@RequestParam("placeId")String placeId, @RequestParam("multiplier")String m, Principal principal) {
        Placement place = placeService.getById(Long.parseLong(placeId));
        User user = userService.getByLogin(principal.getName());
        String date = getTime(Integer.parseInt(m));
        place.setUser(user);
        place.setDate(date);
        placeService.update(place);
        return "redirect:/success";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/places/period")
    public String chooseMyPlace(@RequestParam("placeId") String placeId, ModelMap model, @RequestParam("select")String select) {
        Placement place = placeService.getById(Long.parseLong(placeId));
        Integer multiplier = 0;
        Integer resultPrice = 0;
        if ("one month".equals(select)) {
            multiplier = 1;
        } if ("two month".equals(select)) {
            multiplier = 2;
        } if ("three month".equals(select)) {
            multiplier = 3;
        }
        resultPrice = place.getPrice() * multiplier;
        model.put("price", resultPrice);
        model.put("place", place);
        model.put("period", select);
        model.put("multiplier", multiplier);
        return "choose_place";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/success")
    public String wasBuy(){
        return "buy_place";
    }

    private String getTime(Integer mult) {
        final Long MONTH = 2592000000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long t = new Date().getTime() + (MONTH * mult);
        Date date = new Date(t);
        String time = sdf.format(date).toString();
        return time;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/place/{id}")
    public String getUser(@PathVariable("id") String placeId, ModelMap model) {
        Placement place = placeService.getById(Long.parseLong(placeId));
        model.put("place", place);
        return "user_place";
    }

}
