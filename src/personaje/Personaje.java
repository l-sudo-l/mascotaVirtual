package personaje;
import mascota.Mascota;

import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private Mascota mascota;
    private int dinero = 500;
    private Inventario inventario;


    public Personaje(String nombre, Mascota mascota, Inventario inventario) {
            this.nombre = nombre;
            this.mascota = mascota;
            this.inventario = inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public int getDinero() {
        return dinero;
    }

    public Inventario inventario(){
        return inventario;
    }

    public void modificarPlata(int dinero){
        this.dinero += dinero;

    }
}
