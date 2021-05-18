package com.company;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.lang.Integer;

public class Game {
    private int boardSize=100;
    private Vector<String> players=new Vector<>();
    private boolean winningFlag=false;
    private String winner;

    public int getBoardSize() {
        return boardSize;
    }
    public Game(){
        ;
    }
    public Game(int boardSize) {
        this.boardSize=boardSize;
    }
    public void addPlayers(String player) {
        players.add(player);
    }
    public void printPlayers(){
        if(players.size()==0){
            System.out.println("no players");
        }
        else{
            System.out.println("Players are: "+players);
        }
    }

    private void setWinningFlag(Boolean flag){
        this.winningFlag=flag;
    }

    private boolean checkWinning(){
        if(winningFlag){
            return true;
        }
        else{
            return false;
        }
    }

    Map<Integer,player> myMap= new TreeMap<Integer,player>();
    private void playerInitialization(){
        for(int i=0;i<players.size();i++){
            myMap.put(i,new player());
            myMap.get(i).setPlayerName(players.elementAt(i));
        }
    }

    private player playerAt(int index){
        return myMap.get(index);
    }

    private int getDiceNumber(){
        int lowerBound=1;
        int upperBound=6;
        int diceNumber =(int)Math.floor(Math.random()*(upperBound-lowerBound+1)+lowerBound);
        return diceNumber;
    }

    ladders ladders = new ladders();
    snakes snakes = new snakes();

    public void addLadders(int index, int start, int end) {
        ladders.addLadder(index,start,end);
    }

    public void addSnakes(int index, int head, int tail) {
        snakes.addSnake(index,head,tail);
    }

    public void StartGame(){
        if(players.size()==0){
            System.out.println("no players in the game");
        }
        else{
            playerInitialization();
            for(int i=0;i<players.size();i++){
                int diceNumber=getDiceNumber();
                if(playerAt(i).getPlayerPosition()+diceNumber<=100){
                    playerAt(i).setPlayerPosition(playerAt(i).getPlayerPosition()+diceNumber);
                    System.out.println(diceNumber+" came! "+playerAt(i).getPlayerName()+" moves to "+ playerAt(i).getPlayerPosition());
                }
                else{
                    System.out.println(diceNumber+" came! "+playerAt(i).getPlayerName()+" better luck next time!! as the dice number takes you greater than 100");
                }

                //check for snake and ladder in the updated position
                int currentPosition=playerAt(i).getPlayerPosition();
                boolean simultaneityFlag=false;

                while (!((ladders.getLadderWithStart(currentPosition) == null && snakes.getSnakeWithHead(currentPosition)==null))){
                   if(ladders.getLadderWithStart(currentPosition)!=null && snakes.getSnakeWithHead(currentPosition)!=null){
                       //there is a ladder start and snake head at the same place which is invalid
                       simultaneityFlag=true;
                       System.out.println("there is a ladder start and snake head at the same place!!");
                       break;
                   }
                   else if(ladders.getLadderWithStart(currentPosition)!=null && snakes.getSnakeWithHead(currentPosition)==null){
                       //we have got a ladder
                       String currentPlayerName=playerAt(i).getPlayerName();
                       int destinationPosition=ladders.getLadderWithStart(currentPosition).getEnd();
                       int indexLadder = ladders.getLadderWithStart(currentPosition).getIndex();
                       System.out.println(currentPlayerName+" got ladder no. "+indexLadder+" and moves from "+currentPosition+" to "+destinationPosition);
                       playerAt(i).setPlayerPosition(destinationPosition);
                       currentPosition=destinationPosition;
                   }
                   else{
                       //we have got a snake
                       String currentPlayerName=playerAt(i).getPlayerName();
                       int destinationPosition=snakes.getSnakeWithHead(currentPosition).getTail();
                       int indexSnake = snakes.getSnakeWithHead(currentPosition).getSnakeIndex();
                       System.out.println(currentPlayerName+" bited by snake no. "+indexSnake+" and moves from "+currentPosition+" to "+destinationPosition);
                       playerAt(i).setPlayerPosition(destinationPosition);
                       currentPosition=destinationPosition;
                   }
                }
                //simultaneityError
                if(simultaneityFlag){
                    System.out.println("caught simultaneity error!!");
                    break;
                }

                //updation of winning flag if the current player wons
                if(playerAt(i).getPlayerPosition()==100){
                    setWinningFlag(true);
                }
                if(checkWinning()==true){
                    System.out.println(playerAt(i).getPlayerName()+" wins the game!!");
                    break;
                }
                else if(i==players.size()-1){
                    i=-1;
                }
                else{
                    ;
                }

            }
        }


    }



}
