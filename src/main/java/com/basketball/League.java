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
        League theLeague = new League();
        
        Team[] theTeams = createTeams();
        Game[] theGames = createGames(theTeams);
                
        for (Game currGame: theGames) {
            currGame.playGame();
            System.out.println(currGame.getDescription());
        }

        theLeague.showBestTeam(theTeams);
 
    }
    
    public static Team[] createTeams(){
        //Team 1
        Player player1 = new Player();
        player1.setPlayerName("Oscar Blancarte");
        Player player2 = new Player();
        player2.setPlayerName("Carlos Raygoza");
        Player player3 = new Player();
        player3.setPlayerName("Andres Bedoya");
        Player[] thePlayers = {player1, player2, player3};
        
        Team team1 = new Team();
        team1.setTeamName("Los Arquitectos");
        team1.setPlayerArray(thePlayers);
        
        //Team2
        Team team2 = new Team();
        team2.setTeamName("Los Rivales");
        team2.setPlayerArray(new Player[3]);
        team2.getPlayerArray()[0] = new Player();
        team2.getPlayerArray()[0].setPlayerName("Michael Jordan");
        team2.getPlayerArray()[1] = new Player();
        team2.getPlayerArray()[1].setPlayerName("Juan Matias");
        team2.getPlayerArray()[2] = new Player();
        team2.getPlayerArray()[2].setPlayerName("Ray Charles");
        
        Team[] theTeams = {team1, team2};
        return theTeams;
    }
    
    public static Game[] createGames(Team[] theTeams){
        Game theGame = new Game();
        theGame.setLocal(theTeams[0]);
        theGame.setVisitor(theTeams[1]);
        Game[] theGames = {theGame};
        return theGames;
    }
    
    public void showBestTeam(Team[] theTeams){
        Team currBestTeam = theTeams[0];
        System.out.println("\nTeam Points");
        
        for (Team currTeam : theTeams) {
            System.out.println(currTeam.getTeamName() + " : " + currTeam.getPointsTotal());
            currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal() ? currTeam: currBestTeam;
        }
        
        System.out.println("El ganador de la liga es " + currBestTeam.getTeamName());
        
    }
}
