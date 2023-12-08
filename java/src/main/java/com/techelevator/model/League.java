package com.techelevator.model;
import java.util.List;
import java.util.Map;

public class League {

    private int leagueId;

    private String leagueName;

    private User leagueCoordinator;

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

    private List<UserInLeague> golfersInLeague;

    private List<Match> matchesInLeague;

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

    public User getLeagueCoordinator() {
        return leagueCoordinator;
    }

    public int getLeagueCoordinatorId() {
        return leagueCoordinator.getId();
    }

    public void setLeagueCoordinator(User leagueCoordinator) {
        this.leagueCoordinator = leagueCoordinator;
    }


    public List<UserInLeague> getGolfersInLeague() {
        return golfersInLeague;
    }

    public void setGolfersInLeague(List<UserInLeague> golfersInLeague) {
        this.golfersInLeague = golfersInLeague;
    }
}
