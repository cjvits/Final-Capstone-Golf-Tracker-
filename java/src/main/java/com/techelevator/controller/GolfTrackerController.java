package com.techelevator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

import com.techelevator.dao.GolfTrackerDao;

import com.techelevator.model.Course;
import com.techelevator.model.League;
import com.techelevator.model.Match;
import com.techelevator.model.User;

@RestController
@CrossOrigin

public class GolfTrackerController {

    private final GolfTrackerDao golfTrackerDao;

    public GolfTrackerController (GolfTrackerDao golfTrackerDao) {
        this.golfTrackerDao = golfTrackerDao;
    }
}
