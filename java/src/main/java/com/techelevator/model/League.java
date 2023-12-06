package com.techelevator.model;
import java.util.List;
import java.util.Map;

public class League {

    private int leagueId;

    private String leagueName;

    private User leagueCoordinator;

    private Course leagueCourse;

    private List<User> golfersInLeague;

    private Map<User, Integer> leagueGolferScores;

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

    public List<User> getGolfersInLeague() {
        return golfersInLeague;
    }

    public void setGolfersInLeague(List<User> golfersInLeague) {
        this.golfersInLeague = golfersInLeague;
    }

    public Map<User, Integer> getLeagueGolferScores() {
        return leagueGolferScores;
    }

    public void setLeagueGolferScores(Map<User, Integer> leagueGolferScores) {
        this.leagueGolferScores = leagueGolferScores;
    }
}
