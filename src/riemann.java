/**
 * Created by Yohel Munoz on 16/06/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.lang.Math;

public class riemann{
    public static void main(String[] args) {
        interfaz();
    }

    public static double elevarALaN(double x, double expon){
        double x1 = (double) Math.pow(x, expon);
        return x1;
    }

    public static double getN(String str){
        String aux = "";
        double ene = 0;
        for (int i = 2; i < str.length(); i++){
            aux = aux + str.charAt(i);
        }
        ene = Double.parseDouble(aux);
        return ene;
    }

    private static double polinomios(String coefs, double x){
        int grado = coefs.length()-1;
        int gradoTemp = grado;
        double x1 = 0;
        double parseado = 0;
        double result = 0;

        for (int i = 0; i <= grado; i++){
            x1 = (double) Math.pow(x, gradoTemp);
            parseado = (double) Character.digit(coefs.charAt(i),10);
            result += parseado*x1;
            gradoTemp--;
        }
        return result;
    }

    private static void pedirDigitos(double a, double b, double error){

        /*Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Ingrese 'a':");
        a = reader.nextDouble(); // Scans the next token of the input
        System.out.println("Ingrese 'b' (mayor que a):");
        b = reader.nextDouble();


        while (a > b){
            System.out.println("Error. Ingresó 'a' mayor que 'b'. Vuelva a ingresar los datos:");
            System.out.println("Ingrese 'a':");
            a = reader.nextDouble(); // Scans the next token of the input
            System.out.println("Ingrese 'b' (mayor que a):");
            b = reader.nextDouble();
        }

        System.out.println("Ingrese error (use coma decimal):");
        error = reader.nextDouble();
        */

        //System.out.println("¿Cuál tipo de funcion desea ingresar? Digite: 1 para x^n ó 2 para una función polinómica:");
        //int tipoFuncion = reader.nextInt();
        Object arreglo[] = { "x^n", "Función polinómica" };
        int tipoFuncion = JOptionPane.showOptionDialog(null, "Tipo de función", "¿Cuál tipo de función desea ingresar?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, arreglo, arreglo[0]);

        double valor = error+1;
        double n = 1;
        double m = 0;
        double valor1 = 0;
        double valor2 = 0;
        double f1 = 0;
        double f2 = 0;
        double sumatoria = 0;
        double maximo = 0;
        double minimo = 0;
        double resultado = 0;
        double exponente = 0;
        double nuevo = 0;
        double minimoAcum = 0;
        String funcion = "";

        if (tipoFuncion == 0){
            //System.out.println("Ingrese la función (por ejemplo x^2):");
            //funcion = reader.next();
            funcion = JOptionPane.showInputDialog(null, "Ingrese la función (por ejemplo x^2):", "Tipo x^n", JOptionPane.PLAIN_MESSAGE);
            exponente = getN(funcion);

            while (valor >= error){
                m = (b-a)/n;
                sumatoria = 0;
                minimoAcum = 0;

                for (double k = 1; k <= n; k++){
                    valor1 = a + ((k-1)*m);
                    valor2 = a + (k*m);
                    f1 = elevarALaN(valor1,exponente);
                    f2 = elevarALaN(valor2,exponente);
                    maximo = Math.max(f1,f2);
                    minimo = Math.min(f1,f2);
                    sumatoria += (maximo-minimo);
                    minimoAcum += minimo;
                }
                valor = m*sumatoria;
                n++;
            }

            resultado = m*minimoAcum;

        }
        else {
            //System.out.println("Ingrese los coeficientes de la función separados por comas (por ejemplo 2,4,0,3 para 2x^3+4x^2+3):");
            //funcion = reader.next();
            funcion = JOptionPane.showInputDialog(null, "Ingrese los coeficientes de la función separados por comas (por ejemplo 2,4,0,3 para 2x^3+4x^2+3)", "Tipo polinomio", JOptionPane.PLAIN_MESSAGE);
            String funcTemporal = "";
            for (int i = 0; i < funcion.length(); i++) {
                //while (funcion.charAt(i) != ','){
                if (funcion.charAt(i) != ',') {
                    funcTemporal += funcion.charAt(i);
                }
                //i++;
            }

            while (valor >= error) {
                m = (b - a) / n;
                sumatoria = 0;
                minimoAcum = 0;

                for (double k = 1; k <= n; k++) {
                    valor1 = a + ((k - 1) * m);
                    valor2 = a + (k * m);
                    f1 = polinomios(funcTemporal, valor1);
                    f2 = polinomios(funcTemporal, valor2);
                    maximo = Math.max(f1, f2);
                    minimo = Math.min(f1, f2);
                    sumatoria += (maximo - minimo);
                    minimoAcum += minimo;
                }

                valor = m * sumatoria;
                n++;
            }

            resultado = m*minimoAcum;
        }

        //System.out.println("El área bajo la curva es: " + resultado);
        //System.out.println("Con " + n + " rectángulos.");
        JOptionPane.showMessageDialog(null, "El área bajo la curva es: " + resultado + "\n" + "Con " + n + " rectángulos.", "Resultado", JOptionPane.PLAIN_MESSAGE);
    }

    public static void interfaz() {

        JFrame f = new JFrame();
        f.setBounds(700, 400, 400, 220);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField fieldA = new JTextField();
        JTextField fieldB = new JTextField();
        JTextField fieldError = new JTextField();

        JButton confirmar = new JButton();

        JLabel labelA = new JLabel("Ingrese 'a':");
        JLabel labelB = new JLabel("Ingrese 'b' (mayor que a):");
        JLabel labelError = new JLabel("Ingrese error (use punto decimal):");
        JLabel labelConfirmar = new JLabel("Confirmar");
        JLabel labelInstrucciones = new JLabel("Ingrese todos los datos antes de confirmar");


        f.add(fieldA);
        f.add(fieldB);
        f.add(fieldError);
        f.add(confirmar);
        f.add(labelA);
        f.add(labelB);
        f.add(labelError);
        confirmar.add(labelConfirmar);
        f.add(labelInstrucciones);
        f.setTitle("Ingreso de dígitos");

        fieldA.setBounds(220, 10, 150, 20);
        fieldB.setBounds(220, 35, 150, 20);
        fieldError.setBounds(220, 60, 150, 20);
        confirmar.setBounds(130, 140, 96, 20);
        labelA.setBounds(140, 10, 180, 20);
        labelB.setBounds(60, 35, 180, 20);
        labelError.setBounds(10, 60, 250, 20);
        labelConfirmar.setBounds(14, 0, 200, 20);
        labelInstrucciones.setBounds(70, 110, 250, 20);

        //labelConfirmar.setLayout(null);
        f.setLayout(null);

        confirmar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    double a = Double.parseDouble(fieldA.getText());
                    double b = Double.parseDouble(fieldB.getText());
                    double error = Double.parseDouble(fieldError.getText());
                    if(a>b){
                    }else {
                        f.dispose();
                        pedirDigitos(a, b, error);
                    }
                } catch (NumberFormatException exept) {}
            }
        });
    }
}
