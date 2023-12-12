package com.techelevator.model;

public class MatchDto {

    private Match match = null;

    private int[] playersInMatch;

    public MatchDto(Match match, int[] playersInMatch) {
        this.match = match;
        this.playersInMatch = playersInMatch;
    }

    public MatchDto() {
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public int[] getPlayersInMatch() {
        return playersInMatch;
    }

    public void setPlayersInMatch(int[] playersInMatch) {
        this.playersInMatch = playersInMatch;
    }
}
