package lugares;

import personaje.Personaje;
import utiles.Utiles;

public class CaraOCruz extends Minijuego {
    @Override
    public void jugar(Personaje personaje) {
        personaje.getMascota().modificarEnergia(-(personaje.getMascota().getEnergia() * 5 / 100));
        int apuesta = pedirApuesta(personaje);

        System.out.println("Elige una opcion: 1) cara  2) cruz");
        int eleccion = Utiles.verificarEntero(1, 2);
        int resultado = Utiles.generarAleatorio(1, 2);
        System.out.println(resultado == 1 ? "Salio cara" : "Salio cruz");

        if (eleccion == resultado) {
            int premio = apuesta * 2;
            personaje.modificarPlata(premio);
            personaje.getMascota().modificarFelicidad(apuesta * 10 / 100);
            System.out.println("Ganaste " + premio + " monedas");
        } else {
            personaje.modificarPlata(-apuesta);
            personaje.getMascota().modificarFelicidad(-(personaje.getMascota().getFelicidad() * 3 / 100));
            personaje.getMascota().modificarHambre(personaje.getMascota().getHambre() * 3 / 100);
            personaje.getMascota().modificarSuciedad(personaje.getMascota().getSuciedad() * 5 / 100);
            System.out.println("Perdiste " + apuesta + " monedas");
        }
    }

    private int pedirApuesta(Personaje personaje) {
        int apuesta;
        do {
            System.out.println("Ingrese su apuesta (minimo 1, maximo 50)");
            apuesta = Utiles.verificarEntero(1, 50);
            if (apuesta > personaje.getDinero()) {
                System.out.println("Plata insuficiente");
            }
        } while (apuesta > personaje.getDinero());
        return apuesta;
    }
}
