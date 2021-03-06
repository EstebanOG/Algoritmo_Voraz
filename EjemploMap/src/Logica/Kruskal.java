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
    private double costo, distancia, penalizacion;
    private CalcularDistancias cDistancias;
    private ArrayList<ParejasPoblaciones> parejasDePoblaciones = new ArrayList<>();
    private ArrayList<ParejasPoblaciones> parejasSolucion = new ArrayList<>();

    public Kruskal(String[][] matrizDatos) {
        
        this.matrizDatos = matrizDatos;
        
        // Se crea cola de prioridad y se organiza de menor a mayor costo
        q = new PriorityQueue(100, new Comparator<ParejasPoblaciones>() {
            @Override
            public int compare(ParejasPoblaciones o1, ParejasPoblaciones o2) {
                int r = 0;
                if (o1.getCosto() > o2.getCosto()) {
                    r = 1;
                } else if (o1.getCosto() < o2.getCosto()) {
                    r = -1;
                }
                return r;
            }
        });
        
        // Se llena ArrayList de parejasDePoblaciones
        cDistancias = new CalcularDistancias();
        for (int i = 0; i < matrizDatos.length; i++) {
            for (int j = 0; j < matrizDatos.length; j++) {

                if (i != j && j > i) {
                    distancia = cDistancias.calcularDistancia(Double.parseDouble(matrizDatos[i][3]),
                            Double.parseDouble(matrizDatos[i][2]), Double.parseDouble(matrizDatos[j][3]),
                            Double.parseDouble(matrizDatos[j][2]));
                    
                    parejasDePoblaciones.add(new ParejasPoblaciones(i, j, distancia));

                }

            }
        }

        //imprimirParejas(parejasDePoblaciones);
        llenarColaPrioridad();
        obtenerSolucion();
    }

    private void imprimirParejas(ArrayList<ParejasPoblaciones> arrayParejas) {

        System.out.println(arrayParejas.size());
        for (ParejasPoblaciones pa : arrayParejas) {
            System.out.println("Co1:" + pa.getPoblacion1());
            System.out.println("Co2:" + pa.getPoblacion2());
            System.out.println("Costo:" + pa.getCosto());
        }
    }

    private void llenarColaPrioridad() {

        for (ParejasPoblaciones pa : parejasDePoblaciones) {
            q.add(pa);
        }
//        System.out.println("Cola:");
//        for(ParejasPoblaciones pa: q){
//            System.out.println("Co1:"+pa.getPoblacion1());
//            System.out.println("Co2:"+pa.getPoblacion2());
//            System.out.println("Costo:"+pa.getCosto());
//        }
    }

    private void obtenerSolucion() {
        // Algorimo Kruskal
        for (int indx = 0; indx < matrizDatos.length; indx++) {

            HashSet e = new HashSet<Integer>();
            e.add(indx);
            sets.add(e);

        }
        
        ParejasPoblaciones paTemp = new ParejasPoblaciones();
        int a = 0, b = 0, c = 0, ind = 0;
        while (sets.size() != 1) {

            paTemp = q.remove();
            for (HashSet f : sets) {
                if (f.contains(paTemp.getPoblacion1())) {
                    a = ind;
                }

                if (f.contains(paTemp.getPoblacion2())) {
                    b = ind;
                }
                ind++;
            }
            ind = 0;
            if (a == b) {
            } else {
                parejasSolucion.add(paTemp);
                sets.get(a).addAll(sets.get(b));
                sets.remove(b);
            }
            a = 0;
            b = 0;
        }
        System.out.println("Soluci??n grafo");
        for (ParejasPoblaciones pa : parejasSolucion) {
            System.out.println("[" + pa.getPoblacion1() + "][" + pa.getPoblacion2() + "]");
        }
    }

}
