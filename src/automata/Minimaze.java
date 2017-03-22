package automata;

import java.util.ArrayList;
import java.util.Objects;

public class Minimaze {

    Integer estados[];
    ArrayList<Integer> aceptacion;
    ArrayList<String> alfabeto;
    ArrayList<Integer[]> transicion;
    ArrayList<Integer[]> resultado;

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
        estados = new Integer[2];
        estados[0] = 1;
        estados[1] = 2;
        transicion.add(estados);
        estados = new Integer[2];
        estados[0] = 4;
        estados[1] = 3;
        transicion.add(estados);
        estados = new Integer[2];
        estados[0] = 5;
        estados[1] = 3;
        transicion.add(estados);
        estados = new Integer[2];
        estados[0] = 3;
        estados[1] = 3;
        transicion.add(estados);
        estados = new Integer[2];
        estados[0] = 4;
        estados[1] = 4;
        transicion.add(estados);
        estados = new Integer[2];
        estados[0] = 5;
        estados[1] = 5;
        transicion.add(estados);
        System.out.println(transicion.size());

        int cant = 0;
        boolean flag = false;
        for (int y = 0; y < aceptacion.size(); y++) {
//si algunos de los estados de aceptacion vienen siendo el primero entonces 
            if (0 == aceptacion.get(y)) {
                flag = true;
            }
        }

        ArrayList<Integer[]> matrices = new ArrayList();
        Integer acep[] = new Integer[aceptacion.size()];
        Integer noAcep[] = new Integer[transicion.size() - aceptacion.size()];
        int si = 0;
        int no = 0;
        for (int x = 0; x < acep.length; x++) {
            acep[x] = aceptacion.get(x);
        }
        for (int x = 0; x < transicion.size(); x++) {
            boolean flag2 = false;
            for (Integer acep1 : acep) {
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
        ArrayList<Integer[]> sol = new ArrayList();
        Integer acep1[] = new Integer[1];
        acep1[0] = 0;
        sol.add(acep1);
        acep1 = new Integer[1];
        acep1[0] = 3;
        sol.add(acep1);
        acep1 = new Integer[2];
        acep1[0] = 1;
        acep1[1] = 2;
        sol.add(acep1);
        acep1 = new Integer[2];
        acep1[0] = 4;
        acep1[1] = 5;
        sol.add(acep1);
        solucion(sol);

    }

    public void recursividad(ArrayList<Integer[]> matrices) {

    }
/// cuando recibimos los estados ya minimizados ({0,1}{5}{2,3,4})ahora creamos nuevos estados solidos ({0}{1}{2}) 

    public void solucion(ArrayList<Integer[]> matrices) {
        ArrayList<Integer> nuevaAceptacion = new ArrayList();
        for (int x = 0; x < matrices.size(); x++) {
            Integer temp2[] = transicion.get(matrices.get(x)[0]);
            for (Integer temp21 : temp2) {
                for (int z = 0; z < aceptacion.size(); z++) {
                    if (Objects.equals(temp21, aceptacion.get(z))) {
                        for (int j = 0; j < nuevaAceptacion.size(); j++) {
                            if (x != nuevaAceptacion.get(j)) {
                                nuevaAceptacion.add(x);
                            }
                        }
                    }
                }
            }
            aceptacion = nuevaAceptacion;
            for (Integer temp21 : temp2) {
                for (int y = 0; y < matrices.size(); y++) {
                    Integer resultadoVector[] = new Integer[matrices.get(0).length];
                    for (int z = 0; z < matrices.get(y).length; z++) {
                        if (Objects.equals(temp21, matrices.get(y)[z])) {
                            resultadoVector[z] = y;
                        }
                    }
                    resultado.add(resultadoVector);
                }
            }
        }
        transicion = resultado;
    }
//termino en convertir la nueva mnatriz de transicion;
}
