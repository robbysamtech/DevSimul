/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.care4dear.track.simulate;

import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author robert
 */
public abstract class BaseSimulator {

    private int port = 0;
    private InetAddress ia[] = null;
    private String addressToPush = null;
    
    public String getAddressToPush() {
        return addressToPush;
    }

    public void setAddressToPush(String addressToPush) {
        this.addressToPush = addressToPush;
    }
    
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    protected void prepareSimulation() throws Exception
    {
    ia = InetAddress.getAllByName(getAddressToPush());
    }
    
    protected abstract void runSimulation() throws Exception;
    protected abstract void endSimulation() throws Exception;
    
    public void processString(String simulationString) throws Exception
    {
        if(simulationString != null)
        {
        Socket s = new Socket(ia[0], getPort());
        s.getOutputStream().write(simulationString.getBytes());
        s.close();
        System.out.println("SENT - "+simulationString);
        }
    }
    
    public void simulate() throws Exception
    {
        prepareSimulation();
        runSimulation();
        endSimulation();
    }

}
