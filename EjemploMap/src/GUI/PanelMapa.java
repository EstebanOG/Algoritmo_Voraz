/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author Usuario
 */
public class PanelMapa extends JFrame{

    public PanelMapa() {
        
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
            // Close Engine and onClose app window
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            
            this.add(view);
            this.setBounds(0, 0, 600, 500);
            this.setVisible(false);
            this.setTitle("Mapa");
            browser.navigation().loadUrl("C://Users/Usuario/Desktop/Algoritmo_Voraz/EjemploMap/src/tuberiaLagunaTota/map.html");
        });
    }

}
