package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Match {

    private int matchId;

    private League matchLeague;

    public League getMatchLeague() {
        return matchLeague;
    }

    public void setMatchLeague(League matchLeague) {
        this.matchLeague = matchLeague;
    }

    private LocalDate teeDate;

    private LocalTime teeTime;

    private List<User> golfers;

    private Map<User, Integer> matchGolferScores;

    public Match(int matchId, League matchLeague, LocalDate teeDate, LocalTime teeTime, List<User> golfers, Map<User, Integer> matchGolferScores) {
        this.matchId = matchId;
        this.matchLeague = matchLeague;
        this.teeDate = teeDate;
        this.teeTime = teeTime;
        this.golfers = golfers;
        this.matchGolferScores = matchGolferScores;
    }

    public Match(int matchId, LocalDate teeDate, LocalTime teeTime) {
        this.matchId = matchId;
        this.teeDate = teeDate;
        this.teeTime = teeTime;
    }

    public Match(){

    };

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getLeagueId() {
        return matchLeague.getLeagueId();
    }

//    public void setLeagueId(int leagueId) {
//       this.matchLeague.getLeagueId() = leagueId;
//    }

    public LocalDate getTeeDate() {
        return teeDate;
    }

    public void setTeeDate(LocalDate teeDate) {
        this.teeDate = teeDate;
    }

    public LocalTime getTeeTime() {
        return teeTime;
    }

    public void setTeeTime(LocalTime teeTime) {
        this.teeTime = teeTime;
    }

    public List<User> getGolfers() {
        return golfers;
    }

    public void setGolfers(List<User> golfers) {
        this.golfers = golfers;
    }

    public Map<User, Integer> getMatchGolferScores() {
        return matchGolferScores;
    }

    public void setMatchGolferScores(Map<User, Integer> matchGolferScores) {
        this.matchGolferScores = matchGolferScores;
    }
}
