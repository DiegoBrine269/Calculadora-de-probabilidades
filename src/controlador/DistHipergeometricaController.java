package controlador;

import Funciones.DistribucionHipergeometrica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class DistHipergeometricaController extends ventanaController {

    int x, k, N, n;
    DistribucionHipergeometrica dh;

    @FXML
    private Button btnCalcular;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnVolver;
    @FXML
    private TextField txtX;
    @FXML
    private TextField txtNMay;
    @FXML
    private TextField txtNMin;
    @FXML
    private Label lblMsgX;
    @FXML
    private Label lblMsgNMay;
    @FXML
    private Label lblMsgNMin;
    @FXML
    private TextField txtK;
    @FXML
    private Label lblMsgK;
    
    @FXML
    private void calcular(ActionEvent event) {
        if( validarCampos() ) {
            dh = new DistribucionHipergeometrica(x, N, n, k);
            mostrarResultados(dh);
            graficar(dh, n);
        }
    }

    @FXML
    private void limpiar(ActionEvent event) {
        limpiarResultados();
    }

    private boolean validarCampos() {
        boolean valido = true;

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
        catch (Exception e){
            valido = false; 
            lblMsgX.setText("Entrada no válida");
        }

        try {
            N = Integer.parseInt(txtNMay.getText()); 
        }
        catch (Exception e){
            valido = false;
            lblMsgNMay.setText("Entrada no válida");
        }

        try {
            n = Integer.parseInt(txtNMin.getText());
        }
        catch (Exception e){
            valido = false;
            lblMsgNMin.setText("Entrada no válida");
        }

        try {
            k = Integer.parseInt(txtK.getText());
        }
        catch (Exception e){
            valido = false;
            lblMsgK.setText("Entrada no válida");
        }
        
        //Validando rangos en los que se encuentran las entradas
        if ( valido ) {
            if( x < Math.max(0, n - (N - k)) || x > Math.min(n, k) ){
                lblMsgX.setText("máx{0, n-(N-k)} <= x <= mín{n, k}");
                valido = false; 
            }
            
            /*if( k < 0 || k > Math.min(n, x) ) {
                lblMsgK.setText("0 >= k >= min{n, x}");
                valido = false; 
            }*/
            
            //Limpiamos los mensajes en caso de que no haya errores
            if(valido){
                lblMsgX.setText("");
                lblMsgNMay.setText("");
                lblMsgNMin.setText("");
                lblMsgK.setText("");
            }
        }
        
        return valido;
    }
}
