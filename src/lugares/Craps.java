package lugares;

import personaje.Personaje;
import utiles.Utiles;

public class Craps extends Minijuego {
    @Override
    public void jugar(Personaje personaje) {
        personaje.getMascota().modificarEnergia(-(personaje.getMascota().getEnergia() * 4 / 100));
        int apuesta = pedirApuesta(personaje);
        int suma = tirarDados();
        int intentos = 1;

        if (suma == 7 || suma == 11) {
            ganar(personaje, apuesta * 3 / 2);
            return;
        }
        if (suma == 2 || suma == 3 || suma == 12) {
            perder(personaje, apuesta, intentos);
            return;
        }

        System.out.println("Punto establecido: " + suma);
        int premioActual = apuesta;
        int minimo = Math.max(1, apuesta * 20 / 100);
        int descuento = Math.max(1, apuesta * 10 / 100);
        while (true) {
            intentos++;
            int nuevaSuma = tirarDados();
            if (nuevaSuma == suma) {
                ganar(personaje, premioActual);
                return;
            }
            if (nuevaSuma == 7) {
                perder(personaje, apuesta, intentos);
                return;
            }
            premioActual = Math.max(minimo, premioActual - descuento);
            System.out.println("El premio posible ahora es " + premioActual);
        }
    }

    private int pedirApuesta(Personaje personaje) {
        int apuesta;
        do {
            System.out.println("Ingrese su apuesta (minimo 1, maximo 200)");
            apuesta = Utiles.verificarEntero(1, 200);
            if (apuesta > personaje.getDinero()) {
                System.out.println("Plata insuficiente");
            }
        } while (apuesta > personaje.getDinero());
        return apuesta;
    }

    private int tirarDados() {
        int suma = Utiles.generarAleatorio(1, 6) + Utiles.generarAleatorio(1, 6);
        System.out.println("Resultado de los dados: " + suma);
        return suma;
    }

    private void ganar(Personaje personaje, int premio) {
        personaje.modificarPlata(premio);
        personaje.getMascota().modificarFelicidad(premio * 3 / 100);
        System.out.println("Ganaste " + premio + " monedas");
    }

    private void perder(Personaje personaje, int apuesta, int intentos) {
        personaje.modificarPlata(-apuesta);
        personaje.getMascota().modificarFelicidad(-(personaje.getMascota().getFelicidad() * intentos / 100));
        personaje.getMascota().modificarHambre(personaje.getMascota().getHambre() * 4 / 100);
        personaje.getMascota().modificarSuciedad(personaje.getMascota().getSuciedad() * 4 / 100);
        System.out.println("Perdiste " + apuesta + " monedas");
    }
}
