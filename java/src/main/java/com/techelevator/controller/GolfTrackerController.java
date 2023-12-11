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

    @GetMapping("/league-organizer/{userId}")
    public List <League> getLeaguesByCoordinatorId (@PathVariable int userId) {

        return golfTrackerDao.getLeaguesByCoordinatorId(userId);


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

    @PostMapping("/match")
    @ResponseStatus(HttpStatus.CREATED)
    public Match addMatch(@RequestBody Match newMatch) {
        return golfTrackerDao.createMatch(newMatch);
    }

    @PostMapping("/{leagueId}/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<UserInLeague> addGolferToLeague(@PathVariable int leagueId, @PathVariable int userId) {
        return golfTrackerDao.addUserToLeague(leagueId, userId);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDao.getUsers();
    }

    @GetMapping("/users/{leagueId}")
    public List<UserInLeague> getUsersInLeague(@PathVariable int leagueId) {
        return golfTrackerDao.getLeagueUsersByLeagueId(leagueId);
    }

    @GetMapping("/match/{userId}")
    public List<Match> getMatchesByUserId(@PathVariable int userId) {
        return golfTrackerDao.getMatchesByUserId(userId);
    }
}
