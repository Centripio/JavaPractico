/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basketball;

import com.basketball.util.GameUtils;

/**
 *
 * @author andresbedoya
 */
public class Game {
    public Team local;
    public Team visitor;
    public Point[] points;

    public void playGame(int maxPoints) {
        int numberOfPoints = (int)(Math.random() * maxPoints + 1);
        System.out.println("numberOfPoints:" + numberOfPoints);
        Point[] thePoints = new Point[numberOfPoints];
        System.out.println("thePoints:" + thePoints.length);
        this.points = thePoints;
        GameUtils.addGamePoints(this);
    }
    
    public void playGame(){
        playGame(35);
    }
    
    public String getDescription(){
        StringBuilder returnString = new StringBuilder();
        for (Point point: this.points) {
            returnString.append("El punto fue anotado en el minuto "
                + point.time + " por el jugador "
                + point.player.playerName + " para el equipo " 
                + point.team.teamName 
                + "\n");
            
        }
        return returnString.toString();
    }

    @Override
    public String toString() {
        return "local: " + local.teamName + " visitor:" + visitor.teamName;
    }
    
    
    
}
