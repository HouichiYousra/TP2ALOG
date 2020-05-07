package Trace;

import pipeandfilter.Filter;
import pipeandfilter.Pipe;

import java.io.*;

public class Trace extends Filter {

    File fichier ;
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;

    public Trace(Pipe _dataINPipe, Pipe _dataOUTPipe) {
        super();

        this._dataINPipe = _dataINPipe;
        this._dataOUTPipe = _dataOUTPipe;
    }
    public String getData(){
        return _dataINPipe.dataOUT();
    }

    public void sendData( String tempData){
        _dataOUTPipe.dataIN(tempData);
    }




    static public String lire ( ) throws IOException {
        // final File fichier =new File(chemin);
        BufferedReader in = new BufferedReader(new FileReader("trace.txt"));
        String line;
        String trace="";
        while ((line = in.readLine()) != null)
        {
            trace+="\n" +line;
        }
        in.close();
        return trace;
    }

    public void ecrire(  String res, String trace)
    { fichier=new File("trace.txt");
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

       while (true){
        String op = getData();
        sendData(op);
        System.out.println("operation in trace"+ op );
        String[] parts = op.split("-");

        switch (parts[0]){
            case "!":
                ecrire(parts[3], parts[1]+"!");
                break;
            case "+":
                ecrire(parts[3], parts[1] +"+"+ parts[2]);
                break;
            case "*":
                ecrire(parts[3], parts[1] +"*"+ parts[2]);
                break;

    }

    }
}

    @Override
    public void run() {
     execute();
    }
}

