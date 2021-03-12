/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Usuario
 */
public class ParejasPoblaciones {
    private int poblacion1, poblacion2;
    private double costo;
    public ParejasPoblaciones(){
        
    }
    
    public ParejasPoblaciones(int poblacion1, int poblacion2, double costo){
        this.poblacion1 = poblacion1;
        this.poblacion2 = poblacion2;
        this.costo = costo;
    }

    public int getPoblacion1() {
        return poblacion1;
    }

    public void setPoblacion1(int poblacion1) {
        this.poblacion1 = poblacion1;
    }

    public int getPoblacion2() {
        return poblacion2;
    }

    public void setPoblacion2(int poblacion2) {
        this.poblacion2 = poblacion2;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
}
