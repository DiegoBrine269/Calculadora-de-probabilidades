/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Juan M. Hdez
 */
public class MenuPrincipalController extends ventanaController {
 

  @FXML
  private Button btnBinomial;
  @FXML
  private Button btnGeometrica;
  @FXML
  private Button btnHipergeometrica;
  @FXML
  private Button btnDePoissom;

  /**
   * Initializes the controller class.
   */
  
  @FXML
  public void ir_DistBinomial(ActionEvent event) throws IOException{
    cambiarVentana(event, "/vista/DistBinomial.fxml");
  }
  @FXML
  public void ir_DistGeometrica(ActionEvent event) throws IOException{
    cambiarVentana(event, "/vista/DistGeometrica.fxml");
  }
  @FXML
  public void ir_DistHipergeometrica(ActionEvent event) throws IOException{
    cambiarVentana(event, "/vista/DistHipergeometrica.fxml");
  }
  @FXML
  public void ir_DistDePoisson(ActionEvent event) throws IOException{
    cambiarVentana(event, "/vista/DistDePoisson.fxml");
  }
  
  public void salir(ActionEvent e){
  Node sour = (Node) e.getSource();     //Me devuelve el elemento al que hice click
  Stage st = (Stage) sour.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
  st.close();                          //Me cierra la ventana
  }
  
  
}


