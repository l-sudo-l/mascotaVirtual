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
        int suciedad = personaje.getMascota().getSuciedad();
        if(personaje.getMascota().getTipo()== Tipos.FUEGO){
            personaje.getMascota().modificarSuciedad(-(suciedad * 50 / 100));
        }
        else if (personaje.getMascota().getTipo() == Tipos.AGUA){
            personaje.getMascota().modificarSuciedad(-suciedad);
        }
        else if (personaje.getMascota().getTipo() == Tipos.TIERRA) {
            personaje.getMascota().modificarSuciedad(-(suciedad * 25 / 100));
        }
        else{
            System.out.println("ERROR");
        }
    }
}
