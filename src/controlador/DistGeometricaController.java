package controlador;

import modelo.DistribucionGeometrica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DistGeometricaController extends ventanaController {
    int x;
    Double p;
    DistribucionGeometrica dg;
    
    @FXML private Button btnCalcular;
    @FXML private Button btnLimpiar;
    @FXML private Button btnVolver;
    @FXML private TextField txtX;
    @FXML private TextField txtP;
    @FXML private Label lblMsgX;
    @FXML private Label lblMsgP;
    
    @FXML
    private void calcular(ActionEvent event) {
      limpiarResultados();
        if(validarCampos()) {
            dg = new DistribucionGeometrica(x, p);     
            mostrarResultados(dg);
            graficar(dg, x);
        }
    }   

  @FXML
  private void limpiar(ActionEvent event) {
    txtX.clear();
    txtP.clear();
    
    lblMsgX.setText(null);
    lblMsgP.setText(null);

    limpiarResultados();
  }

  
    private boolean validarCampos(){

        boolean valido = true;
        
        lblMsgX.setText(null);
        lblMsgP.setText(null);
        
        //Validamos que los campos no se encuentren vacíos
        if ( txtX.getText().isEmpty()) {
            lblMsgX.setText("Campo obligatorio");
            valido = false;
        }

        if( txtP.getText().isEmpty() ){
            lblMsgP.setText("Campo obligatorio");           
            valido = false;
        }

        //Validando x
        try {
            if(Integer.parseInt( txtX.getText()) < 1  ) {   
                lblMsgX.setText("x ≥ 1");
                valido = false;
            }
        }
        catch(NumberFormatException e){
                lblMsgX.setText("Entrada no válida");
                valido = false;
        }
        
        //Validando p
        try{         
            if( Double.parseDouble(txtP.getText()) < 0 || Double.parseDouble(txtP.getText()) > 1 )
            {   
                lblMsgP.setText("0 ≤ p ≤ 1");
                valido = false;
            }   
        }
        catch(NumberFormatException e){
            lblMsgP.setText("Entrada no válida");
            valido = false;
        } 
        
        //Si todo salió bien, asignamos las variables x y p
        if(valido){
            x = Integer.parseInt(txtX.getText());
            p = Double.parseDouble(txtP.getText());
        }
        
        return valido;
    }
}
