package automata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Minimaze {

    int estados[];
    ArrayList<Integer> aceptacion;
    ArrayList<String> alfabeto;
    ArrayList<int[]> transicion;
    ArrayList<int[]> resultado;

    public static void main(String[] args) throws ClassNotFoundException {
        Minimaze min = new Minimaze();
        min.miniizar();
    }

    public void miniizar() throws ClassNotFoundException {

        aceptacion = new ArrayList();
        aceptacion.add(4);
        aceptacion.add(5);
        alfabeto = new ArrayList();
        alfabeto.add("0");
        alfabeto.add("1");
        //MATRIZ INICIAL se usara para comparar con las demas matrices
        transicion = new ArrayList();
        estados = new int[2];
        estados[0] = 1;
        estados[1] = 2;
        transicion.add(estados);
        estados = new int[2];
        estados[0] = 4;
        estados[1] = 3;
        transicion.add(estados);
        estados = new int[2];
        estados[0] = 5;
        estados[1] = 3;
        transicion.add(estados);
        estados = new int[2];
        estados[0] = 3;
        estados[1] = 3;
        transicion.add(estados);
        estados = new int[2];
        estados[0] = 4;
        estados[1] = 4;
        transicion.add(estados);
        estados = new int[2];
        estados[0] = 5;
        estados[1] = 5;
        transicion.add(estados);
        try {
            FileOutputStream fos = new FileOutputStream("Salida.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(transicion);
            oos.writeObject(alfabeto);
            oos.writeObject(aceptacion);
            oos.close();
            fos.close();
            
             FileInputStream fileIn = new FileInputStream("Salida.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    ArrayList<int[]> List_Of_Lists = (ArrayList<int[]>) in.readObject();
                ArrayList<String> alfa= (ArrayList<String>) in.readObject();
                ArrayList<Integer> acepta= (ArrayList<Integer>) in.readObject();
                
                    in.close();
                    fileIn.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        
        

        ArrayList<int[]> matrices = new ArrayList();
        int acep[] = new int[aceptacion.size()];
        int noAcep[] = new int[transicion.size() - aceptacion.size()];
        int no = 0;
        for (int x = 0; x < acep.length; x++) {
            acep[x] = aceptacion.get(x);
        }
        for (int x = 0; x < transicion.size(); x++) {
            boolean flag2 = false;
            for (int acep1 : acep) {
                if (x == acep1) {
                    flag2 = true;
                }
            }
            if (!flag2) {
                noAcep[no] = x;
                no++;
            }
        }
        matrices.add(acep);
        matrices.add(noAcep);
        // recursividad(matrices);
        ArrayList<int[]> sol = new ArrayList();
        int acep1[] = new int[1];
        acep1[0] = 0;
        sol.add(acep1);
        acep1 = new int[1];
        acep1[0] = 3;
        sol.add(acep1);
        acep1 = new int[2];
        acep1[0] = 1;
        acep1[1] = 2;
        sol.add(acep1);
        acep1 = new int[2];
        acep1[0] = 4;
        acep1[1] = 5;
        sol.add(acep1);
        solucion(sol);

    }

    public void recursividad(ArrayList<int[]> matrices) {

    }
/// cuando recibimos los estados ya minimizados ({0,1}{5}{2,3,4})ahora creamos nuevos estados solidos ({0}{1}{2}) 

    public void solucion(ArrayList<int[]> matrices) {
        ArrayList<Integer> nuevaAceptacion = new ArrayList();
        for (int x = 0; x < matrices.size(); x++) {
            for (Integer aceptacion1 : aceptacion) {
                if (matrices.get(x)[0] == aceptacion1) {
                    nuevaAceptacion.add(x);
                }
            }
        }
        aceptacion = nuevaAceptacion;
        resultado = new ArrayList();
        int resultadoVector[];
        for (int y = 0; y < matrices.size(); y++) {
            resultadoVector = new int[alfabeto.size()];
            int cont = 0;
            for (int x = 0; x < resultadoVector.length; x++) {
                int nueva[] = transicion.get(matrices.get(y)[0]);
                for (int nueva1 : nueva) {
                    for (int w = 0; w < matrices.size(); w++) {
                        for (int get : matrices.get(w)) {
                            if (get == nueva1 && cont < resultadoVector.length + 1) {
                                resultadoVector[x] = w;
                                cont++;
                                System.out.println(w);
                            }
                        }
                    }
                }
            }
            resultado.add(resultadoVector);
        }
        transicion = resultado;
    }
//termino en convertir la nueva mnatriz de transicion;
}
