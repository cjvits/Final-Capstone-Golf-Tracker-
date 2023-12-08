package com.techelevator.model;
import java.util.List;
import java.util.Map;

public class League {

    private int leagueId;

    private String leagueName;

    private User leagueCoordinator;

    private Course leagueCourse;

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

    public Course getLeagueCourse() {
        return leagueCourse;
    }

    public int getLeagueCourseId() {
        return leagueCourse.getCourseId();
    }

    public void setLeagueCourse(Course leagueCourse) {
        this.leagueCourse = leagueCourse;
    }

    public List<UserInLeague> getGolfersInLeague() {
        return golfersInLeague;
    }

    public void setGolfersInLeague(List<UserInLeague> golfersInLeague) {
        this.golfersInLeague = golfersInLeague;
    }
}
