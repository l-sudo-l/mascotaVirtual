package lugares;

import mascota.Tipos;
import personaje.Personaje;

public class Baño extends Lugar{


    public Baño() {
        super("baño");
    }

    @Override
    public void iniciar(Personaje personaje) {
        bañarse(personaje);
    }

    public static void bañarse(Personaje personaje){
        if(personaje.getMascota().getTipo()== Tipos.FUEGO){
            personaje.getMascota().modificarSuciedad(-50);
        }
        else if (personaje.getMascota().getTipo() == Tipos.AGUA){
            personaje.getMascota().modificarSuciedad(-100);
        }
        else if (personaje.getMascota().getTipo() == Tipos.TIERRA) {
            personaje.getMascota().modificarSuciedad(-25);
        }
        else{
            System.out.println("ERROR");
        }
    }
}
