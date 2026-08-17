package lugares;

import personaje.Personaje;
import utiles.Utiles;

public class AdivinarNumero extends Minijuego {
    @Override
    public void jugar(Personaje personaje) {
        personaje.getMascota().modificarEnergia(-(personaje.getMascota().getEnergia() * 3 / 100));
        int apuesta = pedirApuesta(personaje);
        int secreto = Utiles.generarAleatorio(1, 10);

        for (int intento = 1; intento <= 3; intento++) {
            System.out.println("Intento " + intento + ": ingrese un numero del 1 al 10");
            int numero = Utiles.verificarEntero(1, 10);
            if (numero == secreto) {
                int multiplicador = 4 - intento;
                int premio = apuesta * multiplicador;
                personaje.modificarPlata(premio);
                personaje.getMascota().modificarFelicidad(personaje.getMascota().getFelicidad() * 5 / 100);
                System.out.println("Ganaste " + premio + " monedas");
                return;
            }
            if (numero < secreto) {
                System.out.println("El numero secreto es mayor");
            } else {
                System.out.println("El numero secreto es menor");
            }
        }

        personaje.modificarPlata(-apuesta);
        personaje.getMascota().modificarFelicidad(-(personaje.getMascota().getFelicidad() * 2 / 100));
        personaje.getMascota().modificarHambre(personaje.getMascota().getHambre() * 3 / 100);
        personaje.getMascota().modificarSuciedad(personaje.getMascota().getSuciedad() * 2 / 100);
        System.out.println("Perdiste " + apuesta + " monedas. El numero era " + secreto);
    }

    private int pedirApuesta(Personaje personaje) {
        int apuesta;
        do {
            System.out.println("Ingrese su apuesta (minimo 1, maximo 30)");
            apuesta = Utiles.verificarEntero(1, 30);
            if (apuesta > personaje.getDinero()) {
                System.out.println("Plata insuficiente");
            }
        } while (apuesta > personaje.getDinero());
        return apuesta;
    }
}
