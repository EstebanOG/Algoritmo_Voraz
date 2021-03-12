/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 *
 * @author Usuario
 */
public class Kruskal {
    
    private ArrayList<HashSet<Integer>> sets = new ArrayList<HashSet<Integer>>();
    private String[][] matrizDatos;
    private PriorityQueue<ParejasPoblaciones> q;
    private double costo;
    private CalcularDistancias cDistancias;
    private ArrayList<ParejasPoblaciones> parejasDePoblaciones = new ArrayList<>();
    private ArrayList<ParejasPoblaciones> parejasSolucion = new ArrayList<>();
    public Kruskal(String[][] matrizDatos) {
        q = new PriorityQueue(100,new Comparator<ParejasPoblaciones>() {
            @Override
            public int compare(ParejasPoblaciones o1, ParejasPoblaciones o2) {
                int r = 0;
                if(o1.getCosto() > o2.getCosto()){
                    r = 1;
                }else if (o1.getCosto() < o2.getCosto()){
                    r = -1;
                }
                return r;
            }
        });
        this.matrizDatos = matrizDatos;
        cDistancias = new CalcularDistancias();
        for (int i = 0; i < matrizDatos.length; i++) {
            for (int j = 0; j < matrizDatos.length; j++) {
                
                    if (i != j && j>i) {
                        costo = cDistancias.calcularDistancia(Double.parseDouble(matrizDatos[i][2]),
                                Double.parseDouble(matrizDatos[i][1]), Double.parseDouble(matrizDatos[j][2]), 
                                Double.parseDouble(matrizDatos[j][1]));
                        parejasDePoblaciones.add(new ParejasPoblaciones(i, j, costo));

                    }
                
            }
        }
        
        //imprimirParejas();
        llenarColaPrioridad();
        obtenerSolucion();
    }    
    
    private void imprimirParejas(){
        
        System.out.println(parejasDePoblaciones.size());
        for(ParejasPoblaciones pa: parejasDePoblaciones){
            System.out.println("Co1:"+pa.getPoblacion1());
            System.out.println("Co2:"+pa.getPoblacion2());
            System.out.println("Costo:"+pa.getCosto());
        }
    }
    
    private void llenarColaPrioridad(){
        
        for(ParejasPoblaciones pa: parejasDePoblaciones){
            q.add(pa);
        }
//        System.out.println("Cola:");
//        for(ParejasPoblaciones pa: q){
//            System.out.println("Co1:"+pa.getPoblacion1());
//            System.out.println("Co2:"+pa.getPoblacion2());
//            System.out.println("Costo:"+pa.getCosto());
//        }
    }
    
    private void obtenerSolucion(){
        //int indx = 0;
        for (int indx = 0; indx<matrizDatos.length;indx++) {
            
                //System.out.println(indx);
                HashSet e = new HashSet<Integer>();
                e.add(indx);
                sets.add(e);
                
            
        }
        //System.out.println(sets);
        ParejasPoblaciones paTemp = new ParejasPoblaciones();
        int a = 0, b = 0, c = 0, ind = 0;
        while (sets.size() != 1) {

            paTemp = q.remove();
            //System.out.println(paTemp.getPoblacion1());
            //System.out.println(paTemp.getPoblacion2());
            for (HashSet f : sets) {
                if (f.contains(paTemp.getPoblacion1())) {
                    a = ind;
                    //System.out.println("Primer if");
                }

                if (f.contains(paTemp.getPoblacion2())) {
                    b = ind;
                    //System.out.println("Segundo if");
                }
                ind++;
            }
            ind = 0;
            //System.out.println("a:" + a + " b:" + b);
            if (a == b) {
                //parejasSolucion.add(paTemp);
                //System.out.println("Iguales");
            } else {
                parejasSolucion.add(paTemp);
                sets.get(a).addAll(sets.get(b));
                sets.remove(b);
            }
            //System.out.println(sets);
            //System.out.println("a:" + a + " b:" + b);
            a = 0;
            b = 0;
        }
//        System.out.println("paSol:" + parejasSolucion);
        System.out.println("Solución grafo");
        for(ParejasPoblaciones pa: parejasSolucion){
            System.out.println("["+pa.getPoblacion1()+"]["+pa.getPoblacion2()+"]");
//            System.out.println("Co2:"+pa.getPoblacion2());
//            System.out.println("Costo:"+pa.getCosto());
        }
    }
    
    
    
    
}
