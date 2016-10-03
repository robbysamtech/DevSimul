/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.care4dear.track.simulate.util;

/**
 *
 * @author robert
 */
public class Utilities 
{
    public static String precedeWithLeadingZeros(String input)
    {
     if(input.length()==1)
     input="0"+input;

     return input;
    }
    
    public static long getRandomNumberWithinRange(long start, long end)
    {
        return (start +((long) ((end-start) * Math.random())));
    }
    
    public static long getRandomSpeed(long start, long end)
    {
     return Utilities.getRandomNumberWithinRange(start, end);
    }

    public static long getRandomBearing()
    {
     return Utilities.getRandomNumberWithinRange(0, 359);
    }
    
    // Replaces the unit decimal number to a random number.
    public static double getRandomPointValue(double input)
    {
     //int random =(int) (Math.random()*10); // will get 1 to 9.
     
    int frontBack = (int) Math.random()*3;
     
     if(frontBack <= 1)
     {
         return input - (((int) (Math.random()*10)*.01));
     }
    
    return input + (((int) (Math.random()*10)*.01)); 
    
    }

    
//    public static void main(String arg[])
//    {
//        for (int i=0; i<50;i++)
//        {
//            getRandomNumberWithinRange(0, 3);
//        }
//    }

}
