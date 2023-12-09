package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;




public interface GolfTrackerDao {

    public List<UserInLeague> getLeaderBoardByUserId(int userId);

    public List<User> getAllUsers();

    public List<Match> getAllMatchesInLeague(int leagueId);

    public Match getMatch(int matchId);

    public List<League> getLeaguesByUserId(int userId);

    public League createLeague(League league);

    public Match createMatch(Match match);

    public List<UserInLeague> addUserToLeague(int leagueId, int userId);

    public List<UserInLeague> addUserToMatch(int leagueId, int matchId);

    public int updateMatchScore(int matchId, int userId, int golferScore);

    public Course addCourse(Course course);

    public List<Course> getCourses();

//    public List<User> getUsers();

}


