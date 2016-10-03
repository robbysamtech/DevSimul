/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.care4dear.track.simulate.device;


import com.care4dear.track.simulate.BaseSimulator;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author robert
 */
public abstract class DeviceSimulator extends BaseSimulator
{
    
    private long timeDelay = 1000l;
    private String deviceId = null;
    private Date lastPlotDate = null;
    private double originLatitude = 0;
    private double originLongitude = 0;

    public double getOriginLatitude() {
        return originLatitude;
    }

    public void setOriginLatitude(double originLatitude) {
        this.originLatitude = originLatitude;
    }

    public double getOriginLongitude() {
        return originLongitude;
    }

    public void setOriginLongitude(double originLongitude) {
        this.originLongitude = originLongitude;
    }
    
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public long getTimeDelay() {
        return timeDelay;
    }

    public void setTimeDelay(long timeDelay) {
        this.timeDelay = timeDelay;
    }
    private Delay delayType = Delay.FIXED;
    public enum Delay {RANDOM, FIXED};
    private int numberOfPositions = 0;

    public int getNumberOfPositions() {
        return numberOfPositions;
    }

    public void setNumberOfPositions(int numberOfPositions) {
        this.numberOfPositions = numberOfPositions;
    }
    private String[] deviceIds = new String[]{};
    private String firstDataTrasmittedTime = "010101010101";

    public String getFirstDataTrasmittedTime() {
        return firstDataTrasmittedTime;
    }

    public void setFirstDataTrasmittedTime(String firstDataTrasmittedTime) {
        this.firstDataTrasmittedTime = firstDataTrasmittedTime;
    }
    
    public abstract String getDeviceData() throws Exception;

    
    public void runSimulation() throws Exception
    {
        lastPlotDate = null;
        
        for(int i = 0;i<numberOfPositions;i++)
        {
            String s = getDeviceData();
            processString(s);           
        }
    }
    
    public Date getNextPlotTime()
    {
        Date plotDate = null;
        
    
        if(lastPlotDate == null)
        {
            plotDate = getDateFromFirstDateTransmittedTime();
            lastPlotDate = new Date(plotDate.getTime());
            return plotDate;
        }
        
        plotDate = new Date(lastPlotDate.getTime());
       
        
        long timeInMillis = plotDate.getTime();
        timeInMillis = timeInMillis + timeDelay;
        
        plotDate = new Date(timeInMillis);
        lastPlotDate = new Date(plotDate.getTime());
        return plotDate;
        
        
    }        
    
    public Date getDateFromFirstDateTransmittedTime()
    {
        String input = getFirstDataTrasmittedTime();
        // ddMMyyHHmmss
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.DATE, getFirstTwoNumbers(input));
        input = input.substring(2, input.length());
        cal.set(Calendar.MONTH, getFirstTwoNumbers(input)-1);
        input = input.substring(2, input.length());
        cal.set(Calendar.YEAR, getFirstTwoNumbers(input));
        input = input.substring(2, input.length());
        cal.set(Calendar.HOUR_OF_DAY, getFirstTwoNumbers(input));
        input = input.substring(2, input.length());
        cal.set(Calendar.MINUTE, getFirstTwoNumbers(input));
        input = input.substring(2, input.length());
        cal.set(Calendar.SECOND, Integer.parseInt(input));
        return cal.getTime();
    }
    
    public int getFirstTwoNumbers(String input)
    {
        int output =  Integer.parseInt(""+input.charAt(0)+input.charAt(1));
        return output;
    }
    
    @Override
    public void endSimulation() throws Exception
    {
    
    }
}
