package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Match {
    private int matchId;

    private int leagueId;

    private LocalDate teeDate;

    private LocalTime teeTime;

    private List<User> golfers;

    private Map<User, Integer> matchGolferScores;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

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
