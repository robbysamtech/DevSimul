/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.care4dear.track.simulate.file;

import com.care4dear.track.simulate.BaseSimulator;
import java.io.BufferedReader;
import java.io.FileReader;



/**
 *
 * @author robert
 */
public class FileSimulator extends BaseSimulator
{
    private String inputFile = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private String currentLine = null;
    
    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }
    
    public void prepareSimulation() throws Exception
    {
        super.prepareSimulation();
        fr = new FileReader(inputFile);
        br = new BufferedReader(fr);
    }
    
    public void runSimulation() throws Exception
    {
     String s = null;   
     while((s = br.readLine())!= null)
     { 
         processString(s);
     }
    }
    
    public void endSimulation() throws Exception
    {
        if(br != null)
            br.close();
        if(fr != null)
            fr.close();
    }
    
    
}
