/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basketball;

import com.basketball.util.PlayerDatabase;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author andresbedoya
 */
public class League {
    
    public static void main (String... args) {
        League theLeague = new League();
        
        //Team[] theTeams = createTeams();
        Team[] theTeams = theLeague.createTeams("Los Arquitectos,Los rivales,Los increibles", 6);
        Game[] theGames = theLeague.createGames(theTeams);
                
        for (Game currGame: theGames) {
            currGame.playGame();
            System.out.println(currGame.getDescription());
            break;
            
        }

        theLeague.showBestTeam(theTeams);
 
    }
    
    public Team[] createTeams(String teamNames, int teamSize){
        PlayerDatabase playerDB = new PlayerDatabase();
        
        StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ",");
        Team[] theTeams = new Team[teamNameTokens.countTokens()];
        for (int i=0; i < theTeams.length; i++) {
            theTeams[i] = new Team(teamNameTokens.nextToken(), playerDB.getTeam(teamSize));
        }
        return theTeams;
    }
    
    public Game[] createGames(Team[] theTeams){
        int daysBetweenGames = 0;
        ArrayList<Game> theGames = new ArrayList();
        
        for(Team localTeam : theTeams) {
            for(Team visitorTeam : theTeams) {
                if (localTeam != visitorTeam) {
                    theGames.add(new Game(localTeam, visitorTeam, LocalDateTime.now().plusDays(daysBetweenGames)));
                }
            }
        }
        
        return (Game[]) theGames.toArray(new Game[1]);
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
