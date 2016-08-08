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
    public Star(String name, double kurtosis, double skewness){
        this.name=name;
        this.kurtosis=kurtosis;
        this.skewness=skewness;
    }
    
    public String getName() {return name;}
    
    public double kurtosis() {return kurtosis;}
    
    public double skewness() {return skewness;}
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name+"    Kurtosis: "+kurtosis+"    Skewness: "+skewness;
    }
}
