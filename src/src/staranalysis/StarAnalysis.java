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
        System.out.print("Please enter the starting index: ");
        fileNum=Integer.parseInt(r.readLine());
        openPDF(fileNum-1);
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
            while ((line=r.readLine())!="DONE") {       
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
            writer2.println(star);
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

}
/*
Things to do:
-find a way to close the PDFs after clicking y/n **very necessary for convenience sake
-make it generic and not only kurtosis/skewness
-possibly delete skewness and kurtosis parameters? you have to look at the spreadsheet anyway
-find a way to append things to the StarsDone file
*/
