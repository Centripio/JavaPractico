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
public class Game {
    Team local;
    Team visitor;
    Point[] point;

    @Override
    public String toString() {
        return "local: " + local.teamName + " visitor:" + visitor.teamName;
    }
    
    
    
}
