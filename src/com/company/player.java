package com.company;

public class player {
    private int position=0;
    private String playerName;

    public void setPlayerName(String playerName){
        this.playerName=playerName;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public void setPlayerPosition(int position) {
        this.position = position;
    }

    public int getPlayerPosition() {
        return this.position;
    }
}
