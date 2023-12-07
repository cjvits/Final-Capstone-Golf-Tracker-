package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

import com.techelevator.dao.GolfTrackerDao;

import com.techelevator.model.Course;
import com.techelevator.model.League;
import com.techelevator.model.Match;
import com.techelevator.model.User;
import com.techelevator.model.UserInLeague;

@RestController
@CrossOrigin

public class GolfTrackerController {

    private final GolfTrackerDao golfTrackerDao;
    private final UserDao userDao;

    public GolfTrackerController (UserDao userDao, GolfTrackerDao golfTrackerDao) {
        this.userDao = userDao;
        this.golfTrackerDao = golfTrackerDao;
    }


    @GetMapping("/league")
    public List<League> getLeagues (Principal principal) {
        User loggedInUser = userDao.getUserByUsername(principal.getName());
        int userId = loggedInUser.getId();
        return golfTrackerDao.getLeaguesOfUser(userId);

    }

    @PostMapping("/home")
    @ResponseStatus(HttpStatus.CREATED)
    public League addLeague (@RequestBody League newLeague){
        return golfTrackerDao.createLeague(newLeague);
    }


    @GetMapping("/home/{id}")
    public List<UserInLeague> getLeagueById (int userId) {
//        User loggedInUser = userDao.getUserByUsername(principal.getName());
//        int userId = loggedInUser.getId();

        return golfTrackerDao.getLeagueByUserId(userId);


    }

    @GetMapping("/home/{id}/match/{id}")
    public Match getMatchById (int matchId) {

        return golfTrackerDao.getMatch(matchId);

    }

    @GetMapping("/home/{id}/match")
    public Match
}
