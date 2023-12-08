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

    public List<League> getLeaguesByUserId(int userId){
        List<League> leaguesByUser = new ArrayList<>();
        String sqlLeagueInfo = "Select leagues.league_id, league_name FROM leagues JOIN league_golfer on league_golfer.league_id = leagues.league_id JOIN users on league_golfer.user_id = users.user_id WHERE league_golfer.user_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sqlLeagueInfo, userId);
        while (rowSet.next()){
            League league = mapRowToLeagueIdAndName(rowSet);
            leaguesByUser.add(league);
        }

        for (League league : leaguesByUser) {
            league.setGolfersInLeague(getLeagueUsersByLeagueId(league.getLeagueId()));
            league.setMatchesInLeague(getMatchesByLeagueId(league.getLeagueId()));
            }

        return leaguesByUser;
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


    //Matches
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
        String sql = "Select matches.match_id, tee_date, tee_time, users.user_id, users.username, match_score FROM matches JOIN match_golfer on match_golfer.match_id = matches.match_id JOIN users on match_golfer.user_id = users.user_id WHERE matches.match_id = ?;";
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
    public Match createMatch(Match match) {
        String sql = "INSERT INTO matches (league_id, tee_date, tee_time) VALUES (?, ?, ?) RETURNING id;";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class, match.getTeeDate(), match.getTeeTime());
        match.setMatchId(newId);
        return match;
    }

    @Override
    public List<UserInLeague> addUserToMatch(int userId, int matchId) {
        List<UserInLeague> golfersInMatch = new ArrayList<>();
        int initialScore = 0;
        String sql = "INSERT INTO match_golfer (match_id, user_id, match_score) VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, matchId, userId, initialScore);
        String sql2 = "SELECT users.user_id, username FROM users JOIN match_golfer ON users.user_id = match_golfer.user_id where match_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql2, matchId);
        while (rowSet.next()) {
            UserInLeague user = mapRowToUsersInLeagueForMatch(rowSet);
            golfersInMatch.add(user);
        }
        return golfersInMatch;
    }

    @Override
    public int updateMatchScore (int matchId,int userId, int golferScore) {
        String sql = "UPDATE match_golfer SET match_score = ? where user_id = ? AND match_id = ?;";
        int scoresUpdated = jdbcTemplate.update(sql, golferScore, userId, matchId);
        return scoresUpdated;

    }


    //Leagues
    @Override
    public League createLeague(League league) {
        String sql = "INSERT INTO leagues (league_name, coordinator_id, course_id) VALUES (?, ?, ?) RETURNING id;";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class, league.getLeagueName(), league.getLeagueCoordinatorId(), league.getLeagueCourseId());
        league.setLeagueId(newId);

        return league;
    }


    @Override
    public List<UserInLeague> addUserToLeague(int leagueId, int userId) {
        List<UserInLeague> golfersInLeague = new ArrayList<>();
        int initialScore = 0;
        String sql = "INSERT INTO league_golfer (league_id, user_id, league_score) VALUES (?, ?, ?) RETURNING league_id;";
        jdbcTemplate.update(sql, leagueId, userId, initialScore);
        String sql2 = "SELECT users.user_id, username FROM users JOIN league_golfer ON users.user_id = league_golfer.user_id where league_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql2, leagueId);
        while (rowSet.next()) {
            UserInLeague user = mapRowToUserInLeague(rowSet);
            golfersInLeague.add(user);
        }
        return golfersInLeague;
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

    @Override
    public List<Course> getCourses() {
        List<Course> allCourses = new ArrayList<>();
        String sql = "SELECT * FROM courses;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            Course course = mapRowToCourse(rowSet);
            allCourses.add(course);
        }
        return allCourses;
    }

    private UserInLeague mapRowToUserInLeague(SqlRowSet rowSet) {
        UserInLeague result = new UserInLeague();
        result.setId(rowSet.getInt("user_id"));
        result.setUsername(rowSet.getString("username"));
        return result;
    }

    private UserInLeague mapRowToUsersInLeagueForMatch(SqlRowSet rowSet) {
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

    private League mapRowToLeagueIdAndName(SqlRowSet rowSet) {
        League result = new League();
        result.setLeagueId(rowSet.getInt("league_id"));
        result.setLeagueName(rowSet.getString("league_name"));

        return result;
    }

    public List<UserInLeague> getLeagueUsersByLeagueId(int leagueId) {
        List<UserInLeague> usersInLeague = new ArrayList<>();
        String sql = "SELECT users.user_id, users.username, league_score, handicap FROM league_golfer JOIN users on users.user_id = league_golfer.user_id WHERE league_golfer.league_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, leagueId);
        while (rowSet.next()) {
            UserInLeague user = mapRowToUsersInLeague2(rowSet);
            usersInLeague.add(user);
        }
        return usersInLeague;
    }

        private UserInLeague mapRowToUsersInLeague2(SqlRowSet rowSet) {
            UserInLeague result = new UserInLeague();
            result.setId(rowSet.getInt("user_id"));
            result.setUsername(rowSet.getString("username"));
            result.setLeagueScore(rowSet.getInt("league_score"));
            result.setHandicap(rowSet.getInt("handicap"));
            return result;
        }

    public List<Match> getMatchesByLeagueId(int leagueId) {
        List<Match> matchesInLeague = new ArrayList<>();
        String sql = "SELECT match_id, tee_time, tee_date FROM matches where league_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, leagueId);
        while (rowSet.next()) {
            Match match = mapRowToMatch(rowSet);
            matchesInLeague.add(match);
        }
        for (Match match: matchesInLeague) {
            getUsersByMatchId(match.getMatchId());

        }
        return matchesInLeague;
    }

    public List<UserInLeague> getUsersByMatchId(int matchId) {
        List<UserInLeague> usersInMatch = new ArrayList<>();
        String sql = "SELECT users.user_id, users.username, match_score FROM match_golfer JOIN users on users.user_id = match_golfer.user_id WHERE match_golfer.match_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, matchId);
        while (rowSet.next()) {
            UserInLeague user = mapRowToUsersInMatch(rowSet);
            usersInMatch.add(user);
        }
        return usersInMatch;
    }

    private UserInLeague mapRowToUsersInMatch(SqlRowSet rowSet) {
        UserInLeague result = new UserInLeague();
        result.setId(rowSet.getInt("user_id"));
        result.setUsername(rowSet.getString("username"));
        result.setMatchScore(rowSet.getInt("match_score"));
        return result;
    }

    private Course mapRowToCourse(SqlRowSet rowSet) {
        Course result = new Course();
        result.setCourseId(rowSet.getInt("course_id"));
        result.setCourseName(rowSet.getString("course_name"));
        result.setStreetAddress(rowSet.getString("street_address"));
        result.setCity(rowSet.getString("city"));
        result.setState(rowSet.getString("state_abb"));
        result.setZipCode(rowSet.getInt("zip_code"));
        result.setRating(rowSet.getInt("course_rating"));
        return result;
    }
}
