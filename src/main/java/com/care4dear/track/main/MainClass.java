/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.care4dear.track.main;

import com.care4dear.track.simulate.device.DeviceSimulator;
import com.care4dear.track.simulate.device.H02DeviceSimulator;
import com.care4dear.track.simulate.file.FileSimulator;

/**
 *
 * @author robert
 */
public class MainClass {
    public static void main(String arg[]) throws Exception
    {
     String fileMode = "file";
     String autoMode = "auto";
     
     if(arg.length == 0)
     {
     System.out.println("Usage :");
     System.out.println("java -jar Simulator-1.0.jar "+autoMode+" <<IPAddressOfServer>> <<portNumber>> <<addressOfInputFile>>");
     System.out.println("Sample : ");
     System.out.println("java -jar Simulator-1.0.jar "+autoMode+" localhost 5013  8377493223 200 130416235650 5 1258.9283 07731.1380");

     System.out.println("or");
     System.out.println("java -jar Simulator.jar-1.0.jar "+fileMode+" <<IPAddressOfServer>> <<portNumber>> <<deviceId>> <<numOfPositions>> <<ddMMyyHHmmss>> <<timeDelayInMinutes>> <<originLat>> <<originLong>>");
     System.out.println("Sample : ");
     System.out.println("java -jar Simulator-1.0.jar "+fileMode+" localhost 5013  c:/myinput.txt");
    return;
     }
     
     if(arg[0].equals(autoMode))
     {
     DeviceSimulator simulator = new H02DeviceSimulator();
     simulator.setAddressToPush(arg[1]);
     simulator.setPort(Integer.parseInt(arg[2]));
     simulator.setDeviceId(arg[3]);
     simulator.setNumberOfPositions(Integer.parseInt(arg[4]));
     simulator.setFirstDataTrasmittedTime(arg[5]); // ddMMyyHHmmss
     simulator.setTimeDelay(Integer.parseInt(arg[6]) * 60 * 1000);
     simulator.setOriginLatitude(Double.parseDouble(arg[7]));
     simulator.setOriginLongitude(Double.parseDouble(arg[8]));
     simulator.simulate();
     System.out.println("Simulation completed");
     }
     else if (arg[0].equals(fileMode))
     {
         FileSimulator simulator = new FileSimulator();
         simulator.setAddressToPush(arg[1]);
         simulator.setPort(Integer.parseInt(arg[2]));
         simulator.setInputFile(arg[3]);
         simulator.simulate();
         
       System.out.println("Simulation completed");
     }
     else
     {
       System.out.println("Unknown Option");
     }
    /* simulator.setAddressToPush("localhost");
     simulator.setPort(5013);
     simulator.setDeviceId("8377493223");
     simulator.setNumberOfPositions(200);
     simulator.setFirstDataTrasmittedTime("130416235650"); // ddMMyyHHmmss
     simulator.setTimeDelay(5*1000);
     simulator.setOriginLatitude(1258.9283);
     simulator.setOriginLongitude(07731.1380);
     */

    }

}
