import mascota.Mascota;
import mascota.Mascotas;
import personaje.Inventario;
import personaje.Personaje;
import utiles.Utiles;

public class JuegoMascota {
    public void iniciar() {
        System.out.println("Bienvenido al juego de mascotas");
        System.out.println("Ingrese su nombre");
        String nombre = Utiles.verificarString();

        System.out.println("Ingrese el numero de la mascota que desea");
        for (int i = 0; i < Mascotas.values().length; i++) {
            System.out.println((i + 1) + ") Nombre: " + Mascotas.values()[i].getNombre()
                    + " | Tipo: " + Mascotas.values()[i].getTipo());
        }
        int opcion = Utiles.verificarEntero(1, Mascotas.values().length);
        Mascota mascota = Mascotas.values()[opcion - 1].getMascota();
        Personaje personaje = new Personaje(nombre, mascota, new Inventario(20));
        IniciarMenu.cargarMenu(personaje);
    }
}
