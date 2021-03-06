package modelo;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class CalculadoraDeProbabilidades extends Application {
    
    @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/vista/MenuPrincipal.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.getIcons().add(new Image(CalculadoraDeProbabilidades.class.getResourceAsStream("icon.png")));
    stage.setTitle("Calculadora de Distribuciones Discretas");
    stage.setResizable(false);
    stage.show();
  }

  public static void inicio(String[] args) {
    launch(args);
  }     
}
