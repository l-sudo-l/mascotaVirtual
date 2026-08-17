package personaje;
import mascota.Mascota;


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

    public void mostrarEstadistica(){
        System.out.println("nombre: " + nombre);
        System.out.println("dinero: " + dinero);
        System.out.println("nombre de la mascota: " + getMascota().getNombre());
        System.out.println("tipo de mascota: " + getMascota().getTipo());
        System.out.println("energia de la mascota: " + getMascota().getEnergia());
        System.out.println("hambre de la mascota: " + getMascota().getHambre());
        System.out.println("felicidad de la mascota: " + getMascota().getFelicidad());
        System.out.println("suciedad de la mascota: " + getMascota().getSuciedad());
    }
}
