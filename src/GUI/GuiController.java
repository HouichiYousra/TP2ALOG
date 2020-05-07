package GUI;

import Trace.Trace;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import pipeandfilter.Filter;
import pipeandfilter.Pipe;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiController extends Filter implements Initializable {
    @FXML
    private JFXButton produitBtn;

    @FXML
    private JFXButton sommeBtn;
    @FXML
    private JFXButton factorielBtn;

    @FXML
    private JFXTextField nb1;
    @FXML
    private JFXTextField nb2;

    @FXML
    private JFXTextField result;
    @FXML
    private JFXButton quiterBtn;
    @FXML
    private JFXButton traceBtn;

    @FXML
    private TextArea tracetxt;

    private String operation;
    private String num1;
    private String num2;

    private String trace="";

    Pipe _dataINPipe;
    Pipe _dataOUTPipe;



    public void setGuiController(Pipe _dataINPipe, Pipe _dataOUTPipe){

        this._dataINPipe = _dataINPipe;
        this._dataOUTPipe = _dataOUTPipe;
    }


    public String getData(){
        return _dataINPipe.dataOUT();
    }

    public void sendData( String tempData){
        _dataOUTPipe.dataIN(tempData);
    }
    @Override
    public void run() {

    }
    @Override
    protected void execute() {
        _dataOUTPipe.dataIN(operation+"-"+num1+"-"+num2+"-0");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quiterBtn.setOnAction(actionEvent -> {
            // get a handle to the stage
            Stage stage = (Stage) quiterBtn.getScene().getWindow();
            // close it
            stage.close();
            Platform.exit();
            System.exit(0);
        });

        produitBtn.setOnAction(actionEvent -> {
            this.operation="*";
            this.num1=nb1.getText();
            this.num2=nb2.getText();
            execute();
            String resultat2 = getData();
            trace+= "\n" +resultat2;
            String[] parts = resultat2.split("-");
            this.result.setText( parts[3]);
        });

        sommeBtn.setOnAction(actionEvent -> {
            this.operation="+";
            this.num1=nb1.getText();
            this.num2=nb2.getText();
            execute();
            String resultat = getData();
            trace+= "\n" +resultat;
            String[] parts = resultat.split("-");
            System.out.println("resultat");
            this.result.setText( parts[3]);
        });

        factorielBtn.setOnAction(actionEvent -> {
            this.operation="!";
            this.num1=nb1.getText();
            this.num2=nb2.getText();
            execute();
            String resultat2 = getData();
            trace+= "\n" +resultat2;
            String[] parts = resultat2.split("-");
            System.out.println("resultat");
            this.result.setText( parts[3]);
        });
        traceBtn.setOnAction(this::handle);
    }

    private void handle(ActionEvent actionEvent) {
        try {
            this.tracetxt.setText(Trace.lire());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
