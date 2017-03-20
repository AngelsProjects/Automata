/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.ArrayList;

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
        for (int x = 0; x < estados.length; x++) {

        }

        resultado = new ArrayList();
        for (int x = 0; x <) {

        }
        //entonces la matriz 1 sera solo de aceptacion sino sera solo de no aceptacion

        Integer m1[][];
        Integer m2[][] = new Integer[cant][alfabeto.size()];
        if (flag) {
            m1 = new Integer[aceptacion.size()][alfabeto.size()];
            m2 = new Integer[estados.length - aceptacion.size()][alfabeto.size()];
            for (int x = 0; x < transicion.size(); x++) {
                for (int y = 0; y < aceptacion.size(); y++) {

                    if (x == aceptacion.get(y)) {
                        m1
                    } else {

                    }

                }
            }
        } else {
            m1 = new Integer[estados.length - aceptacion.size()][alfabeto.size()];
            m2 = new Integer[aceptacion.size()][alfabeto.size()];

        }

    }

}
