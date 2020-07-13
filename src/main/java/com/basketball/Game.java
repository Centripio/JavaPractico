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
    private Team local;
    private Team visitor;
    private Point[] points;
    /**
     * @return the local
     */
    public Team getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(Team local) {
        this.local = local;
    }

    /**
     * @return the visitor
     */
    public Team getVisitor() {
        return visitor;
    }

    /**
     * @param visitor the visitor to set
     */
    public void setVisitor(Team visitor) {
        this.visitor = visitor;
    }

    /**
     * @return the points
     */
    public Point[] getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(Point[] points) {
        this.points = points;
    }


    public void playGame(int maxPoints) {
        int numberOfPoints = (int)(Math.random() * maxPoints + 1);
        System.out.println("numberOfPoints:" + numberOfPoints);
        Point[] thePoints = new Point[numberOfPoints];
        System.out.println("thePoints:" + thePoints.length);
        this.setPoints(thePoints);
        GameUtils.addGamePoints(this);
    }
    
    public void playGame(){
        playGame(35);
    }
    
    public String getDescription(){
        StringBuilder returnString = new StringBuilder();
        for (Point point: this.getPoints()) {
            returnString.append("El punto fue anotado en el minuto "
                + point.getTime() + " por el jugador "
                + point.getPlayer().getPlayerName() + " para el equipo " 
                + point.getTeam().getTeamName() 
                + "\n");
            
        }
        return returnString.toString();
    }

    @Override
    public String toString() {
        return "local: " + getLocal().getTeamName() + " visitor:" + getVisitor().getTeamName();
    }
    
    
    
}
