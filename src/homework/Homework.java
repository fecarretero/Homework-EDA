package homework;

import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;



public class Homework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String numeroA;

        do {
            System.out.println("Ingrese un numero de 4 digitos");
            numeroA = JOptionPane.showInputDialog("\"Ingrese un numero de 4 digitos\"");

        } while (numeroA.length() < 4 || numeroA.length() > 4 || (numeroA.matches("[a-zA-Z]+"))); //Evita letras y numeros con mas digitos.
numberGenerator();
GeneraNumero();
    }
    
 
public static int GeneraNumero() {
    int respuesta;
  Random num= new Random();
    respuesta=(num.nextInt(9999)+ 1000);
    System.out.println(respuesta);
return respuesta;
}
public static int[] numberGenerator() {
    Random randy = new Random();
    int[] randArray = {10,10,10,10};

    for(int i=0;i<randArray.length;i++){
        int temp = randy.nextInt(10);
        System.out.println(temp);
        while(temp == randArray[0] || temp == randArray[1] || temp == randArray[2] || temp == randArray[3]){
            temp=randy.nextInt(9);
            
        }
        randArray[i]=temp;      
    }
    return randArray;
}



    public String Comparar(String resp, String adiv) {
        int bien = 0;
        int regular = 0;
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        
        for (int i = 0; i < resp.length(); i++) {
            char c1 = resp.charAt(i);
            char c2 = resp.charAt(i);

            if (c1 == c2) {
                bien++;
            } else {
                arr1[c1 - '0']++;
                arr2[c2 - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            regular += Math.min(arr1[i], arr2[i]);
        }

        return bien + "A" + regular + "B";
    }
}
