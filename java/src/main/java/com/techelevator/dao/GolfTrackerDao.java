package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;




public interface GolfTrackerDao {

    public List<UserInLeague> getLeaderBoardByUserId(int userId);

      public Match getMatch(int matchId);

    public List<League> getLeaguesByUserId(int userId);

    public League createLeague(League league);

    public List<League> getLeaguesByCoordinatorId(int userId);

    public Match createMatch(Match match);

    public void addUserToLeague(int leagueId, int userId);

    public List<UserInLeague> addUserToMatch(int matchId, int userId);

    List<Match> getMatchesByLeagueId(int leagueId);

    public int updateMatchScore(int matchId, int userId, int golferScore);

    public List<Match> getMatchesByUserId (int userId);

    public Course addCourse(Course course);

    public List<Course> getCourses();

    public List<UserInLeague> getLeagueUsersByLeagueId(int leagueId);



}


