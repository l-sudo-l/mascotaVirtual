package lugares;

import personaje.Personaje;

public abstract class Lugar {
    private String nombre;

    public Lugar(String nombre) {
        this.nombre = nombre;
    }

    public abstract void iniciar(Personaje personaje);

    public String getNombre() {
        return nombre;
    }

}
