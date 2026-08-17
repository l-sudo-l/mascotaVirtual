import lugares.Baño;
import lugares.Dormitorio;
import lugares.Juego;
import lugares.Tienda;
import personaje.Personaje;
import utiles.Utiles;

public class IniciarMenu {
    public static void cargarMenu(Personaje personaje){
        int op = 0;
        do{
            System.out.println("ingrese la opcion deseada");
            System.out.println("1) jugar");
            System.out.println("2) comer");
            System.out.println("3) bañar");
            System.out.println("4) dormir");
            System.out.println("5) acceder al inventario");
            System.out.println("6) ir a la tienda");
            System.out.println("7) ver estadisticas");
            System.out.println("8) salir");
            op = Utiles.verificarEntero(1 ,  8);

            switch (op){
                case 1:
                    Juego zonaJuegos = new Juego();
                    zonaJuegos.iniciar(personaje);
                    break;

                case 2:
                    personaje.inventario().mostrarComida(personaje);
                    break;

                case 3:
                    Baño baño = new Baño();
                    baño.iniciar(personaje);
                    break;

                case 4:
                    Dormitorio dormir = new Dormitorio();
                    dormir.iniciar(personaje);
                    break;

                case 5:
                    personaje.inventario().mostrarInventario(personaje
                    );
                    break;

                case 6:
                    Tienda tienda = new Tienda();
                    tienda.iniciar(personaje);
                    break;

                case 7:
                    personaje.mostrarEstadistica();
                    break;
            }
        }while(op != 8);

    }
}
