/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuberiaLagunaTota;
//import com.teamdev.jxbrowser.browser.Browser;
//import java.awt.BorderLayout;
//import javax.swing.JFrame;
//import javax.swing.WindowConstants;

/**
 *
 * @author Usuario
 */
//public class Mapa {
//    public static void main(String[] args) {
//        System.setProperty("jxbrowser.license.key", "6P830J66YB15RY4GK7MQ275RVDVUBC679AS46M985GHXHVVZLV35SBVKMIIQEUH0JHEEg");
//        Browser browser = BrowserFactory.create();
//        Browser browser = Browser.create();
// 
//        JFrame frame = new JFrame("JxBrowser Google Maps En Java");
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.add(browser.getView().getComponent(), BorderLayout.CENTER);
//        frame.setSize(700, 500);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
// 
//        browser.loadURL("http://maps.google.com");
//    }
//}
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Mapa {

    public static void main(String[] args) {

        // Creating and running Chromium engine
        Engine engine = Engine.newInstance(
        EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("6P830J66YB15RY4GK7MQ275RVDVUBC679AS46M985GHXHVVZLV35SBVKMIIQEUH0JHEE")
                .build());

        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            // Creating Swing component for rendering web content
            // loaded in the given Browser instance.
            BrowserView view = BrowserView.newInstance(browser);

            // Creating and displaying Swing app frame.
            JFrame frame = new JFrame("Hello World");
            // Close Engine and onClose app window
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JTextField addressBar = new JTextField("http://maps.google.com");
            addressBar.addActionListener(e ->
                    browser.navigation().loadUrl(addressBar.getText()));
            frame.add(addressBar, BorderLayout.NORTH);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            browser.navigation().loadUrl("C://Users/Usuario/Desktop/Algoritmo_Voraz/EjemploMap/src/tuberiaLagunaTota/map.html");
        });
    }
}
