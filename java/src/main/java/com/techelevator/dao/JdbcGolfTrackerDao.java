package com.techelevator.dao;

import com.techelevator.model.Course;
import com.techelevator.model.League;
import com.techelevator.model.Match;
import com.techelevator.model.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGolfTrackerDao implements GolfTrackerDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcGolfTrackerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getAllGolfersInLeague(int leagueId) {
        List<User> result = new ArrayList<>();
        String sql = "select users.user_id, username, first_name, last_name, league_id from users join league_golfer on users.user_id = league_golfer.user_id WHERE league_golfer.leauge_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, leagueId);
        while (rowSet.next()) {
            User user = mapRowToUser(rowSet);
            result.add(user);
        }
        return result;
    }

    public List<User> getAllGolfersInMatch(int matchId) {
        List<User> result = new ArrayList<>();
        String sql = "select users.user_id, username, first_name, last_name, match_id from users join match_golfer on users.user_id = match_golfer.user_id WHERE match_golfer.match_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, matchId);
        while (rowSet.next()) {
            User user = mapRowToUser(rowSet);
            result.add(user);
        }
        return result;
    }

    @Override
    public List<Match> getAllMatchesInLeague(int leagueId) {
        List<Match> result = new ArrayList<>();
        String sql = "select match_id, tee_date, tee_time FROM matches WHERE league_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, leagueId);
        while (rowSet.next()) {
            Match match = mapRowToMatch(rowSet);
            result.add(match);
        }
        return result;

    }

    @Override
    public Match getMatch(int matchId) {
        String sql = "Select match_id, tee_date, tee_time FROM matches WHERE match_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, matchId);
        if (rowSet.next()) {
            Match match = mapRowToMatch(rowSet);
            return match;
        } else {
            return null;
        }
    }
lea
    @Override
    public League getLeague(int leagueId) {
        String sql = "Select tee_date, tee_time FROM matches WHERE match_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, leagueId);
        if (rowSet.next()) {
            League league = mapRowToLeague(rowSet);
            return league;
        } else {
            return null;
        }
        return null;
    }

    @Override
    public League createLeague(League league) {
        return null;
    }

    @Override
    public Match createMatch(Match match) {
        return null;
    }

    @Override
    public List<User> addUserToLeague(int leagueId, int userId) {
        return null;
    }

    @Override
    public List<User> addUserToMatch(int leagueId, int matchId) {
        return null;
    }

    @Override
    public List<User> updateMatchScores(Match match) {
        return null;
    }

    @Override
    public Course addCourse(Course course) {
        return null;
    }

    private User mapRowToUser(SqlRowSet rowSet) {
        User result = new User();
        result.setId(rowSet.getInt("user_id"));
        result.setUsername(rowSet.getString("username"));
//        result.setFirstName(rowSet.getString("first_name"));
//        result.setLastName(rowSet.getString("last_name"));
        return result;
    }

    private Match mapRowToMatch(SqlRowSet rowSet) {
        Match result = new Match();
        result.setMatchId(rowSet.getInt("match_id"));
        result.setTeeDate(rowSet.getDate("tee_date").toLocalDate());
        result.setTeeTime(rowSet.getTime("tee_time").toLocalTime());

        return result;
    }

    private Match mapRowToLeague(SqlRowSet rowSet) {
        League result = new League();
        result.setLeagueId(rowSet.getInt("match_id"));
        result.setLeagueName(rowSet.getDate("tee_date").toLocalDate());
        result.setTeeTime(rowSet.getTime("tee_time").toLocalTime());

        return result;
    }
}
