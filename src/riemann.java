/**
 * Created by Yohel Munoz on 16/06/2017.
 */

import java.util.Scanner;
import java.lang.Math;
//import org.apache.commons.math;

public class riemann{
    public static void main(String[] args) {

        //double[] array1 = {1,2,3,4,5};
        String array1 = "12345";

        //pedirDigitos();
        System.out.println(polinomios(array1, 5));
    }


    //public static double polinomica(double[] arr, double x){
    //    PolynomialFunction vol2 = new PolynomialFunction(new double[] {0.00085 * 5, -0.00085});
    //}

    public static double cuadratica(double x){
        double x1 = (double) Math.pow(x, 2);
        return x1;
    }

    private static double polinomios(String coefs, double x){
        int grado = coefs.length()-1;
        int gradoTemp = grado;
        double x1 = 0;
        //double[] coeficientes = new double[grado];
        double result = 0;

        for (int i = 0; (i <= grado); i++){
            x1 = (double) Math.pow(x, gradoTemp);
            result += coefs.charAt(i)*x1;
            gradoTemp--;
        }
        return result;
    }

    private static void pedirDigitos(){

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Ingrese 'a':");
        double a = reader.nextDouble(); // Scans the next token of the input
        System.out.println("Ingrese 'b' (mayor que a):");
        double b = reader.nextDouble();
        System.out.println("Ingrese error (use coma decimal):");
        double error = reader.nextDouble();

        System.out.println("¿Cuál tipo de funcion desea ingresar? Digite: 1 para x^n ó 2 para una función polinómica:");
        int tipoFuncion = reader.nextInt();

        String funcion = "";
        if (tipoFuncion == 1){
            System.out.println("Ingrese la función (por ejemplo x^2):");
            funcion = reader.next();
        }
        else{
            System.out.println("Ingrese los coeficientes de la función separados por comas (por ejemplo 2,4,0,3 para 2x^3+4x^2+3):");
            funcion = reader.next();
            int i = 0;
            String funcTemporal = "";
            while (funcion.charAt(i) != ','){
                funcTemporal += funcion.charAt(i);
                i++;
            }
        }


        //String a1 = JOptionPane.showInputDialog(null, "Ingrese 'a':");
        //String b1 = JOptionPane.showInputDialog(null, "Ingrese 'b' (mayor que a):");

        //System.out.println("Ingrese 'n' (cantidad de rectángulos):");
        //double n = reader.nextDouble(); // Scans the next token of the input as an int.
        double n = 1;
        double valor = error+1;
        double m = 0;
        double valor1 = 0;
        double valor2 = 0;
        double f1 = 0;
        double f2 = 0;
        double sumatoria = 0;
        double maximo = 0;
        double minimo = 0;
        double resultado = 0;

        while (valor >= error){
            m = (b-a)/n;
            sumatoria = 0;

            for (double k = 1; k <= n; k++){
                valor1 = a + ((k-1)*m);
                valor2 = a + (k*m);
                f1 = cuadratica(valor1);
                f2 = cuadratica(valor2);
                maximo = Math.max(f1,f2);
                minimo = Math.min(f1,f2);
                sumatoria += (maximo-minimo);
            }


            valor = m*sumatoria;
            n++;
        }

        double nuevo = 0.0;
        for (double k = 1; k <= n; k++){
            valor1 = a + ((k-1)*m);
            valor2 = a + (k*m);
            f1 = cuadratica(valor1);
            f2 = cuadratica(valor2);
            //maximo = Math.max(f1,f2);
            minimo = Math.min(f1,f2);
            nuevo += minimo;
        }
        resultado = m*nuevo;

        //System.out.println(a);
        //System.out.println(b);
        //System.out.println(sumatoria);
        System.out.println(valor);
        System.out.println(resultado);
        System.out.println(n);
    }
}
