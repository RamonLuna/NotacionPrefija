/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notacionprefija;

public class Pila {

    private int pila[];
    private int dato;
    private int tope = -1;
    private int max = 0;
    private boolean res;

    Pila(int max) {//el constructor pide el tamano de la pila
        this.max = max;
        pila = new int[max];//se crea un arreglo del tamano pasado ateriormente
        dato = 0;
    }

    public void borrarpila() {//metodo para borrar toda la pila
        tope = -1;//mandamos el tope al principio, esto indica que la pila esta vacia
    }

    public boolean Pila_llena() {
        if (tope == (max - 1)) {
            res = true;
        } else {
            res = false;
        }

        return res;
    }

    public boolean Pila_vacia() {
        if (tope == -1) {
            res = true;
        } else {
            res = false;
        }

        return res;
    }

    public boolean poner(int dato) {
        if (Pila_llena()) {
            System.err.print("Desbordamiento: Pila llena");
        } else {
            tope++;
            pila[tope] = dato;
            res = true;
        }
        return res;
    }

    public int quitar() {
        if (Pila_vacia()) {
            System.err.print("Sub-Desbordamiento: Pila vacia");
        } else {
            dato = pila[tope];
            tope--;
        }
        return dato;
    }

    public void mostrar() {
        for (int i = tope; i >= 0; i--) {
            System.out.println(pila[i]);
        }
    }

    public String copiarPila(Object[] pila) {
        Object[] copy = new Object[pila.length];
        String muestra = "";
        System.arraycopy(pila, 0, copy, 0, pila.length);
        for (int i = 0; i < copy.length; i++) {
            muestra += copy[i] + " ";
        }
        return muestra;
    }
}