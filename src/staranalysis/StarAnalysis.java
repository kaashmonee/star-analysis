/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staranalysis;

import java.io.*;

/**
 *
 * @author skanda
 */
public class StarAnalysis {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Star s=new Star("HD183143",0.45,0.23);
        System.out.print(s.getName()+" ");
        try (PrintWriter writer = new PrintWriter(s.getName()+".txt","UTF-8")) {
            writer.println("this is the first line");
        }
        catch (Exception e) {
            System.out.print(e);
        }
    }
    
}
