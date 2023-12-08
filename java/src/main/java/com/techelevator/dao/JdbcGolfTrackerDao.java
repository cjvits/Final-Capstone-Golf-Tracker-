package com.techelevator.dao;

import com.techelevator.model.*;

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
    public List<UserInLeague> getLeaderBoardByUserId(int userId) {
        List<UserInLeague> result = new ArrayList<>();
        String sql = "select users.username, league_golfer.league_score from league_golfer join users on users.user_id = league_golfer.user_id WHERE league_id = (SELECT league_id from league_golfer where user_id = ?);";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()) {
            UserInLeague userInLeague = mapRowToUserInLeague(rowSet);
            result.add(userInLeague);
        }
        return result;
    }

   @Override
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
        Match match = new Match();
        String sql = "Select matches.match_id, tee_date, tee_time, users.user_id, users.username, match_score FROM matches JOIN match_golfer on match_golfer.match_id = matches.match_id JOIN users on match_golfer.user_id = users.user_id WHERE matches.match_id = 1;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, matchId);
        if (rowSet.next()) {
            match.setMatchId(rowSet.getInt("matches.match_id"));
            match.setTeeDate(rowSet.getDate("tee_date").toLocalDate());
            match.setTeeTime(rowSet.getTime("tee_time").toLocalTime());
            List<UserInLeague> golfersInMatch = new ArrayList<>();
            UserInLeague User1 = new UserInLeague();
            User1.setId(rowSet.getInt("users.user_id"));
            User1.setUsername(rowSet.getString("users.username"));
            User1.setMatchScore(rowSet.getInt("match_score"));
            golfersInMatch.add(User1);
            while (rowSet.next()) {
                UserInLeague golfer = mapRowToUserInLeague(rowSet);
                golfersInMatch.add(golfer);
            }
            match.setGolfers(golfersInMatch);
            return match;


        } else {
            return null;
        }
    }

    @Override
    public List<League> getLeaguesOfUser(int userId) {
        List<League> leaguesOfUser = new ArrayList<>();
            String sql = "Select leagues.league_id, league_name FROM leagues join league_golfer on leagues.league_id = league_golfer.league_id where league_golfer.user_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()) {
            League league = mapRowToLeague(rowSet);
            leaguesOfUser.add(league);
        }
        return leaguesOfUser;
    }


    @Override
    public League createLeague(League league) {
        String sql = "INSERT INTO leagues (league_name, coordinator_id, course_id) VALUES (?, ?, ?) RETURNING id;";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class, league.getLeagueName(), league.getLeagueCoordinatorId(), league.getLeagueCourseId());
        league.setLeagueId(newId);

        return league;
    }

    @Override
    public Match createMatch(Match match) {
        String sql = "INSERT INTO matches (league_id, tee_date, tee_time) VALUES (?, ?, ?) RETURNING id;";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class, match.getTeeDate(), match.getTeeTime());
        match.setMatchId(newId);
        return match;
    }

    @Override
    public List<User> addUserToLeague(int leagueId, int userId) {
        List<User> golfersInLeague = new ArrayList<>();
        int initialScore = 0;
        String sql = "INSERT INTO league_golfer (league_id, user_id, league_score) VALUES (?, ?, ?) RETURNING league_id;";
        jdbcTemplate.update(sql, leagueId, userId, initialScore);
        String sql2 = "SELECT users.user_id, username FROM users JOIN league_golfer ON users.user_id = league_golfer.user_id where league_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql2, leagueId);
        while (rowSet.next()) {
            User user = mapRowToUser(rowSet);
            golfersInLeague.add(user);
        }
        return golfersInLeague;
    }

    @Override
    public List<User> addUserToMatch(int userId, int matchId) {
        List<User> golfersInMatch = new ArrayList<>();
        int initialScore = 0;
        String sql = "INSERT INTO match_golfer (match_id, user_id, match_score) VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, matchId, userId, initialScore);
        String sql2 = "SELECT users.user_id, username FROM users JOIN match_golfer ON users.user_id = match_golfer.user_id where match_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql2, matchId);
        while (rowSet.next()) {
            User user = mapRowToUser(rowSet);
            golfersInMatch.add(user);
        }
        return golfersInMatch;
    }

    @Override
    public int updateMatchScore (Match match,int userId, int golferScore) {
        String sql = "UPDATE match_golfer SET match_score = ? where user_id = ? AND match_id = ?;";
        int scoresUpdated = jdbcTemplate.update(sql, golferScore, userId, match.getMatchId());
        return scoresUpdated;

    }

    @Override
    public Course addCourse(Course course) {
        String sql = "INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, course_rating) VALUES (?, ?, ?, ?, ?, ?) RETURNING course_id;";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class,
                course.getCourseName(),
                course.getStreetAddress(),
                course.getCity(),
                course.getState(),
                course.getZipCode(),
                course.getRating());
        course.setCourseId(newId);
        return course;
    }

    private User mapRowToUser(SqlRowSet rowSet) {
        User result = new User();
        result.setId(rowSet.getInt("user_id"));
        result.setUsername(rowSet.getString("username"));
//        result.setFirstName(rowSet.getString("first_name"));
//        result.setLastName(rowSet.getString("last_name"));
        return result;
    }

    private UserInLeague mapRowToUserInLeague(SqlRowSet rowSet) {
        UserInLeague result = new UserInLeague();
        result.setId(rowSet.getInt("users.user_id"));
        result.setUsername(rowSet.getString("users.username"));
        result.setLeagueScore(rowSet.getInt("match_score"));
//
        return result;
    }

    private Match mapRowToMatch(SqlRowSet rowSet) {
        Match result = new Match();
        result.setMatchId(rowSet.getInt("match_id"));
        result.setTeeDate(rowSet.getDate("tee_date").toLocalDate());
        result.setTeeTime(rowSet.getTime("tee_time").toLocalTime());

        return result;
    }

    private League mapRowToLeague(SqlRowSet rowSet) {
        League result = new League();
        result.setLeagueId(rowSet.getInt("match_id"));
        result.setLeagueName(rowSet.getString("league_name"));

        return result;
    }
}
