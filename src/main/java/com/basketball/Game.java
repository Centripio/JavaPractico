/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basketball;

import java.util.ArrayList;

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


    
    public void playGame(){
       final int minutosBaloncesto = 60; 
       ArrayList<Point> eventList = new ArrayList();
       Point currEvent;
       for ( int i = 1; i <= minutosBaloncesto; i++) {
           //System.out.println("i=" + i);
           if (Math.random() > 0.95) {
               currEvent = new Point();
               currEvent.setTeam(Math.random() >  0.5 ? visitor : local);
               currEvent.setPlayer(currEvent.getTeam()
                       .getPlayerArray()[(int)(Math.random() * currEvent.getTeam().getPlayerArray().length)]);  
               currEvent.setTime(i);
               eventList.add(currEvent);
               System.out.println(i);
           }
           this.points = new Point[eventList.size()];
           eventList.toArray(points);
           
       }
    }
    
    public String getDescription(){
        int pointsLocalTeam = 0;
        int pointsVisitorTeam = 0;
        
        
        StringBuilder returnString = new StringBuilder();
        for (Point point: this.getPoints()) {
            if (point.getTeam() == local) {
                pointsLocalTeam++;
            } else {
                pointsVisitorTeam++;
            }
            
            returnString.append("El punto fue anotado en el minuto "
                + point.getTime() + " por el jugador "
                + point.getPlayer().getPlayerName() + " para el equipo " 
                + point.getTeam().getTeamName() 
                + "\n");
            
        }
        
        if(pointsLocalTeam == pointsVisitorTeam) {
            returnString.append("Es un empate");
            local.incPointsTotal(1);
            visitor.incPointsTotal(1);
        } else if (pointsLocalTeam > pointsVisitorTeam){
            returnString.append(local.getTeamName() + " gano");
            local.incPointsTotal(2);
        } else {
            returnString.append(visitor.getTeamName() + " gano");
            visitor.incPointsTotal(2);
        }
        
        returnString.append(" (" + pointsLocalTeam + " - " + pointsVisitorTeam + ") \n" );
        return returnString.toString();
    }

    @Override
    public String toString() {
        return "local: " + getLocal().getTeamName() + " visitor:" + getVisitor().getTeamName();
    }
    
    
    
}
