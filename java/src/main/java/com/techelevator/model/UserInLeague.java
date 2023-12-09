package com.techelevator.model;

import java.util.List;

public class UserInLeague {

    public UserInLeague() {
    }

    public UserInLeague(int id, String username, int matchScore) {
        this.id = id;
        this.username = username;
        this.matchScore = matchScore;
    }

    public UserInLeague(int id, String username, String firstName, String lastName, String email, int handicap, int leagueScore, int matchScore) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.handicap = handicap;
        this.leagueScore = leagueScore;
        this.matchScore = matchScore;
    }

    private int id;
    private String username;

    private String firstName;

    private String lastName;



    private int handicap;

    private int leagueScore;

    private int matchScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHandicap() {
        return handicap;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    public int getLeagueScore() {
        return leagueScore;
    }

    public void setLeagueScore(int leagueScore) {
        this.leagueScore = leagueScore;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(int matchScore) {
        this.matchScore = matchScore;
    }
}
