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
public class CalcularDistancias {

    private String[][] matrizDatos;

    private double earthRadius = 6371, lon1, lat1,
            lon2, lat2, penalizacion,alturaTota;
    private Double[] coordenadasTota;
    
    public CalcularDistancias(){
        
    }
    public CalcularDistancias(String[][] matrizDatos) {

        coordenadasTota = new Double[2];
        coordenadasTota[0] = Double.parseDouble(matrizDatos[0][2]);
        coordenadasTota[1] = Double.parseDouble(matrizDatos[0][3]);
        
        this.alturaTota = Double.parseDouble(matrizDatos[0][1]);
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

            matrizDatos[i][4] = distanceInMeters + "";
        }

        this.matrizDatos = matrizDatos;
    }

    public double calcularDistancia(double lon1, double lat1,
            double lon2, double lat2) {

        double earthRadius = 6371; // km

        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double dlon = (lon2 - lon1);
        double dlat = (lat2 - lat1);

        double sinlat = Math.sin(dlat / 2);
        double sinlon = Math.sin(dlon / 2);

        double a = (sinlat * sinlat) + Math.cos(lat1) * Math.cos(lat2) * (sinlon * sinlon);
        //double c = 2 * Math.asin(Math.min(1.0, Math.sqrt(a)));

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distanceInMeters = earthRadius * c;
        
        return distanceInMeters;

    }
    
    public double calcularPenalizacion(double alturaPoblacion, double distancia){
        
        penalizacion = (distancia*5/100) * (alturaPoblacion - alturaTota);
        return penalizacion;
    }
    
    public double calcularCosto(double distancia, double penalizacion){
        return distancia + penalizacion;
    }
    
    public String[][] getMatrizDatos() {
        return matrizDatos.clone();
    }

    public void setMatrizDatos(String[][] matrizDatos) {
        this.matrizDatos = matrizDatos;
    }

}
