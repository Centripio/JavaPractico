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
        
        System.out.println("EQUIPO 1 ");
        for (Player player : team1.playerArray) {
            System.out.println("player " + player.playerName.split(" ")[1] + " " +player.playerName.split(" ")[0]);
            
        }
        
        System.out.println("EQUIPO 2 ");
        for (Player player : team2.playerArray) {
            System.out.println("player " + player.playerName.split(" ")[1] + " " + player.playerName.split(" ")[0]);

        }
                
        Game curGame = new Game();
        curGame.local = team1;
        curGame.visitor = team2;
        
        Point point = new Point();
        point.player = curGame.local.playerArray[2];
        point.team=curGame.local;
        point.time=56;
        
        Point[] points = {point};
        curGame.point = points;
        
        System.out.println("El punto fue anotado  en el minuto "
            + curGame.point[0].time + " por "
            + curGame.point[0].player.playerName + " para el equipo " 
            + curGame.point[0].team.teamName);
        
        
        for (Player player: team2.playerArray){
            if (player.playerName.matches(".*Jor.*")) {
                System.out.println("Jugador Encontrado " + player.playerName); 
                System.out.println("Apellido " + player.playerName.split(" ")[1]); 
            }
        }
        
        
        
 
    }
    
}
