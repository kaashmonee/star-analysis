/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.staranalysis;

/**
 *
 * @author skanda
 */
public class Star {
    private String name;
    private double kurtosis;
    private double skewness;
    private double FWHM;
    private double CW;
    private String spectralType;
    private double extinction;
    public Star(String name, double kurtosis, double skewness, double FWHM, double CW, String ST, double extinction){
        this.name=name;
        this.kurtosis=kurtosis;
        this.skewness=skewness;
        this.FWHM=FWHM;
        this.CW=CW;
        spectralType=ST;
        this.extinction=extinction;
    }
    
    public String getName() {return name;}
    
    public double kurtosis() {return kurtosis;}
    
    public double skewness() {return skewness;}
    
    public double FWHM() {return FWHM;}
    
    public double CW() {return CW;}
    
    public String getType() {return spectralType;}
    
    public double getExtinction() {return extinction;}
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name+"    Kurtosis: "+kurtosis+"    Skewness: "+skewness+"    FWHM: "+FWHM+"    CW: "+CW;
    }
}
