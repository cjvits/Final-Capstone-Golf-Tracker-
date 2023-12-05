package com.techelevator.dao;

import com.techelevator.model.User;
import com.techelevator.model.Match;
import com.techelevator.model.Course;
import com.techelevator.model.League;
import java.util.List;




public interface GolfTrackerDao {

    public List<User> getAllGolfersInLeague(int leagueId);

    public List<User> getAllGolfersInMatch(int matchId);

    public List<Match> getAllMatchesInLeague(int leagueId);

    public Match getMatch(int matchId);

    public League getLeague (int leagueId);

    public League createLeague(League league);

    public Match createMatch (Match match);

    public List<User> addUserToLeague (int leagueId, int userId);

    public List<User> addUserToMatch (int leagueId, int matchId);

    public List<User> updateMatchScores (Match match);

    public Course addCourse (Course course);


}
