package lugares;

import personaje.Personaje;
import utiles.Utiles;

public class Juego extends Lugar {
    public Juego() {
        super("juego");
    }

    @Override
    public void iniciar(Personaje personaje) {
        System.out.println("1) Cara o cruz");
        System.out.println("2) Craps");
        System.out.println("3) Adivinar el numero");
        int opcion = Utiles.verificarEntero(1, 3);
        Minijuego minijuego;

        switch (opcion) {
            case 1:
                minijuego = new CaraOCruz();
                break;
            case 2:
                minijuego = new Craps();
                break;
            default:
                minijuego = new AdivinarNumero();
                break;
        }
        minijuego.jugar(personaje);
    }
}
