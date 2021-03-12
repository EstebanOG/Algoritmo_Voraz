/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logica.CalcularDistancias;
import Logica.Kruskal;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class PanelTabla extends JPanel {

    private JScrollPane scrollPane;
    private JTable table;
    private Kruskal kruskal;
    private DefaultTableModel dtm;
    public static String[][] matrizDatos;
    private CalcularDistancias calDistancias = null;

    public PanelTabla() {

        // Datos de las poblaciones
        String[] nombresColumnas = {"Poblacion", "Altura", "Latitud", "Longitud", "Distancia", "Penalización", "Costo"};
        String[][] datos = {
            {"TOTA", "3015", "5.5378", "-72.9307", "N.R", "N.R", "N.R"},
            {"CHAMEZA", "1110", "5.217", "-72.883", "N.R", "N.R", "N.R"},
            {"FIRAVITOBA", "2500", "5.66877", "-72.994", "N.R", "N.R", "N.R"},
            {"PAIPA", "2525", " 5.77894", "-73.1185", "N.R", "N.R", "N.R"},
            {"DUITAMA", "2530", "5.817", "-73.033", "N.R", "N.R", "N.R"},
            {"TIBASOSA", "2538", "5.74615", "-73.0011", "N.R", "N.R", "N.R"},
            {"IZA", "2560", "5.6125", "-72.978611111111", "N.R", "N.R", "N.R"},
            {"SOGAMOSO", "2569", "5.7158333333333", "-72.933333333333", "N.R", "N.R", "N.R"},
            {"NOBSA", "2593", "5.7697222222222", "-72.94", "N.R", "N.R", "N.R"},
            {"CUITIVA", "2750", "5.5802", "-72.9664", "N.R", "N.R", "N.R"},
            {"MONGUI", "2900", "5.7256", "-72.8498", "N.R", "N.R", "N.R"},
            {"AQUITANIA", "3030", "5.5202", "-72.8837", "N.R", "N.R", "N.R"},
            {"PESCA", "3910", "5.5587", "-73.0502", "N.R", "N.R", "N.R"}};

        this.dtm = new DefaultTableModel(datos, nombresColumnas);
        table = new JTable(dtm);
        table.setPreferredScrollableViewportSize(new Dimension(530, 400));
        convertirAMatriz();
        calcularDistanciasCostos();
        crearParejas();
        //imprimirMatriz();
        scrollPane = new JScrollPane(table);
        this.add(scrollPane);
        this.setBounds(0, 90, 600, 500);
        this.setVisible(true);
    }

    public void agregarPoblacion(String nuevaPoblacion) {
        // Agregar nueva fila
        Object[] newRow = {"Maria", 55, false};
        dtm.addRow(newRow);
    }

    private void convertirAMatriz() {
        
        // Convertir los datos a una matriz de String
        matrizDatos = new String[table.getRowCount()][table.getColumnCount()];
        int fila1 = table.getRowCount();
        int col1 = table.getColumnCount();
        int i, j;

        for (i = 0; i < fila1; i++) {
            for (j = 0; j < col1; j++) {
//                System.out.println(i);
//                System.out.println(j);
                matrizDatos[i][j] = (String) table.getValueAt(i, j);
            }
        }

    }
    
    private void imprimirMatriz(){
        // Imprimir matriz de datos.
        int fila = table.getRowCount(), columna = table.getColumnCount(), i = 0, j = 0;
        for (i = 0; i < fila; i++) {
            for (j = 0; j < columna; j++) {
                System.out.println(matrizDatos[i][j]);
            }
        }
    }
    
    private void calcularDistanciasCostos(){
        // Se calcula distancia con la laguna
        if(calDistancias == null){
            calDistancias = new CalcularDistancias(matrizDatos.clone());
            this.matrizDatos = calDistancias.getMatrizDatos();
            actualizarTable();
        }else{
            calDistancias.setMatrizDatos(matrizDatos.clone());
            this.matrizDatos = calDistancias.getMatrizDatos();
            actualizarTable();
        }
    }
    
    private void actualizarTable(){
        //Se actualiza la tabla con las nuevas distancias
        int fila = table.getRowCount(), i = 0, j = 0;
        double distancia = 0;
        for (i = 0; i < fila; i++) {
            table.setValueAt(matrizDatos[i][4], i, 4);
            if(Double.parseDouble(matrizDatos[i][1])<= Double.parseDouble(matrizDatos[0][1])){
                matrizDatos[i][5] = 0+"";
                table.setValueAt(matrizDatos[i][5], i, 5);
                
                matrizDatos[i][6] = matrizDatos[i][4];
                table.setValueAt(matrizDatos[i][6], i, 6);
            }
        }
        //imprimirMatriz();
    }
    
    private void crearParejas(){
       kruskal = new Kruskal(matrizDatos);
    }
    public String[][] getMatrizDatos() {
        return matrizDatos;
    }

    public void setMatrizDatos(String[][] matrizDatos) {
        this.matrizDatos = matrizDatos;
    }
    
    
}
