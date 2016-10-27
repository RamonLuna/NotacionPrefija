/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notacionprefija;
import java.io.*;

public class ManejadorExpresiones {

    private static String expresionPost[] = {"6", "2", "3", "+", "-","3","8","2","/","+","*","2","^","3","+"};
    private static String expresionPre[] = {"+", "2", "*", "3", "1"};
    private static Expresiones exp;

    public static void main(String args[]) {
        exp = new Expresiones(expresionPost, expresionPre);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int des = 0;
        try {
            System.out.println("Calcular: \n1.-Postfija\n2.-Prefija");
            des = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Se esperaba un numero: " + e.getCause());
        }
        if (des == 1) {
            System.out.print("Evaluar: ");
            mostrarExpPost();
            System.out.print("\nResultado: ");
            exp.Postfija(expresionPost);
        } else if (des == 2) {
            System.out.print("Evaluar: ");
            mostarExpPre();
            System.out.print("\nResultado: ");
            exp.Prefija(expresionPre);

        }
    }

    public static void mostrarExpPost() {//muestra la expresion Postfija 
        for (int i = 0; i < expresionPost.length; i++) {
            System.out.print(expresionPost[i]);
        }
    }

    public static void mostarExpPre() {//muestra la expresion Prefija
        for (int i = 0; i < expresionPre.length; i++) {
            System.out.print(expresionPre[i]);
        }
    }
}