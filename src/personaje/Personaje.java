package personaje;
import lugares.Juego;
import mascota.Mascota;

import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private Mascota mascota;
    private int dinero = 500;
    private ArrayList<Objeto> inventario = new ArrayList();

    public Personaje(String nombre, Mascota mascota) {
            this.nombre = nombre;
            this.mascota = mascota;
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

    public ArrayList<Objeto> getInventario() {
        return inventario;
    }
    public void modificarPlata(int dinero){
        this.dinero += dinero;


    }
}
