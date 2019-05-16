package homework;
import java.util.Random;
import javax.swing.JOptionPane;

public class Homework {

    public static void main(String[] args) {
        Numero a = new Numero();
        int controlador;
        String Num_Referencia;
        String Num_Respuesta;
        Num_Respuesta = Numero.GeneraNumero(); // Metodo que genera numero en string y imprime en consola por prueba
        do {
            Num_Referencia = EscribirNumero(); //Metodo que pregunta el numero a adivinar
           controlador=Numero.Comparar(Num_Referencia,Num_Respuesta);
        } while (4!=(controlador) );
        JOptionPane.showMessageDialog(null, "Felicidades! Adivinaste el numero");
    }

    

    public static String EscribirNumero() {

        String numeroA;

        do {
            numeroA = JOptionPane.showInputDialog("\"Ingrese un numero de 4 digitos\"");

        } while (numeroA.length() < 4 || numeroA.length() > 4 || (numeroA.matches("[a-zA-Z]+"))); //Evita letras y numeros con mas digitos.
        return numeroA;

    }

    public static class Numero {

        public static int Comparar(String resp, String adiv) {
        int bien = 0;
        int regular = 0;
        char[] arr1 = new char[3];//Se separan en arrays las cadenas de numeros para comparar posiciones.
        char[] arr2 = new char[3];//
        arr1 = resp.toCharArray();//
        arr2 = adiv.toCharArray();//
        
            for (int i = 0; i < resp.length(); i++) {//For que imprime en chars en consola para testing.
                System.out.println("arr2 " + arr2[i]);
                System.out.println(resp.indexOf(arr2[i]));
                if (arr1[i] == arr2[i]) {
                    bien++;
                } else if (resp.contains(String.valueOf(arr2[i]))) {//Se compara que el char se encuentre en el numero a adivinar
                    regular++;
                }

            }
            JOptionPane.showMessageDialog(null, bien + "Bien" + regular + "Regular");
            return bien;
    }
        public static String GeneraNumero() {
        int respuesta;
        String respuesta_String;
        Random num = new Random();
        do {
            respuesta = (num.nextInt(9999) + 999);
            System.out.println(respuesta);
            respuesta_String = Integer.toString(respuesta);
        } while (respuesta_String.length() != 4);

        System.out.println(respuesta_String);
        return respuesta_String;
    }
        }
    }
    
    

            
    

