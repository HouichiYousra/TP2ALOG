import Calcul.Calcul;
import GUI.GuiController;
import Trace.Trace;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pipeandfilter.*;

public class Main extends Application {
    static Pipe p1 = new BlockingQueue();
    static Pipe p2 = new BlockingQueue();
    static Pipe p3 = new BlockingQueue();




    static Filter calcul = new Calcul(p1,p2);
    static Filter trace = new Trace(p2,p3);



    static Thread thCalcul = new Thread( calcul );
    static Thread thTrace = new Thread( trace );


    public static void main(String[] args)  {

        new Thread (()->{
            launch(args);
        }).start();
        thCalcul.start();
        thTrace.start();

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/gui.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        GuiController controller = fxmlLoader.<GuiController>getController();
        controller.setGuiController(p3,p1);
        primaryStage.setTitle("CMPG");
        primaryStage.setScene(new Scene(root, 581.33, 298));
        primaryStage.show();
    }
}
