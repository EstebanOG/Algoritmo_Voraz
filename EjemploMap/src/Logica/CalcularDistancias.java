/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class CalcularDistancias {

    private String[][] matrizDatos;

    private double earthRadius = 6371, lon1, lat1,
            lon2, lat2; // kms
    private Double[] coordenadasTota;

    public CalcularDistancias(String[][] matrizDatos) {

        coordenadasTota = new Double[2];
        coordenadasTota[0] = Double.parseDouble(matrizDatos[0][2]);
        coordenadasTota[1] = Double.parseDouble(matrizDatos[0][3]);

        int fila = matrizDatos.length, i = 0, j = 0;
        for (i = 0; i < fila; i++) {
            lat1 = Math.toRadians(coordenadasTota[0]);
            lon1 = Math.toRadians(coordenadasTota[1]);
            lat2 = Math.toRadians(Double.parseDouble(matrizDatos[i][2]));
            lon2 = Math.toRadians(Double.parseDouble(matrizDatos[i][3]));
            double dlon = (lon2 - lon1);
            double dlat = (lat2 - lat1);

            double sinlat = Math.sin(dlat / 2);
            double sinlon = Math.sin(dlon / 2);

            double a = (sinlat * sinlat) + Math.cos(lat1) * Math.cos(lat2) * (sinlon * sinlon);
            //double c = 2 * Math.asin(Math.min(1.0, Math.sqrt(a)));
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
             

            double distanceInMeters = earthRadius * c;
            
            matrizDatos[i][4] =  distanceInMeters + "";
        }

        this.matrizDatos = matrizDatos;
    }
    
    public String[][] getMatrizDatos() {
        return matrizDatos.clone();
    }

    public void setMatrizDatos(String[][] matrizDatos) {
        this.matrizDatos = matrizDatos;
    }

}
