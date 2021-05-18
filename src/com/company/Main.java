package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        //the board-size is set to be 100 by default
        System.out.println("**** WELCOME TO THE SNAKE AND LADDER GAME THE BOARD-SIZE IS SET TO BE 100 BY DEFAULT ****");
        System.out.println("Enter the number of players........(at least 1)..");
        Scanner scanner = new Scanner(System.in);
        int numPlayers = scanner.nextInt();

        //addition of players in the game
        for (int i=0;i<numPlayers;i++){
            System.out.println("Enter the name of Player "+(i+1));
            String playerName = scanner.next();
            game.addPlayers(playerName);
        }

        System.out.println();
        System.out.println("Enter the number of ladders you want to insert!!..");
        int numLadders =scanner.nextInt();

        //addition of ladders in the game
        for(int i=0;i<numLadders;i++){
            System.out.println("Enter the start and the end value of ladder "+(i+1)+" separated by a whitespace");
            int startLadder,endLadder;
            startLadder=scanner.nextInt();
            endLadder=  scanner.nextInt();
            game.addLadders(i+1,startLadder,endLadder);
        }

        System.out.println();
        System.out.println("Enter the number of snakes you want to insert!!..");
        int numSnakes = scanner.nextInt();

        //addition of snakes in the game
        for (int i=0;i<numSnakes;i++){
            System.out.println("Enter the head and tail value of snake "+(i+1)+" separated by whitespace");
            int headSnake,tailSnake;
            headSnake= scanner.nextInt();
            tailSnake = scanner.nextInt();
            game.addSnakes(i+1,headSnake,tailSnake);
        }

        System.out.println();
        System.out.println("players in the game are ");
        game.printPlayers();

        System.out.println();
        System.out.println("starting game......");
        System.out.println();
        game.StartGame();

    }
}
