package controlador;

import Funciones.DistribucionDiscreta;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class ventanaController implements Initializable {
  protected Stage stage;
  protected Scene scene;
  protected Parent root;
  
  DecimalFormat df;


  @FXML protected TextField txtFuncion;
  @FXML protected TextField txtFuncionA;
  @FXML protected TextField txtEsperanza;
  @FXML protected TextField txtVarianza;
  @FXML protected TextField txtDesviacion;
  @FXML protected CategoryAxis xAxis;
  @FXML protected NumberAxis yAxis;
  @FXML protected BarChart<String, Number> grafica;// = new BarChart<>(xAxis,yAxis);
  
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
   
  }
  
  public void cambiarVentana(ActionEvent event, String fileFXML) throws IOException{
    root = FXMLLoader.load(getClass().getResource(fileFXML));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    yAxis.setUpperBound(1.0);
    stage.show();
    
  }
  
  @FXML
  /*
    Método que nos permite regresar al menú principal
  */
  protected void ir_Menu(ActionEvent event) throws IOException{
    cambiarVentana(event, "/vista/MenuPrincipal.fxml");
  }
  
  /*
    Método que agrega los valores de una DD para generar n número de barras en la gráfica
    Recibe:
        - d: Un objeto de tipo DistribucionDiscreta
        - n: número de barras a graficas + 3
  */
  public void graficar(DistribucionDiscreta d, int n){
    grafica.setAnimated(false);
    grafica.getData().clear();
    xAxis.getCategories().clear();
    
    grafica.setBarGap(1);
    grafica.setCategoryGap(0);
    grafica.setLegendVisible(false);
    
    Double value;
    
    ArrayList<String> Categorias = new ArrayList<>();
    XYChart.Series series1 = new XYChart.Series();
    int i=0;
    while(true){
      
      value = d.distribucion(i);
      if(value<0.001 && i>n)
         break;
      
      final XYChart.Data<String, Number> data = new XYChart.Data(String.valueOf(i), value);
      data.nodeProperty().addListener(new ChangeListener<Node>() {
        @Override public void changed(ObservableValue<? extends Node> ov, Node oldNode, Node node) {
          if (node != null) {
            setNodeStyle(data, n);
          } 
        }
      });
      series1.getData().add(data);
      i++;
    }
    grafica.getData().add(series1);
  }
  
   private void setNodeStyle(XYChart.Data<String, Number> data, int x) {
    df = new DecimalFormat();
    df.setMaximumFractionDigits(4);
    Node node = data.getNode(); //Etiquetamos las barras
    Tooltip tp = new Tooltip(String.valueOf(df.format(data.getYValue())));
    Tooltip.install(node, tp);
    if (Integer.parseInt(data.getXValue()) == x) {
      node.setStyle("-fx-bar-fill: #f8961e;");
    } else if (Integer.parseInt(data.getXValue()) < x) {
      node.setStyle("-fx-bar-fill: #f94144;");
    } else {
      node.setStyle("-fx-bar-fill: #4acc31;");
    }
  }
  
  
    /*
      Método que escribe los atributos de una Distribución en las cajas de texto
      Recibe:
          - d: Un objeto de tipo DistribucionDiscreta
    */
    public void mostrarResultados(DistribucionDiscreta d){
        df = new DecimalFormat();
        df.setMaximumFractionDigits(4);

        txtFuncion.setText(String.valueOf(df.format(d.distribucion())));
        txtFuncionA.setText(String.valueOf(df.format(d.distAcumulada())));
        txtEsperanza.setText(String.valueOf(df.format(d.media())));
        txtVarianza.setText(String.valueOf(df.format(d.varianza())));
        txtDesviacion.setText(String.valueOf(df.format(d.desviacionEstandar())));
    }
  
  
    public void limpiarResultados(){
        txtFuncion.setText(null);
        txtFuncionA.setText(null);
        txtEsperanza.setText(null);
        txtVarianza.setText(null);
        txtDesviacion.setText(null);

        grafica.getData().clear();
        xAxis.getCategories().clear();
        yAxis.setUpperBound(1.0);
    }  
}




