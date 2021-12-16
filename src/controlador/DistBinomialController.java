package controlador;
import Funciones.*;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DistBinomialController extends ventanaController {
  DistribucionBinomial db;
  int x, n;
  double p; 
  DecimalFormat df;
  
  @FXML private Button btnVolver;
  @FXML private Button btnCalcular;
  @FXML private TextField txtX;
  @FXML private TextField txtN;
  @FXML private TextField txtP;
  @FXML private Button btnLimpiar;
  @FXML private Label lblMsgX;
  @FXML private Label lblMsgN;
  @FXML private Label lblMsgP;
  
  @FXML 
  private void calcular(ActionEvent event) {
 
    limpiarResultados();
    
    if(validarCampos()){ //Validar campos antes de isntanciar la dist. de v.a
      db = new DistribucionBinomial(x,n,p);
      
      mostrarResultados(db);
      graficar(db, n-3);//distribucón y limite superior del dominio
    }
  }
 
  @FXML
   private void  limpiar(){
    txtX.setText(null);
    txtN.setText(null);
    txtP.setText(null); 
     
    lblMsgX.setText(null);
    lblMsgN.setText(null);
    lblMsgP.setText(null); 
    
    limpiarResultados();
   }
  
  public boolean  validarCampos(){ 
    boolean valido = true;
    lblMsgX.setText(null);
    lblMsgN.setText(null);
    lblMsgP.setText(null); 
   
    if(!txtX.getText().isEmpty()){ //Validandoo x
      try{
        x = Integer.parseInt(txtX.getText());
      }catch(NumberFormatException e){
        lblMsgX.setText("Formato inválido."); valido = false;
      } 
    }else{
      lblMsgX.setText("Campo obligatorio.");
    }
    
    if(!txtN.getText().isEmpty()){ //Validando n
      try{
        n = Integer.parseInt(txtN.getText());
      }catch(NumberFormatException e){
         lblMsgN.setText("Formato inválido."); valido = false;
      }
      if(n<0){
         lblMsgN.setText("n ≥ 0"); valido = false;
      }
    }else{
      lblMsgN.setText("Campo obligatorio.");  valido = false;
    }
    
    if(!txtP.getText().isEmpty()){ //Validando p
      try{
        p = Double.parseDouble(txtP.getText());
      }catch(NumberFormatException e){
         lblMsgP.setText("Formato inválido."); valido = false;
      }
      if(!(0<=p && p <=  1)){
         lblMsgP.setText("0 <= p <=1"); valido = false;
      }
    }else{
      lblMsgP.setText("Campo obligatorio.");  valido = false;
    }
    //Necesario comprobar después ya que debemos estar seguros de que n es válido
    if(valido){ //Si no hay errores de formato
      if(!(0 <= x && x <= n)){ // x entre 0 y n
        lblMsgX.setText("0 ≤ x ≤ n"); valido = false;
      } 
    }
    
    return valido; //true si todo está bien
  }
}