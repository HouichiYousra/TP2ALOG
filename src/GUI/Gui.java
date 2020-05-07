package GUI;

import Trace.Trace;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pipeandfilter.*;

import java.util.concurrent.TimeUnit;

public class Gui extends Application {
    static Pipe p1 = new BlockingQueue();
    static Pipe p2 = new BlockingQueue();
    static Pipe p3 = new BlockingQueue();
    static Pipe p4 = new BlockingQueue();




    static Filter b11 = new Calcul(p1,p4);

    static Filter b1 = new Calcul(p1,p2);
    static Filter c1 = new Trace(p2,p3);



    static Thread th2 = new Thread( b1 );
    static Thread th3 = new Thread( c1 );
    static Thread th1 = new Thread( b11 );

    public static void main(String[] args) throws InterruptedException {

        new Thread (()->{
            launch(args);
        }).start();
        //th1.start();
        th2.start();
        //TimeUnit.SECONDS.sleep(4);
        th3.start();




    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gui.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        GuiController controller = fxmlLoader.<GuiController>getController();
        controller.setGuiController(p3,p1);
        primaryStage.setTitle("CMPG");
        primaryStage.setScene(new Scene(root, 371, 298));
        primaryStage.show();
    }
}
