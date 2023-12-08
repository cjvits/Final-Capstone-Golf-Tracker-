package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;




public interface GolfTrackerDao {

    public List<UserInLeague> getLeaderBoardByUserId(int userId);

    public List<User> getAllGolfersInMatch(int matchId);

    public List<Match> getAllMatchesInLeague(int leagueId);

    public Match getMatch(int matchId);

    public List<League> getLeaguesOfUser (int userId);

    public League createLeague(League league);

    public Match createMatch (Match match);

    public List<User> addUserToLeague (int leagueId, int userId);

    public List<User> addUserToMatch (int leagueId, int matchId);

    public int updateMatchScore (Match match,int userId, int golferScore);

    public Course addCourse (Course course);


    League getLeagueByUserId(int userId);
}
