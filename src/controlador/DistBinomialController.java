package controlador;
import Funciones.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DistBinomialController extends ventanaController {
  DistribucionBinomial db;
  int x, n;
  double p; 
  
  @FXML
  private Button btnVolver;
  @FXML
  private TextField txtFuncion;
  @FXML
  private Button btnCalcular;
  @FXML
  private TextField txtX;
  @FXML
  private TextField txtFuncionA;
  @FXML
  private TextField txtEsperanza;
  @FXML
  private TextField txtVarianza;
  @FXML
  private TextField txtDesviacion;
  @FXML
  private TextField txtN;
  @FXML
  private TextField txtP;
  
  @FXML private BarChart<String, Number> grafica;
  @FXML private CategoryAxis xAxis;
  @FXML
  private Button btnLimpiar;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  

  private void volver(ActionEvent event) throws IOException {
    ir_Menu(event);
  }

   public void graficar(){
    grafica.setAnimated(false);
    grafica.getData().clear();
    xAxis.getCategories().clear();
    
    ArrayList<String> Categorias = new ArrayList<>();
    XYChart.Series series1 = new XYChart.Series();
   
    
    for(int i = 0; i<=n; i++){
      Categorias.add(String.valueOf(i));
      series1.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), db.distribucion(i)));
    }
    
    xAxis.setCategories(FXCollections.<String>observableArrayList(Categorias));
    grafica.getData().add(series1);
  }
  
  @FXML
  private void calcular(ActionEvent event) {
    x = Integer.parseInt(txtX.getText());
    n = Integer.parseInt(txtN.getText());
    p = Double.parseDouble(txtP.getText());
    
    db = new DistribucionBinomial(x,n,p);
    
    txtFuncion.setText(String.valueOf(db.distribucion()));
    txtFuncionA.setText(String.valueOf(db.distAcumulada()));
    txtEsperanza.setText(String.valueOf(db.media()));
    txtVarianza.setText(String.valueOf(db.varianza()));
    txtDesviacion.setText(String.valueOf(db.desviacionEstandar()));
    System.out.println("Holaaaaa");
    graficar();
    
    
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
