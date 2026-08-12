import personaje.Personaje;
import utiles.Utiles;
import mascota.*;
public class Main{

    public static void main(String[] args){

        System.out.println("bienvenido al juego de mascotas");
        System.out.println("ingrese su nombre");
        String nombre = Utiles.verificarString();

        System.out.println("ingrese el numero de la mascota  que deseas");
        for( int i = 0; i < Mascotas.values().length; i++){
            System.out.println((i+1) + " nombre: " +  Mascotas.values()[i].getNombre() + " tipo: " + Mascotas.values()[i].getTipo());
        }
        int op = Utiles.verificarEntero(1, 3);
        Mascota mascota = Mascotas.values()[op-1].getMascota();

        Personaje personaje = new Personaje(nombre , mascota);

        cargarMenu();
    }

    private static void cargarMenu(){
        int op = 0;
        do{
            System.out.println("ingrese la opcion deseada");
            System.out.println("1) jugar");
            System.out.println("2) comer");
            System.out.println("3) bañar");
            System.out.println("4) acceder al inventario");
            System.out.println("5) ir a la tienda");
            System.out.println("6) ver estadisticas");
            System.out.println("7) salir");
            op = Utiles.verificarEntero(1 ,  7);
        }while(op != 7);

    }
}


/*        for each declara una variable por cada iteracion del array*/
