package lugares;

import personaje.Objeto;
import personaje.Personaje;
import utiles.Utiles;

public class Tienda extends Lugar{

    public Tienda(){super("Tienda");}

    @Override
    public void iniciar(Personaje personaje){
        mostrarTienda(personaje);
    }

    public static void mostrarTienda(Personaje personaje){
        Objeto papasFritas = new Objeto("Papas Fritas " ,"comida", +5 , +2, -5 , -2 , +1, +5);
        Objeto pizza = new Objeto("Pizza " , "comida", 10 , 4 , -10, -4, +4, +6);
        Objeto hamburguesa = new Objeto("Hamburguesa ", "comida", 30, 10 , -25, -5, +5, +7);
        Objeto tacos = new Objeto("Tacos ", "comida" , 45, 20, -45, +2, +7, +8);
        Objeto sushi = new Objeto("Sushi ", "comida", 75, 30, -75, +4, +9, +1);
        Objeto pocionEnergetica = new Objeto("Pocion Energetica ", "pocion", 50, 20, 0, +30, 0, 0);
        Objeto pocionFelicidad = new Objeto("Pocion Felicidad ", "pocion", 50, 20, 0, 0, +30, 0);
        Objeto pocionAseo = new Objeto("Pocion Aseo ", "pocion", 40, 15, 0,0,0, -30);
        Objeto pocionNutritiva = new Objeto("Pocion Nutritiva ", "pocion", 40 , 15 , -30, 0,0,0);


        Objeto[] catalogo = {
            papasFritas, pizza, hamburguesa, tacos, sushi, pocionEnergetica, pocionFelicidad, pocionAseo, pocionNutritiva
        };
        for (int i = 0 ; i < catalogo.length ; i++){
            Objeto item = catalogo[i];
            System.out.println((i+1) + ") " + item.getNombre() + item.getPrecioCompra());
        }
        System.out.println("ingrsa el numero de la opcion que desea comprar");
        int op = Utiles.verificarEntero(1, catalogo.length);
        Objeto elegido = catalogo[op-1];


        if (personaje.getDinero() >= elegido.getPrecioCompra()) {
            if (personaje.inventario().agregarCosasInventario(elegido)) {
                personaje.modificarPlata(-elegido.getPrecioCompra());
            }
        }
        else if(personaje.getDinero()<elegido.getPrecioCompra()){
            System.out.println("ERROR: plata insuficiente");
        }
        else{
            System.out.println("ERROR");
        }

    }

}
