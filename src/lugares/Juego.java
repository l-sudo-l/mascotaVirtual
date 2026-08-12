package lugares;

import personaje.Personaje;
import utiles.Utiles;
public class Juego extends Lugar{

    public Juego() {
        super("juego");
    }

    @Override
    public void iniciar(Personaje personaje) {

    }
     private static void caraCruz(Personaje personaje){
         personaje.getMascota().modificarEnergia(-(int) (personaje.getMascota().getEnergia() * 0.05));
        int moneda = Utiles.generarAleatorio(1,2);
        boolean error = false;
        int apuesta;
         do{
             error = false;
             System.out.println("ingrese la cantidad de monedas que desea apostar , minimo 1 maximo 50");
                apuesta = Utiles.verificarEntero(1 , 50);

             if(personaje.getDinero() < apuesta){
                 error = true;
                 System.out.println("plata insuficiente");
             }
         }while(error);

         System.out.println("elije la opcion");
         System.out.println("1) cara");
         System.out.println("2) cruz");
         int op = Utiles.verificarEntero(1,2);

         if(op == moneda){
             System.out.println("felicidades ganaste");
             personaje.modificarPlata(apuesta);
             personaje.getMascota().modificarFelicidad((int) (apuesta * 0.10));
         }
         else{
             personaje.modificarPlata(-apuesta);
             personaje.getMascota().modificarFelicidad(-(int)(personaje.getMascota().getFelicidad() * 0.03));
             personaje.getMascota().modificarHambre((int)(personaje.getMascota().getHambre() * 0.03));
             personaje.getMascota().modificarSuciedad((int)(personaje.getMascota().getSuciedad() * 0.05));
         }


     }
     private static void adivinarNumero(Personaje personaje){
        boolean error = false;
        int apuesta;
        int numeroAleatorio = Utiles.generarAleatorio(1 , 10);
        personaje.getMascota().modificarEnergia(-(int) (personaje.getMascota().getEnergia() * 0.03));
         do{
             error = false;
             System.out.println("ingrese la cantidad de monedas que desea apostar , minimo 1 maximo 30");
             apuesta = Utiles.verificarEntero(1 , 30);

             if(personaje.getDinero() < apuesta){
                 error = true;
                 System.out.println("plata insuficiente");
             }
         }while(error);

         System.out.println("bienvenido al juego donde tiene que adivinar el numero entre 1 y 10 , tienes 3 intentos para ganar");
        boolean adivino = false;
        int intento = 1;
         while(adivino == false && intento <=3){
             System.out.println("intento numero: " + intento);
             System.out.println("ingrese un numero del 1 al 10");
             int numero = Utiles.verificarEntero(1 , 10);

             if (numero == numeroAleatorio && intento == 1){
                 System.out.println("FELICIDADES: ganaste : " + apuesta * 3 + " monedas");
                 personaje.modificarPlata((int) (apuesta * 1.5));
                 personaje.getMascota().modificarFelicidad((int) (personaje.getMascota().getFelicidad() * 0.05));
                 adivino = true;
             }
             else if (numero == numeroAleatorio && intento == 2) {
                 System.out.println("FELICIDADES: ganaste : " + apuesta * 2 + " monedas");
                 personaje.modificarPlata(apuesta);
                 personaje.getMascota().modificarFelicidad((int) (personaje.getMascota().getFelicidad() * 0.05));
                 adivino = true;
             }
             else if (numero == numeroAleatorio && intento == 3) {
                 System.out.println("FELICIDADES: ganaste : " + apuesta + " monedas");
                 personaje.getMascota().modificarFelicidad((int) (personaje.getMascota().getFelicidad() * 0.05));
                 adivino = true;
             }

             intento++;
         }

         if(adivino == false){
             System.out.println("PERDISTE " + apuesta + " MONEDAS");
             personaje.modificarPlata(-apuesta);
             personaje.getMascota().modificarFelicidad(-(int) (personaje.getMascota().getFelicidad() * 0.02));
             personaje.getMascota().modificarHambre((int) (personaje.getMascota().getHambre() * 0.03));
             personaje.getMascota().modificarSuciedad((int) (personaje.getMascota().getSuciedad() * 0.02));
         }

         
     }


}
