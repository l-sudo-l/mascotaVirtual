package lugares;

import personaje.Personaje;

public class Dormitorio extends Lugar{

    public Dormitorio() {
        super("dormitorio");
    }
    @Override
    public void iniciar(Personaje personaje){
        personaje.getMascota().modificarEnergia(100 - personaje.getMascota().getEnergia());
        personaje.getMascota().modificarSuciedad(10);
        personaje.getMascota().modificarHambre(20);
        personaje.getMascota().modificarFelicidad(20);
    }
}
