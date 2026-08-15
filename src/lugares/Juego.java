package lugares;

import personaje.Personaje;
import utiles.Utiles;
public class Juego extends Lugar{

    public Juego() {
        super("juego");
    }

    @Override
    public void iniciar(Personaje personaje) {
        System.out.println("ingrese el numero del juego que desea jugar");
        System.out.println("1) cara o cruz");
        System.out.println("2) craps");
        System.out.println("3) adivinar el numero del 1 al 10");
        int op = Utiles.verificarEntero(1 ,  3);

        switch (op){
            case 1:
                caraCruz(personaje);
            break;

            case 2:
                craps(personaje);
            break;

            case 3:
                adivinarNumero(personaje);
            break;
        }
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
         while(!adivino && intento <=3){
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

         if(!adivino){
             System.out.println("PERDISTE " + apuesta + " MONEDAS");
             personaje.modificarPlata(-apuesta);
             personaje.getMascota().modificarFelicidad(-(int) (personaje.getMascota().getFelicidad() * 0.02));
             personaje.getMascota().modificarHambre((int) (personaje.getMascota().getHambre() * 0.03));
             personaje.getMascota().modificarSuciedad((int) (personaje.getMascota().getSuciedad() * 0.02));
         }

     }

    private static void craps(Personaje personaje){
        personaje.getMascota().modificarEnergia(-(int) (personaje.getMascota().getEnergia() * 0.03));
        int dado1 = Utiles.generarAleatorio(1 , 6);
        int dado2 = Utiles.generarAleatorio(1 , 6);
        boolean error = false;
        boolean gano = false;
        boolean perdiste = false;
        int apuestaInicial;
        int puntos = 0;
        int intentos = 1;

        do{
            error = false;
            System.out.println("ingrese la cantidad de monedas que desea apostar , minimo 1 maximo 200");
            apuestaInicial = Utiles.verificarEntero(1 , 200);

            if(personaje.getDinero() < apuestaInicial){
                error = true;
                System.out.println("plata insuficiente");
            }
        }while(error);

        System.out.println("tirando dados...");
        int sumatoria = dado1 + dado2;
        System.out.println("el resultado de los dados es: " + sumatoria);


        if (sumatoria == 7 || sumatoria == 11){
            System.out.println("GANASTE");
            gano = true;
            personaje.modificarPlata((int) (apuestaInicial * 1.5));
            personaje.getMascota().modificarFelicidad((int) (apuestaInicial * 0.03));
        }
        else if(sumatoria == 2 || sumatoria == 3 || sumatoria == 12){
            System.out.println("PERDISTE");
            perdiste = true;
            personaje.modificarPlata(-apuestaInicial);
            personaje.getMascota().modificarHambre((int) (personaje.getMascota().getHambre() * 0.04));
            personaje.getMascota().modificarSuciedad((int) (personaje.getMascota().getSuciedad() * 0.04));
        }
        else if (sumatoria == 4 || sumatoria == 5 || sumatoria == 6 || sumatoria == 8 || sumatoria == 9 || sumatoria == 10){
            puntos = sumatoria;

        }

        int apuesta2 = apuestaInicial * 2;
        int apuestaActual = apuesta2;
        int limite = apuesta2 * 20 / 100;
        int descuentoPorIntento = apuesta2 * 10 / 100;
        int perderFelicidad = personaje.getMascota().getFelicidad() * intentos / 100;



        while(!perdiste && !gano){
            dado1 = Utiles.generarAleatorio(1 , 6);
            dado2 = Utiles.generarAleatorio(1 , 6);
            int sumatoria2 = dado1 + dado2;

            if(sumatoria2 == puntos){
                gano = true;
                System.out.println("ganaste");
                personaje.modificarPlata(apuestaActual);
            }
            else if(sumatoria2 == 7){
                perdiste = true;
                System.out.println("perdiste");
                personaje.getMascota().modificarFelicidad(-perderFelicidad);
                personaje.getMascota().modificarHambre((int) (personaje.getMascota().getHambre() * 0.04));
                personaje.getMascota().modificarSuciedad((int) (personaje.getMascota().getSuciedad() * 0.04));
            }
            else {
                apuestaActual = Math.max(limite, apuestaActual - descuentoPorIntento);
            }
            intentos ++;
        }
    }




}
