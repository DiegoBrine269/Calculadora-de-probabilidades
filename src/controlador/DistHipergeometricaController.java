package controlador;

import Funciones.DistribucionHipergeometrica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class DistHipergeometricaController extends ventanaController {

  int x, k, N, n;
  DistribucionHipergeometrica dh;

  @FXML private Button btnCalcular;
  @FXML private Button btnLimpiar;
  @FXML private Button btnVolver;
  @FXML private TextField txtX;
  @FXML private TextField txtNMay;
  @FXML private TextField txtNMin;
  @FXML private Label lblMsgX;
  @FXML private Label lblMsgNMay;
  @FXML private Label lblMsgNMin;
  @FXML private TextField txtK;
  @FXML private Label lblMsgK;
    
  @FXML
  private void calcular(ActionEvent event) {
    limpiarResultados();
    
    if(validarCampos()) {
      dh = new DistribucionHipergeometrica(x, N, n, k);
      mostrarResultados(dh);
      graficar(dh, x);
    }
  }

  @FXML
  private void limpiar(ActionEvent event) {
    txtX.setText(null); //Limpia Entradas
    txtNMay.setText(null);
    txtNMin.setText(null);
    txtK.setText(null);
    
    lblMsgX.setText(null); //Limpia mensajes de errores
    lblMsgNMay.setText(null);
    lblMsgNMin.setText(null);
    lblMsgK.setText(null);
    
    limpiarResultados();
  }

    private boolean validarCampos() {
      
        boolean valido = true;
        
      lblMsgX.setText(null); //Limpia mensajes de errores
      lblMsgNMay.setText(null);
      lblMsgNMin.setText(null);
      lblMsgK.setText(null);

        //Comprobando que no hayan campos vacíos
        if( txtX.getText().isEmpty() ){
            lblMsgX.setText("Campo obligatorio");
            valido = false; 
        }
        
        if( txtNMay.getText().isEmpty() ){
            lblMsgNMay.setText("Campo obligatorio");
            valido = false; 
        }
        
        if( txtNMin.getText().isEmpty() ){
            lblMsgNMin.setText("Campo obligatorio");
            valido = false; 
        }
        
        if( txtK.getText().isEmpty() ){
            lblMsgK.setText("Campo obligatorio");
            valido = false; 
        }

        
        //Comprobando que las entradas sean numéricas
        try {
            x = Integer.parseInt(txtX.getText());
        }
        catch (NumberFormatException e){
            valido = false; 
            lblMsgX.setText("Entrada no válida");
        }

        try {
            N = Integer.parseInt(txtNMay.getText()); 
        }
        catch (NumberFormatException e){
            valido = false;
            lblMsgNMay.setText("Entrada no válida");
        }

        try {
            n = Integer.parseInt(txtNMin.getText());
        }
        catch (NumberFormatException e){
            valido = false;
            lblMsgNMin.setText("Entrada no válida");
        }

        try {
            k = Integer.parseInt(txtK.getText());
        }
        catch (NumberFormatException e){
            valido = false;
            lblMsgK.setText("Entrada no válida");
        }
        
        //Validando rangos en los que se encuentran las entradas
        if ( valido ) {
            if( x < Math.max(0, n - (N - k)) || x > Math.min(n, k) ){
                lblMsgX.setText("máx{0,n-(N-K)} ≤ x ≤ mín{n,K}");
                valido = false; 
            }
            
            if(k<0 || k>N){
              lblMsgK.setText("0 ≤ K ≤ N");
              valido = false; 
            }
            
            if(n< 0 || n>N){
              lblMsgNMin.setText("0 ≤ n ≤ N");
              valido = false; 
            }
        }
        
        return valido;
    }
}
