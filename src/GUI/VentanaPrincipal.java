package GUI;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class VentanaPrincipal extends JFrame {

    
    public void mostrar() {
        setTitle("Calculadora de Probabilidades");
        
        setSize(400, 300);
        setLocation(800, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
