/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basketball.util;

import com.basketball.Game;
import com.basketball.Point;
import com.basketball.Team;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author andresbedoya
 */
public class GameUtils {
      public static void addGamePoints(Game currGame) {
        
        if (currGame.points == null) {
            currGame.points = new Point[(int) (Math.random() * 40)]; 
        }

        //System.out.println(currGame.points.length);
        int i = 0;
        for (Point currPoint : currGame.points) {
            currPoint = new Point();
            currPoint.team = Math.random() > 0.5 ? getHomeTeam(currGame, "home") : getHomeTeam(currGame, "away");
            currPoint.player = currPoint.team.playerArray[(int) (Math.random() * currPoint.team.playerArray.length)];
            currPoint.time = (int) (Math.random() * 90);
            currGame.points[i] = currPoint;
            i++;
        }
        Arrays.sort(currGame.points, (g1, g2) -> Double.valueOf(g1.time).compareTo(Double.valueOf(g2.time)));

    }

    // Uses reflection so works with getter method or public field
    private static Team getHomeTeam(Game currGame, String homeOrAway) {
        Team theTeam = null;
        Method m;
        Field f;
        try {
            m = Game.class.getMethod("get" + Character.toUpperCase(homeOrAway.charAt(0)) + homeOrAway.substring(1) + "Team");
            theTeam = (Team)m.invoke(currGame);
            //System.out.println(theTeam);
        } catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException em) {
            try {
                f = Game.class.getField(homeOrAway);
                theTeam = (Team)f.get(currGame);
                //System.out.println(theTeam);
            } catch (NoSuchFieldException|IllegalAccessException ef) { 
                System.out.println("The addPoints() utility requires the Point class to contain either:\n" +
                        "public String fields called homeTeam and awayTeam, OR,\n" +
                        "public accessor methods called getHomeTeam() and getAwayTeam().");
            }
        }
        return theTeam;
    }
    
}
