package homework;

import java.util.Random;
import javax.swing.JOptionPane;

public class Homework {

    public static void main(String[] args) {
        Numero a = new Numero();

        int controlador;
        String Num_Referencia;
        String Num_Respuesta;

        int seleccion = JOptionPane.showOptionDialog(null, "Elija como jugar: ", //Cuadro de opciones para elegir jugador
                "Seleccion de jugador", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Adivinar", "Elegir Numero"}, "opcion 1");

        if (seleccion == 0) {
            Num_Respuesta = Numero.GeneraNumero(); // Metodo que genera numero en string y imprime en consola por prueba
            do {
                Num_Referencia = EscribirNumero(); //Metodo que pregunta el numero a adivinar
                controlador = Numero.Comparar(Num_Referencia, Num_Respuesta, seleccion); //metodo que compara las entradas de numeros y devuelve los que estan bien
            } while (4 != (controlador));
            JOptionPane.showMessageDialog(null, "Felicidades! Adivinaste el numero");

        } else {

            Num_Respuesta = EscribirNumero();
            Num_Referencia = Numero.GeneraNumero(); 
            do {

                controlador = Numero.Comparar(Num_Referencia, Num_Respuesta, seleccion);
            } while (4 != (controlador));
            JOptionPane.showMessageDialog(null, "La computadora adivino tu numero");
        }

    }

    public static String EscribirNumero() {

        String numeroA;

        do {
            numeroA = JOptionPane.showInputDialog("\"Ingrese un numero de 4 digitos\"");

        } while (numeroA.length() < 4 || numeroA.length() > 4 || (numeroA.matches("[a-zA-Z]+"))); //Evita letras y numeros con mas digitos.
        return numeroA;

    }

    public static class Numero {
                
        public static int Comparar(String resp, String adiv, int juga) {
            int bien = 0;
            int regular = 0;
            int jugador = juga;

            char[] arr1 = resp.toCharArray();//Se separan en arrays las cadenas de numeros para comparar posiciones.
            char[] arr2 = adiv.toCharArray();//
            if (juga == 0) {
                for (int i = 0; i < resp.length(); i++) {//For que imprime en chars en consola para testing.
                    System.out.println("arr2 " + arr2[i]);
                    System.out.println(resp.indexOf(arr2[i]));
                    if (arr1[i] == arr2[i]) {
                        bien++;
                    } else if (resp.contains(String.valueOf(arr2[i]))) {//Se compara que el char se encuentre en el numero a adivinar
                        regular++;
                    }
                }

            }
            JOptionPane.showMessageDialog(null, bien + " Bien " + regular + " Regular");
            return bien;
        }

        public static String GeneraNumero() {
            int respuesta;
            boolean controlador;
            String respuesta_String;
            Random num = new Random();

            do {
                do {
                    respuesta = (num.nextInt(9999) + 999);
                    respuesta_String = Integer.toString(respuesta); 
                    controlador = Duplicados(respuesta); //Se verifica que no se repitan numeros
                } while (controlador);
            } while (respuesta_String.length() != 4);

            System.out.println(respuesta_String);
            return respuesta_String;
        }

        public static boolean Duplicados(int num) { //Algoritmo de luhn para verificar repeticiones de chars
            boolean[] dup = new boolean[10];
            while (num > 0) {
                if (dup[num % 10]) {
                    return true;
                }
                dup[num % 10] = true;
                num /= 10;
            }
            return false;

        }

 
    
    
    
    }

}
