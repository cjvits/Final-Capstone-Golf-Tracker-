package com.techelevator.model;

import java.util.List;

public class UserInLeague {

    private int id;
    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private int handicap;

    private int leagueScore;

    private List<Integer> matchScores;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Integer> getMatchScores() {
        return matchScores;
    }

    public void setMatchScores(List<Integer> matchScores) {
        this.matchScores = matchScores;
    }
}
