package calculadora.de.probabilidades;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author diieg
 */
public class CalculadoraDeProbabilidades extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      DistribucionBinomial dBinomial = new DistribucionBinomial(2,3,0.25);
      DistribucionGeometrica dGeometrica = new DistribucionGeometrica(5,0.01);
      DistribucionPoisson dPoisson = new DistribucionPoisson(6,4);
      
      //System.out.println(db.distribucion(1));
      System.out.println(dBinomial.distribucion());
      System.out.println(dBinomial.distAcumulada());
      
      System.out.println(dGeometrica.distribucion());
      System.out.println(dGeometrica.distAcumulada());
      System.out.println(dGeometrica.media());
      System.out.println(dGeometrica.desviacionEstandar());
      System.out.println(dPoisson.distribucion());
      System.out.println(dPoisson.distAcumulada());
      System.out.println(dPoisson.media());
      //launch(args);
        
        
    }
    
}
