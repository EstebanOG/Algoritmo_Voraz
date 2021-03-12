/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class VistaPrincipal extends JFrame implements ActionListener {

    private JPanel pPrincipal;
    private PanelTabla tabla;
    private PanelMapa mapa;
    private JButton btnMostrarMapa, btnAgregarPoblacion;

    public VistaPrincipal() {
        this.setTitle("Tendido de tuberia: Laguna de Tota");
        this.setBounds(700, 0, 600, 700);
        this.setLayout(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    
        initComponents();
    }

    private void initComponents() {
        
        // Panel principal
        pPrincipal = new JPanel();
        pPrincipal.setBounds(0, 0, 600, 660);
        pPrincipal.setLayout(null);
        this.getContentPane().add(pPrincipal);

        // Botón mostrar mapa
        btnMostrarMapa = new JButton();
        btnMostrarMapa.setText("Mostrar mapa");
        btnMostrarMapa.setBounds(10, 10, 115, 40);
        btnMostrarMapa.addActionListener(this);
        pPrincipal.add(btnMostrarMapa);

        // Botón agregar población
        /*
        btnAgregarPoblacion = new JButton();
        btnAgregarPoblacion.setText("Agregar población");
        btnAgregarPoblacion.setBounds(140, 10, 140, 40);
        pPrincipal.add(btnAgregarPoblacion);*/
        
        // Panel tabla
        tabla = new PanelTabla();
        pPrincipal.add(tabla);
        tabla.setVisible(false);
        tabla.setVisible(true);
        
        pPrincipal.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Se verifica el botón que activa el evento
        if (e.getSource() == btnMostrarMapa) {
            mapa = new PanelMapa();
            mapa.ubicarPoblaciones(tabla.getMatrizDatos());
            mapa.setVisible(true);
        }else{
            // Lógica botón agregar población
        }

    }

}
