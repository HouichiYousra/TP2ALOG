package GUI;

import Trace.Trace;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pipeandfilter.*;

public class Gui extends Application {
    static Pipe p1 = new BlockingQueue();
    static Pipe p2 = new BlockingQueue();
    static Pipe p3 = new BlockingQueue();



   static Filter b1 = new Calcul(p1,p2);
    static Filter c1 = new Trace(p2,p3);


    static Thread th2 = new Thread( b1 );
    static Thread th3 = new Thread( c1 );

    public static void main(String[] args) {

        new Thread (()->{
            launch(args);
        }).start();
        th2.start();
        th3.start();



    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gui.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        GuiController controller = fxmlLoader.<GuiController>getController();
        controller.setGuiController(p2,p1);
        primaryStage.setTitle("CMPG");
        primaryStage.setScene(new Scene(root, 371, 298));
        primaryStage.show();
    }
}
