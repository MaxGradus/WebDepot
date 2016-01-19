package com.maxdegree.controller;

import com.maxdegree.entity.Placement;
import com.maxdegree.entity.User;
import com.maxdegree.service.PlaceService;
import com.maxdegree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PlaceService placeService;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public String getAllUsers(ModelMap model) {
        List<User> users = userService.getAll();
        model.put("users", users);
        return "users";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public String getUser(@PathVariable("id") String userId, ModelMap model) {
        User user = userService.getById(Long.parseLong(userId));
        List<Placement> placements = placeService.getPlaceByUser(user);
        Integer size = placements.size();
        model.put("user", user);
        model.put("places", placements);
        model.put("size", size);
        return "user";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/delete")
    public String deleteUser(@RequestParam("userId") String userId) {
        User user = userService.getById(Long.parseLong(userId));
        userService.delete(user);
        return "redirect:/users.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/contacts")
    public String contactsRedirect() {
        return "contacts";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/history")
    public String historyRedirect() {
        return "history";
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";

    }

//    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
//    public String welcomeIn(Model model, Principal principal) {
//        String name = principal.getName();
//        model.addAttribute("username", name);
//        model.addAttribute("roles", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
//
//        return "history";
//
//    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(Model model) {
        model.addAttribute("error", "true");
        return "login";

    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ) {
        return "redirect:/login";
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String adminPage() {
        return "admin";
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public String registrationPage() {
        return "registration";
    }

    @RequestMapping(value = "/saveNew", method = RequestMethod.POST)
    public String addNewUser(@RequestParam("userLogin") String login, @RequestParam("userPass") String password, @RequestParam("userEmail") String email) {
        User user = new User(login, password, email);
        userService.create(user);
        Long id = user.getUserId();
        userService.addNewRole(id);
        return "redirect:/login";
    }
}
