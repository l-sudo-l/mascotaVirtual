package utiles;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Utiles {
    private static Scanner sc = new Scanner(System.in);

    public static int verificarEntero(int min , int max){
        int num = 0;
        boolean error = false;
        do {
            error = false;
            try{
                num = sc.nextInt();
                sc.nextLine();
                if(num < min || num > max){
                    error = true;
                    System.out.println("ERROR: ingresa un numero entre " + min + " y " + max);
                }


            }catch (InputMismatchException e){
                System.out.println("ERROR: ingrese un entero");
                error = true;
                sc.nextLine();
            }
        }while(error);
        return num;
    }

    public static String verificarString(){
        boolean error= false;
        String texto = "";
        do{
            error = false;
           texto = sc.nextLine();
            if (texto.contains(" ")){
                error = true;
                System.out.println("ERROR: ingrese un entero");
            }
        }while(error);


        return texto;
    }

    private static Random random = new Random();

    public static int generarAleatorio(int n1 , int n2){

        return random.nextInt((n2-n1) + 1)+n1;
    }
}
