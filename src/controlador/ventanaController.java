package controlador;

import Funciones.DistribucionDiscreta;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ventanaController implements Initializable {
  protected Stage stage;
  protected Scene scene;
  protected Parent root;
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
   
  }
  
  public void cambiarVentana(ActionEvent event, String fileFXML) throws IOException{
    root = FXMLLoader.load(getClass().getResource(fileFXML));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
  @FXML
  protected void ir_Menu(ActionEvent event) throws IOException{
    cambiarVentana(event, "/vista/MenuPrincipal.fxml");
  }
  
  @FXML private BarChart<String, Number> grafica;
  @FXML private CategoryAxis xAxis;
  
  public void graficar(DistribucionDiscreta d, int n){
    grafica.setAnimated(false);
    grafica.getData().clear();
    xAxis.getCategories().clear();
    
    ArrayList<String> Categorias = new ArrayList<>();
    XYChart.Series series1 = new XYChart.Series();
   
    for(int i = 0; i<=n+3; i++){
      Categorias.add(String.valueOf(i));
      series1.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), d.distribucion(i)));
    }
    
    xAxis.setCategories(FXCollections.<String>observableArrayList(Categorias));
    grafica.getData().add(series1);
  }
  
}

