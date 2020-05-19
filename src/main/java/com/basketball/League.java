/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basketball;

/**
 *
 * @author andresbedoya
 */
public class League {
    
    public static void main (String... args) {
        
        Team[] theTeams = createTeams();
        Game[] theGames = createGames(theTeams);
                
        Game curGame = theGames[0];
        curGame.playGame();

        System.out.println(curGame.toString());
 
    }
    
    public static Team[] createTeams(){
        //Team 1
        Player player1 = new Player();
        player1.playerName = "Oscar Blancarte";
        Player player2 = new Player();
        player2.playerName = "Carlos Raygoza";
        Player player3 = new Player();
        player3.playerName = "Andres Bedoya";
        Player[] thePlayers = {player1, player2, player3};
        
        Team team1 = new Team();
        team1.teamName = "Los Arquitectos";
        team1.playerArray = thePlayers;
        
        //Team2
        Team team2 = new Team();
        team2.teamName = "Los Rivales";
        team2.playerArray = new Player[3];
        team2.playerArray[0] = new Player();
        team2.playerArray[0].playerName = "Michael Jordan";
        team2.playerArray[1] = new Player();
        team2.playerArray[1].playerName = "Juan Matias";
        team2.playerArray[2] = new Player();
        team2.playerArray[2].playerName = "Ray Charles";
        
        Team[] theTeams = {team1, team2};
        return theTeams;
    }
    
    public static Game[] createGames(Team[] theTeams){
        Game theGame = new Game();
        theGame.local = theTeams[0];
        theGame.visitor = theTeams[1];
        Game[] theGames = {theGame};
        return theGames;
    }
}
