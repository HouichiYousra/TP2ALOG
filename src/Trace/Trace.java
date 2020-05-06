package Trace;

import java.io.*;

public class Trace {
    String nomf;

    public Trace(String nomf)
    {
        this.nomf=nomf;
    }


    public String lire ( ) throws IOException {
        // final File fichier =new File(chemin);
        BufferedReader in = new BufferedReader(new FileReader(this.nomf));
        String line;
        while ((line = in.readLine()) != null)
        {
            // Afficher le contenu du fichier
            System.out.println (line);
        }
        in.close();
        return "";
    }

    public void ecrire(  String res, String trace)
    {
        final File fichier =new File(this.nomf);
        try {
            // Creation du fichier
            fichier.createNewFile();
            // creation d'un writer (un écrivain)
            final FileWriter writer = new FileWriter(fichier,true);
            try {

                writer.write("le calcul: "+trace+"\n");
                writer.write("le resultat:"+res +"\n");
            } finally {
                // quoiqu'il arrive, on ferme le fichier
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Impossible de creer le fichier");
        }
    }
}

