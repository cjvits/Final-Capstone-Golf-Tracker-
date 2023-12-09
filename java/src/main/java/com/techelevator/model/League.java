package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class League {

    private int leagueId;

    private String leagueName;

    private int leagueCoordinatorId;

    private String leagueCourseName;

    private int leagueCourseId;

    public int getLeagueCourseId() {
        return leagueCourseId;
    }

    public void setLeagueCourseId(int leagueCourseId) {
        this.leagueCourseId = leagueCourseId;
    }

    public String getLeagueCourseName() {
        return leagueCourseName;
    }

    public void setLeagueCourseName(String leagueCourseName) {
        this.leagueCourseName = leagueCourseName;
    }

    private List<UserInLeague> golfersInLeague = new ArrayList<>();

    private List<Match> matchesInLeague = new ArrayList<>();

    public List<Match> getMatchesInLeague() {
        return matchesInLeague;
    }

    public void setMatchesInLeague(List<Match> matchesInLeague) {
        this.matchesInLeague = matchesInLeague;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getLeagueCoordinatorId() {
        return leagueCoordinatorId;
    }

//    public Integer getLeagueCoordinatorId() {
//        if (leagueCoordinatorId == null) {
//            return null;
//        }
//
//        return leagueCoordinatorId.getId();
//    }

    public void setLeagueCoordinatorId(int leagueCoordinatorId) {
        this.leagueCoordinatorId = leagueCoordinatorId;
    }



    public List<UserInLeague> getGolfersInLeague() {
        return golfersInLeague;
    }

    public void setGolfersInLeague(List<UserInLeague> golfersInLeague) {
        this.golfersInLeague = golfersInLeague;
    }
}
