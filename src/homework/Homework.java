package homework;

import java.util.*;
import javax.swing.JOptionPane;

public class Homework {

    private static List<String> posibles = new ArrayList<String>();

    public static void main(String[] args) {
        Numero a = new Numero();
        int controlador = 0;
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
            Numero.generarPosibles();
            Num_Respuesta = EscribirNumero();
            Num_Referencia = Numero.GeneraNumero();

            do {
                System.out.println(Num_Referencia);
               
                Num_Referencia = Numero.CompararAI(Num_Referencia);


            } while (Num_Referencia!=Num_Respuesta);
            JOptionPane.showMessageDialog(null, "La computadora adivino tu numero:" + Num_Respuesta);

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
            char[] arr1 = resp.toCharArray();//Se separan en arrays las cadenas de numeros para comparar posiciones.
            char[] arr2 = adiv.toCharArray();//
            System.out.println(juga);
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
            if (juga == 0) {
                JOptionPane.showMessageDialog(null, bien + " Bien " + regular + " Regular");
            }
            return bien;
        }

        public static String GeneraNumero() {
            int respuesta;

            String respuesta_String;
            do {
                Random num = new Random();

                do {
                    respuesta = (num.nextInt(9999) + 999);
                } while (!Duplicados(respuesta));
                respuesta_String = Integer.toString(respuesta);
                //Se verifica que no se repitan numeros

            } while ((respuesta_String.length() != 4));

            System.out.println(respuesta_String);
            return respuesta_String;
        }

        public static boolean Duplicados(int num) { //verificacion repeticiones de chars
            String x = String.valueOf(num);
            char[] y = x.toCharArray();

            if ((y[0] != y[1]) && (y[0] != y[2]) && (y[0] != y[3]) && (y[1] != y[2]) && (y[1] != y[3]) && (y[2] != y[3])) {
                return true;
            }

            return false;
        }

        public static void generarPosibles() {

            for (int i = 1023; i <= 9876; i++) {
                String posibilidad = String.valueOf(i);
                posibles.add(posibilidad);

                if (!Duplicados(i)) {
                    posibles.remove(posibilidad);
                }

            }

        }

        public static String CompararAI(String resp) {
            Iterator<String> iter = posibles.iterator();
            int bien;
            int regular;
            int bienRef = 0;
            int regularRef = 0;
            String AI = iter.next();

            char[] arr1 = resp.toCharArray();//Se separan en arrays las cadenas de numeros para comparar posiciones.
            char[] arr2 = AI.toCharArray();//

            bien = Integer.parseInt(JOptionPane.showInputDialog("Numeros de digitos bien: "));
            regular = Integer.parseInt(JOptionPane.showInputDialog("Numeros de digitos regulares:"));
            
                for (int i = 0; i < AI.length(); i++) {

                    if (arr1[i] == arr2[i]) {
                        bienRef++;
                    } else if (resp.contains(String.valueOf(arr2[i]))) {//Se compara que el char se encuentre en el numero a adivinar
                        regularRef++;
                    }}
                for (int i = 0; i < posibles.size(); i++) {
                    if (bien != bienRef && regular != regularRef) {
                        
                         posibles.remove(i);
                    } else 
                       AI = posibles.get(0);
                    }

                
            
            if (bien == 4) {
                System.out.println("Guessed ");

            }
            return AI;
        }

    }
}
