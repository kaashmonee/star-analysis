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
    
        static String starName;
        static double kurtosis;
        static double skewness;
        static double FWHM;
        static double CW;
        static double extinction;
        static String spectralType;
        static Scanner sc=new Scanner(System.in);
        static String DIB;
        static double equivalentWidth;
        static BufferedReader r= new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        
        boolean thereMore=true;
        
        boolean firstTime=true;
        String yn = "";
        String notes = "";
        ArrayList<Star> starList=new ArrayList<>();
        Console console=System.console();
        
        int fileNum=0;
        
        while (thereMore){
        if (firstTime) {
        System.out.print("Please enter the starting index: ");
        fileNum=Integer.parseInt(r.readLine());
        openPDF(fileNum-=1);
        }
        else {openPDF(fileNum);}
        
        init(); //initializes everything and gets data
        
        
        Star s=new Star(starName, kurtosis, skewness, FWHM, CW, spectralType, extinction);
        starList.add(s);
        String line;
        try  {
            PrintWriter writer;
            writer = new PrintWriter("Stars/"+s.getName()+".txt","UTF-8");
            writer.println("Star name: "+s.getName());
            writer.println("Spectral Type: "+s.getType());
            writer.println("E(B-V): "+s.getExtinction());
            writer.println("DIB: "+DIB);
            writer.println("Equivalent Width: "+equivalentWidth);
            writer.println("Skewness R:(-0.11,0.55): "+s.skewness());
            writer.println("Kurtosis R:(-0.73,0.36): "+s.kurtosis());
            writer.println("FWHM: "+s.FWHM());
            writer.println("Central Wavelength: "+s.CW());
            writer.println("\nNOTES:");
            while (true) {  
            line=r.readLine();
            if(line.equals("DONE")) break;
            else
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
        firstTime=false;
        }
        PrintWriter writer2=new PrintWriter(new FileOutputStream(new File("Stars/StarsDone.txt"), true));
        for (Star star: starList) {
            writer2.append("\n"+star.toString());
        }
        writer2.close();
               
        
    }
    
    private static void openPDF(int val) {
        if (Desktop.isDesktopSupported()) {
            File hiResFolder= new File("hires");
            String [] hiFiles=hiResFolder.list();
            hiFiles=alphabetize(hiFiles);
            
            File lowResFolder= new File("lowres"); 
            String [] lowFiles=lowResFolder.list();
            lowFiles=alphabetize(lowFiles);
            
            try {
                if (val<hiFiles.length) {
                File hiFile= new File("hires/"+hiFiles[val]);
                Desktop.getDesktop().open(hiFile);
                }
                else {
                    System.out.println("No more files in high resolution folder.");
                }
                if (val<lowFiles.length) {
                File lowFile=new File("lowres/"+lowFiles[val]); 
                
                Desktop.getDesktop().open(lowFile);
                }
                else {
                    System.out.println("No more files in low resolution folder.");
                }
            }
            catch (Exception e) {
                System.out.print(e);
            }
        }
    }
    
    private static String [] alphabetize (String [] Array) {
        for(int j=0; j<Array.length;j++)
        {
             for (int i=j+1 ; i<Array.length; i++)
             {
                if(Array[i].substring(1,2).compareTo(Array[j].substring(1,2))<0)
                {
                 String temp= Array[j];
                 Array[j]= Array[i]; 
                 Array[i]=temp;
                }
        }
    }
        return Array;
    }
    
    private static void init () throws IOException {
        System.out.print("\nPlease enter the star name: ");
        starName=r.readLine();
        System.out.print("\nPlease enter spectral type: ");
        spectralType=r.readLine();
        System.out.print("\nE(B-V): ");
        extinction=sc.nextDouble();
        System.out.print("\nFor what DIB? ");
        DIB=r.readLine();
        System.out.print("\nEquivalent Width (A): ");
        equivalentWidth=sc.nextDouble();
        System.out.print("\nKurtosis: ");
        kurtosis=sc.nextDouble();
        System.out.print("\nSkewness: ");
        skewness=sc.nextDouble();
        System.out.print("\nFull Width at Half Max: ");
        FWHM=sc.nextDouble();
        System.out.print("\nCentral Wavelength: ");
        CW=sc.nextDouble();
        System.out.println("\n");
        System.out.print("\nNotes:");
    }

}
/*
Things to do:
-find a way to close the PDFs after clicking y/n **very necessary for convenience sake
-make it generic and not only kurtosis/skewness
-possibly delete skewness and kurtosis parameters? you have to look at the spreadsheet anyway
-find a way to append things to the StarsDone file
*/
