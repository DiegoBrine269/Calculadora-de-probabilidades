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
}

