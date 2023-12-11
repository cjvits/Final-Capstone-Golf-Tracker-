package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Match {

    private int matchId;

    private League matchLeague;

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    private String leagueName;

    public League getMatchLeague() {
        return matchLeague;
    }

    public void setMatchLeague(League matchLeague) {
        this.matchLeague = matchLeague;
    }

    private LocalDate teeDate;

    private LocalTime teeTime;

    private List<UserInLeague> golfers;

    public Match(int matchId, League matchLeague, LocalDate teeDate, LocalTime teeTime, List<UserInLeague> golfers, Map<User, Integer> matchGolferScores) {
        this.matchId = matchId;
        this.matchLeague = matchLeague;
        this.teeDate = teeDate;
        this.teeTime = teeTime;
        this.golfers = golfers;
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
        if (matchLeague == null) {
            return 0;
        }

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

    public List<UserInLeague> getGolfers() {
        return golfers;
    }

    public void setGolfers(List<UserInLeague> golfers) {
        this.golfers = golfers;
    }


}
