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

//    @PostMapping("/match")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Match addMatch(@RequestBody Match newMatch) {
//        return
//    }
//    you can make both of these here into ONE CALL
    @PostMapping("/match/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<UserInLeague> addGolferToMatch(@RequestBody Match match, @PathVariable int userId) {
        Match newMatch = golfTrackerDao.createMatch(match);
        return golfTrackerDao.addUserToMatch(userId, newMatch.getMatchId());
    }
    //get rid of user ids, making a match dto, having the dto contain an array of userids and 1 match obj,
    //take in DTO above, loop over array for addUserToMatch, return last one
    
    @PostMapping("/{leagueId}/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGolferToLeague(@PathVariable int leagueId, @PathVariable int userId) {
        golfTrackerDao.addUserToLeague(leagueId, userId);
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
