/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notacionprefija;

import java.util.*;

public class Expresiones {

    private int sacaTope, sacaSig, resultado;
    private ArrayList<String> operadores;
    private Pila pilaPost;
    private Pila pilaPre;

    public Expresiones(String expresionPost[], String expresionPre[]) {
        pilaPost = new Pila(expresionPost.length);
        pilaPre = new Pila(expresionPre.length);

    }

    public void Postfija(String[] expresionPost) {//evalua una expresion dada en forma Postfija
        operadores = new ArrayList<>();//guardamos los operadores en una lista
        operadores.add("+");
        operadores.add("-");
        operadores.add("*");
        operadores.add("/");
        operadores.add("^");

        for (String car : expresionPost) {//recorremos la expresion con una variable tipo String
            if (operadores.contains(car)) {//si encontramos un operador de los listados antes entonces 
                sacaTope = pilaPost.quitar();//saca el tope
                sacaSig = pilaPost.quitar();//luego saca el siguiente del tope
                operacionPost(sacaTope, sacaSig, car);//y realiza las operaciones que corresponden
            } else {//si encuentra un operando, lo agrega directamente a la pila
                pilaPost.poner(Integer.parseInt(car));
            }
        }
        pilaPost.mostrar();//mostramos el elemento que queda en la pila
    }

    public void Prefija(String[] expresionPre) {//evalua una expresion dada en forma Prefija 
        String car;
        operadores = new ArrayList<>();
        operadores.add("+");
        operadores.add("-");
        operadores.add("*");
        operadores.add("/");
        operadores.add("^");

        for (int i = (expresionPre.length - 1); i >= 0; i--) {//recorremos la expresion en oreden inverso a la anterior 
            car = expresionPre[i];//guardamos los caracteres en una variable, para despues utilizarlos
            if (operadores.contains(car)) {
                sacaTope = pilaPre.quitar();
                sacaSig = pilaPre.quitar();
                operacionPre(sacaTope, sacaSig, car);
            } else {
                pilaPre.poner(Integer.parseInt(car));
            }
        }
        pilaPre.mostrar();
    }

    public int operacionPost(int sacaTope, int sacaSig, String operador) {//calcula la expresion en Postfija
        if (operador.equals("^")) {
            resultado = (int) Math.pow(sacaSig, sacaTope);
            pilaPost.poner(resultado);
        } else if (operador.equals("/")) {
            resultado = sacaSig / sacaTope;
            pilaPost.poner(resultado);
        } else if (operador.equals("+")) {
            resultado = (sacaSig + sacaTope);
            pilaPost.poner(resultado);
        } else if (operador.equals("-")) {
            resultado = sacaSig - sacaTope;
            pilaPost.poner(resultado);
        } else if (operador.equals("*")) {
            resultado = sacaSig * sacaTope;
            pilaPost.poner(resultado);
        }
        return resultado;
    }

    public int operacionPre(int sacaTope, int sacaSig, String operador) {//calcula la expresion en Prefija
        if (operador.equals("^")) {
            resultado = (int) Math.pow(sacaTope, sacaSig);
            pilaPre.poner(resultado);
        } else if (operador.equals("/")) {
            resultado = sacaTope / sacaSig;
            pilaPre.poner(resultado);
        } else if (operador.equals("+")) {
            resultado = (sacaTope + sacaSig);
            pilaPre.poner(resultado);
        } else if (operador.equals("-")) {
            resultado = sacaTope - sacaSig;
            pilaPre.poner(resultado);
        } else if (operador.equals("*")) {
            resultado = sacaTope * sacaSig;
            pilaPre.poner(resultado);
        }
        return resultado;
    }
}
