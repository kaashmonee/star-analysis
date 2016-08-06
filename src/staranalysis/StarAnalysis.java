/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staranalysis;

import java.io.*;
import java.util.*;

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
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        Scanner sc=new Scanner(System.in);
        boolean thereMore=true;
        String starName;
        double kurtosis;
        double skewness;
        String yn = "";
        String notes = "";
        ArrayList<Star> starList=new ArrayList<>();
        Console console=System.console();
        BufferedReader r= new BufferedReader(new InputStreamReader(System.in));
        
        
        while (thereMore){
        System.out.print("Please enter the star name: ");
        starName=r.readLine();
        System.out.print("\nKurtosis: ");
        kurtosis=sc.nextDouble();
        System.out.print("\nSkewness: ");
        skewness=sc.nextDouble();
        System.out.print("\nNotes:");
        
                
        notes=r.readLine();
        Star s=new Star(starName, skewness, kurtosis);
        starList.add(s);
        
        try  {
            PrintWriter writer;
            writer = new PrintWriter("Stars/"+s.getName()+".txt","UTF-8");
            writer.println("Star name: "+s.getName());
            writer.println("Skewness: "+s.skewness());
            writer.println("Kurtosis: "+s.kurtosis());
            writer.println(notes);
            writer.close();
            System.out.print("\nContinue? (y/n): ");
            
            yn=r.readLine();
            thereMore = yn.equals("y");
        }
        catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.print(e);
        }
        
        }
        PrintWriter writer2=new PrintWriter("Stars/StarsDone.txt","UTF-8");
        for (Star star: starList) {
            writer2.println(star.getName());
        }
        writer2.close();
    }
    
}
