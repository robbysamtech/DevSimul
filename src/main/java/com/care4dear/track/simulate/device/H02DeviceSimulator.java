/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.care4dear.track.simulate.device;

import java.util.Date;
import com.care4dear.track.simulate.util.Utilities;

/**
 *
 * @author robert
 */
public class H02DeviceSimulator extends DeviceSimulator
{
    private boolean firstRecord = true;
    private double currentLatitude = 0;
    private double currentLongitude = 0;
            
    @Override
    public String getDeviceData() 
    {
       StringBuffer deviceData = new StringBuffer("*HQ,");
       deviceData.append(getDeviceId()+",");
       deviceData.append("V1,");
       Date plotTime = getNextPlotTime();
       deviceData.append(Utilities.precedeWithLeadingZeros(""+plotTime.getHours()));
       deviceData.append(Utilities.precedeWithLeadingZeros(""+plotTime.getMinutes()));
       deviceData.append(Utilities.precedeWithLeadingZeros(""+plotTime.getSeconds()));
       deviceData.append(",");
       deviceData.append("A,");
       if(firstRecord)
       {
           currentLatitude = getOriginLatitude();
           currentLongitude = getOriginLongitude();
       }
       else
       {
           currentLatitude = Utilities.getRandomPointValue(currentLatitude);
           currentLongitude = Utilities.getRandomPointValue(currentLongitude);
       }    
       firstRecord = false;
       
       deviceData.append(""+currentLatitude+",");
       deviceData.append("N,");
       deviceData.append(""+currentLongitude+",");
       deviceData.append("E,");        
       deviceData.append(""+Utilities.getRandomSpeed(80,95)+",");
       deviceData.append(""+Utilities.getRandomBearing()+",");
       deviceData.append(Utilities.precedeWithLeadingZeros(""+plotTime.getDate()));
       deviceData.append(Utilities.precedeWithLeadingZeros(""+(plotTime.getMonth()+1)));
       deviceData.append(Utilities.precedeWithLeadingZeros(""+(plotTime.getYear()+1900)));
       deviceData.append(","); 
       deviceData.append("FFFFFFFF#");
       
       firstRecord = false;
       
       return deviceData.toString();
       //return "*HQ,4204941934,V1,075000,V,1258.9283,N,07731.1380,E,000.0,232,240416,FFFFFFFF#";
    }
    
    

}
