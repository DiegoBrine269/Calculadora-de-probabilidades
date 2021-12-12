/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
}


