package controlador;
import Funciones.DistribucionPoisson;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DistDePoissonController extends ventanaController {
  int x;
  double Lambda;
  DistribucionPoisson dp;
  
  @FXML private Button btnCalcular;
  @FXML private Button btnLimpiar;
  @FXML private Button btnVolver;
  @FXML private TextField txtX;
  @FXML private TextField txtLambda;
  @FXML private Label lblMsgX;
  @FXML private Label lblMsgLambda;

  @FXML
  private void calcular(ActionEvent event) {
    limpiarResultados();
    
    if(validarCampos()){ //Validar campos antes de isntanciar la dist. de v.a
      dp = new DistribucionPoisson (x,Lambda);
      
      mostrarResultados(dp);
      graficar(dp, x);//distribucón y limite superior del dominio
    }
  }

  @FXML
   private void  limpiar(){
    txtX.setText(null); //Limpia entradas
    txtLambda.setText(null);
    
    lblMsgX.setText(null); //Limpia mensajes de error
    lblMsgLambda.setText(null);
    
    limpiarResultados();
   }
  
  public boolean  validarCampos(){
    boolean valido = true;
    lblMsgX.setText(null);
    lblMsgLambda.setText(null);
    
   
    if(!txtX.getText().isEmpty()){ //Validandoo x
      try{
        x = Integer.parseInt(txtX.getText());
      }catch(NumberFormatException e){
        lblMsgX.setText("Formato inválido."); valido = false;
        if(x<0){
          lblMsgX.setText("x ≥ 0"); valido = false;
        }
      } 
    }else{
      lblMsgX.setText("Campo obligatorio.");
    }
    
    if(!txtLambda.getText().isEmpty()){ //Validando n
      try{
        Lambda = Integer.parseInt(txtLambda.getText());
      }catch(NumberFormatException e){
         lblMsgLambda.setText("Formato inválido."); valido = false;
      }
      if(Lambda<=0){
         lblMsgLambda.setText("λ > 0"); valido = false;
      }
    }else{
      lblMsgLambda.setText("Campo obligatorio.");  valido = false;
    }
    
    return valido; //true si todo está bien
  }
}
