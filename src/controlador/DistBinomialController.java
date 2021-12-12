package controlador;
import Funciones.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DistBinomialController extends ventanaController {
  DistribucionBinomial db;
  int x, n;
  double p; 
  
  @FXML private Button btnVolver;
  @FXML private TextField txtFuncion;
  @FXML private Button btnCalcular;
  @FXML private TextField txtX;
  @FXML private TextField txtFuncionA;
  @FXML private TextField txtEsperanza;
  @FXML private TextField txtVarianza;
  @FXML private TextField txtDesviacion;
  @FXML private TextField txtN;
  @FXML private TextField txtP;
  @FXML private Button btnLimpiar;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  
  
  @FXML
  private void calcular(ActionEvent event) {
    x = Integer.parseInt(txtX.getText());
    n = Integer.parseInt(txtN.getText());
    p = Double.parseDouble(txtP.getText());
    
    //PENDIENTE: validar antes de instanciar distribución
    
    db = new DistribucionBinomial(x,n,p);
    
    txtFuncion.setText(String.valueOf(db.distribucion()));
    txtFuncionA.setText(String.valueOf(db.distAcumulada()));
    txtEsperanza.setText(String.valueOf(db.media()));
    txtVarianza.setText(String.valueOf(db.varianza()));
    txtDesviacion.setText(String.valueOf(db.desviacionEstandar()));
    
    graficar(db, n-3);
  }

  @FXML
  @Override
  public void ir_Menu(ActionEvent event) throws IOException {
    cambiarVentana(event, "/vista/MenuPrincipal.fxml");
  }
 
  @FXML
   private void  limpiar(){
    txtX.setText(null);
    txtN.setText(null);
    txtP.setText(null); 
     
    txtFuncion.setText(null);
    txtFuncionA.setText(null);
    txtEsperanza.setText(null);
    txtVarianza.setText(null);
    txtDesviacion.setText(null);
    
    grafica.getData().clear();
    xAxis.getCategories().clear();
   
   }
  
  
  /*public boolean  validarCampos(){
   int invalido = 0; 
   
    if(!txtX.getText().isEmpty()){ //Validandoo x
      try{
        x = Integer.parseInt(txtX.getText());
      }catch(NumberFormatException e){
        
      }
      
      
    }else{
    
    }
    
    if(!txtN.getText().isEmpty()){ //Validando n
      try{
        n = Integer.parseInt(txtN.getText());
      }catch(NumberFormatException e){
        
      }
      if(n<0){
        
      }
      
    }
    
    
    if(!txtP.getText().isEmpty()){ //Validando p
      try{
        p = Double.parseDouble(txtP.getText());
      }catch(NumberFormatException e){
        
      }
      if(0<p || p>1){
        
      }
      
      
   }
    if(!(0 <= x && x <= n)){
      
      
    } 
    
    
    return invalido > 0;
    }*/
}