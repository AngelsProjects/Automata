package automata;

import java.util.ArrayList;

public class Minimaze {

    int estados[];
    ArrayList<Integer> aceptacion;
    ArrayList<String> alfabeto;
    ArrayList<int[]> transicion;
    ArrayList<int[]> resultado;

    public static void main(String[] args) {
        Minimaze min = new Minimaze();
        min.miniizar();
    }

    public void miniizar() {

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

        ArrayList<int[]> matrices = new ArrayList();
        int acep[] = new int[aceptacion.size()];
        int noAcep[] = new int[transicion.size() - aceptacion.size()];
        int si = 0;
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
            for (int y = 0; y < aceptacion.size(); y++) {
                if (matrices.get(x)[0] == aceptacion.get(y)) {
                    nuevaAceptacion.add(x);
                }
            }
            System.out.println(x);
        }
        aceptacion = nuevaAceptacion;
        resultado = new ArrayList();
        int resultadoVector[];
        for (int y = 0; y < matrices.size(); y++) {
            resultadoVector = new int[alfabeto.size()];
            for (int x = 0; x < resultadoVector.length; x++) {
                int nueva[] = transicion.get(matrices.get(y)[0]);
                for (int nueva1 : nueva) {
                    for (int w = 0; w < matrices.size(); w++) {
                        for (int get : matrices.get(w)) {
                            if (get == nueva1) {
                                resultadoVector[x] = w;
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
