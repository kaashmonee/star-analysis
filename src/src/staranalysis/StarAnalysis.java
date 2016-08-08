/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.staranalysis;

import java.awt.Desktop;
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
        int fileNum=0;
        
        while (thereMore){
        openPDF(fileNum);
        System.out.print("\nPlease enter the star name: ");
        starName=r.readLine();
        System.out.print("\nKurtosis: ");
        kurtosis=sc.nextDouble();
        System.out.print("\nSkewness: ");
        skewness=sc.nextDouble();
        System.out.print("\nNotes:");
        
        
        Star s=new Star(starName, skewness, kurtosis);
        starList.add(s);
        String line;
        try  {
            PrintWriter writer;
            writer = new PrintWriter("Stars/"+s.getName()+".txt","UTF-8");
            writer.println("Star name: "+s.getName());
            writer.println("Skewness: "+s.skewness());
            writer.println("Kurtosis: "+s.kurtosis());
            while ((line=r.readLine())!=null && line.length()!=0) {       
            writer.println(line);
            }
            //writer.println(notes);
            writer.close();
            System.out.print("\nContinue? (y/n): ");
            
            yn=r.readLine();
            thereMore = yn.equals("y");
        }
        catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.print(e);
        }
        fileNum++;
        }
        PrintWriter writer2=new PrintWriter("Stars/StarsDone.txt","UTF-8");
        for (Star star: starList) {
            writer2.println(star.getName());
        }
        writer2.close();
               
        
    }
    
    private static void openPDF(int val) {
        if (Desktop.isDesktopSupported()) {
            File hiResFolder= new File("hires");
            String [] hiFiles=hiResFolder.list();
            /*
            File lowResFolder= new File("lowres"); STILL NEED TO ADD LOW RES FOLDER
            String [] lowFiles=lowResFolder.list();*/
            try {
                
                File hiFile= new File("hires/"+hiFiles[val]);
                /*File lowFile=new File("lowres/"+lowFiles[val]);*/ //INCLUDE WHEN YOU ADD LOW RES FOLDER
                Desktop.getDesktop().open(hiFile);
                //Desktop.getDesktop().open(lowFile); INCLUDE WHEN YOU ADD LOW RES FOLDER
            }
            catch (IOException e) {
                System.out.print(e);
            }
        }
    }
    
}

/*
Things to do:
-find a way to close the PDFs after clicking y/n
-make it generic and not only kurtosis/skewness
*/
