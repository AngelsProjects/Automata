package automata;

import java.io.*;
import java.util.ArrayList;

public class Archivos {
/*
    File entrada;
    FileOutputStream salida;
    BufferedReader reader;
    BufferedWriter bw;
    ArrayList<Ejemplos> linesFile;
    ArrayList<Tokens> tokenPatron;

    public ArrayList<Tokens> OpenToken(String direccion) {
        try {
            tokenPatron = new ArrayList<>();
            entrada = new File(direccion);
            reader = new BufferedReader(new FileReader(entrada));
            String line;
            int y = 0;
            while ((line = reader.readLine()) != null) {
                tokenPatron.add(new Tokens(line.substring(1, (line.indexOf(";") - 1)), line.substring(line.indexOf(";") + 1).trim()));
                if (tokenPatron.get(y).getExpression().contains("//")) {
                    String replace = tokenPatron.get(y).getExpression().replace("//", "[/][/]");
                    tokenPatron.get(y).setExpression(replace);
                }
                if (tokenPatron.get(y).getExpression().contains("@")) {
                    String replace = tokenPatron.get(y).getExpression().replace("@", "[@]");
                    tokenPatron.get(y).setExpression(replace);
                }
                if (tokenPatron.get(y).getExpression().contains(".")) {
                    String replace = tokenPatron.get(y).getExpression().replace(".", "[.]");
                    tokenPatron.get(y).setExpression(replace);
                }
                if (tokenPatron.get(y).getExpression().contains(":")) {
                    String replace = tokenPatron.get(y).getExpression().replace(":", "[:]");
                    tokenPatron.get(y).setExpression(replace);
                }
                if (tokenPatron.get(y).getExpression().contains("λ")) {
                    String replace = tokenPatron.get(y).getExpression().replace("λ", "");
                    tokenPatron.get(y).setExpression(replace);
                }
                
                y++;
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Problema en: "+this.OpenFile(direccion) + e);
            return null;
        }
        return tokenPatron;
    }

    public ArrayList<Ejemplos> OpenFile(String direccion) {
        try {
            linesFile = new ArrayList<>();
            entrada = new File(direccion);
            reader = new BufferedReader(new FileReader(entrada));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!linesFile.isEmpty()) {
                    boolean flag = false;
                    for (int x = 0; x < linesFile.size(); x++) {
                        if (linesFile.get(x).getDefinicion().equals(line)) {
                            flag = true;
                        }
                    }
                    if (flag == false) {
                        linesFile.add(new Ejemplos(line, null));
                    }
                } else {
                    linesFile.add(new Ejemplos(line, null));
                }
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Problema en: " + e);
            return null;
        }
        return linesFile;
    }

    boolean canread(String direccion) {
        File f = new File(direccion);
        return f.canRead();
    }

    String SaveText(File archivo, ArrayList<Ejemplos> contentFile) {
        String respuesta;
        try {
            salida = new FileOutputStream(archivo);
            bw = new BufferedWriter(new OutputStreamWriter(salida));
            for (Ejemplos end : contentFile) {
                bw.write(end.getDefinicion() + "\t" + end.getResultado());
                bw.newLine();
            }
            bw.close();
            respuesta = "se guardo con exito el archivo.";
        } catch (IOException e) {
            System.err.println("Problema en: " + e);
            respuesta = "No se pudo guardar el archivo.";
        }
        return respuesta;
    }*/
}
/*

[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z](subtraction)
change value contains()"|X|" replace "|"
*/
