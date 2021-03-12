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

    private int filas, columnas = 7;
    private double earthRadius = 6371, lon1, lat1,
            lon2, lat2; // kms
    private Double[] coordenadasTota;

    public CalcularDistancias(String[][] matrizDatos) {

        //this.columnas = matrizDatos[0].length;
        coordenadasTota = new Double[2];
        coordenadasTota[0] = Double.parseDouble(matrizDatos[0][2]);
        coordenadasTota[1] = Double.parseDouble(matrizDatos[0][3]);
        System.out.println(Arrays.toString(coordenadasTota));
        //calculateDistanceByHaversineFormula();

        int fila = matrizDatos.length, i = 0, j = 0;
        for (i = 0; i < fila; i++) {
            lat1 = Math.toRadians(coordenadasTota[0]);
            lon1 = Math.toRadians(coordenadasTota[0]);
            lat2 = Math.toRadians(Double.parseDouble(matrizDatos[i][2]));
            lon2 = Math.toRadians(Double.parseDouble(matrizDatos[i][3]));
            double dlon = (lon2 - lon1);
            double dlat = (lat2 - lat1);

            double sinlat = Math.sin(dlat / 2);
            double sinlon = Math.sin(dlon / 2);

            double a = (sinlat * sinlat) + Math.cos(lat1) * Math.cos(lat2) * (sinlon * sinlon);
            double c = 2 * Math.asin(Math.min(1.0, Math.sqrt(a)));

            double distanceInMeters = earthRadius * c * 1000;
            
            matrizDatos[i][4] = (int) distanceInMeters + "";
        }

        this.matrizDatos = matrizDatos;
    }

    private static int calculateDistanceByHaversineFormula(double lon1, double lat1,
            double lon2, double lat2) {
        //double earthRadius = 6371; // kms
//        for (i = 0; i < fila; i++) {
//            for (j = 0; j < columna; j++) {
//                System.out.println(matrizDatos[i][j]);
//            }
//        }

        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

//        double dlon = (lon2 – lon1
//        );
//    double dlat = (lat2 – lat1
//        );
//
//    double sinlat = Math.sin(dlat / 2);
//        double sinlon = Math.sin(dlon / 2);
//
//        double a = (sinlat * sinlat) + Math.cos(lat1) * Math.cos(lat2) * (sinlon * sinlon);
//        double c = 2 * Math.asin(Math.min(1.0, Math.sqrt(a)));
//
//        double distanceInMeters = earthRadius * c * 1000;
//
//        return (int) distanceInMeters;
        return 0;

    }

    public String[][] getMatrizDatos() {
        return matrizDatos.clone();
    }

    public void setMatrizDatos(String[][] matrizDatos) {
        this.matrizDatos = matrizDatos;
    }

}
