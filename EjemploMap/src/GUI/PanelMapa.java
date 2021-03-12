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
import com.teamdev.jxbrowser.js.JsFunction;
import com.teamdev.jxbrowser.js.JsObject;
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
public class PanelMapa extends JFrame {

    private Browser browser;
    private BrowserView view;

    public PanelMapa() {

        // Creating and running Chromium engine
        Engine engine = Engine.newInstance(
                EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                        .licenseKey("6P830J66YB15RY4GK7MQ275RVDVUBC679AS46M985GHXHVVZLV35SBVKMIIQEUH0JHEE")
                        .build());

        browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            // Creating Swing component for rendering web content
            // loaded in the given Browser instance.
            view = BrowserView.newInstance(browser);

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
            this.setVisible(true);
            this.setTitle("Mapa");
            browser.navigation().loadUrl("C://Users/Usuario/Desktop/Algoritmo_Voraz/EjemploMap/src/tuberiaLagunaTota/map.html");

//browser.settings().enableJavaScript();
            //browser.frames().get(0).executeJavaScript(string)
            //executeJavaScript("document.title");
        });
    }

    public void ubicarPoblaciones(String[][] matrizDatos) {
//        for(int i = 0; i < matrizDatos.length;i++){
        System.out.println(matrizDatos[0][2]);
        JsObject document = browser.frames().get(0).executeJavaScript("document");
//        JsObject write = document.asObject().getProperty("write");
//        write.asFunction().invoke(document.asObject(), "<html><body>Hello</body></html>");
//            JsFunction pintar = browser.frames().get(0).executeJavaScript("document");
//            JsObject window = browser.frames().get(0).executeJavaScript("const myLatlng = {lat:"+matrizDatos[0][2]+",lng:"+matrizDatos[0][3]+"};\n" +
//                       "const marker = new google.maps.Marker({\n" +
//                       "    position: myLatlng,\n" +
//                       "    map: map,\n" +
//                       "});");

        //System.out.println(window);
//        }
//    }
    }
}
