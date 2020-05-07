package Trace;

import pipeandfilter.Filter;
import pipeandfilter.Pipe;

import java.io.*;

public class Trace extends Filter {
    String nomf;
    File fichier ;
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;

    public Trace(Pipe _dataINPipe, Pipe _dataOUTPipe) {
        super();
        fichier=new File("trace.txt");
        this._dataINPipe = _dataINPipe;
        this._dataOUTPipe = _dataOUTPipe;
    }
    public String getData(){
        return _dataINPipe.dataOUT();
    }

    public void sendData( String tempData){
        _dataOUTPipe.dataIN(tempData);
    }




   /* public String lire ( ) throws IOException {
        // final File fichier =new File(chemin);
        BufferedReader in = new BufferedReader(new FileReader(this.nomf));
        String line;
        while ((line = in.readLine()) != null)
        {

            System.out.println (line);
        }
        in.close();
        return "";
    }*/

    public void ecrire(  String res, String trace)
    {
        try {
             FileWriter writer = new FileWriter(fichier,true);
            try {
                writer.write("le calcul: "+trace+"\n");
                writer.write("le resultat:"+res +"\n");
            } finally {
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Impossible d'ecrire'");
        }
    }

    @Override
    protected void execute()  {
        String trace="";
        String op1="";
        String op2="";
        String resul="";
       while (true){
        String op = getData();
        System.out.println("operation in trace"+ op );
        switch (op){
            case "!":

                op1=getData();
                System.out.println("operande1 facto"+op1);
                resul=getData();
                System.out.println("resultat"+resul);
                ecrire(resul, op1 +"!");
                break;
            case "+":
            case "*":

                op1=getData();
                System.out.println("operande1 sum"+op1);
                op2=getData();
                System.out.println("operande2 sum mul"+op2);
                resul=getData();
                System.out.println("resultat"+resul);
                ecrire(resul, op1 +"+"+ op2);
                break;

    }

    }}

    @Override
    public void run() {
     execute();
    }
}

