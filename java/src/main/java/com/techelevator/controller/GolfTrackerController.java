package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import com.techelevator.dao.GolfTrackerDao;

@RestController
@CrossOrigin

public class GolfTrackerController {

    private final GolfTrackerDao golfTrackerDao;
    private final UserDao userDao;

    public GolfTrackerController(UserDao userDao, GolfTrackerDao golfTrackerDao) {
        this.userDao = userDao;
        this.golfTrackerDao = golfTrackerDao;
    }


   

    @PostMapping("/league")
    @ResponseStatus(HttpStatus.CREATED)
    public League addLeague(@RequestBody League newLeague) {
        return golfTrackerDao.createLeague(newLeague);
    }


    @GetMapping("/league/{userId}")
    public List<League> getLeagueById (@PathVariable int userId) {
//        User loggedInUser = userDao.getUserByUsername(principal.getName());
//        int userId = loggedInUser.getId();

        return golfTrackerDao.getLeaguesByUserId(userId);


    }

    @GetMapping("/home/{id}/match/{id}")
    public Match getMatchById(int matchId) {

        return golfTrackerDao.getMatch(matchId);

    }

    @GetMapping("/course")
    public List<Course> getCourses() {
        return golfTrackerDao.getCourses();
    }

    @PostMapping("/course")
    @ResponseStatus(HttpStatus.CREATED)
    public Course addCourse (@RequestBody Course course){
        return golfTrackerDao.addCourse(course);
    }

    // meg added this method for getting users to add users to a league



    
}
