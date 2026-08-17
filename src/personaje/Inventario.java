package personaje;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import utiles.Utiles;

public class Inventario {
    private final ArrayList<Objeto> items;
    private final int capacidadMaxima;

    public Inventario(int capacidadMaxima) {
        if (capacidadMaxima < 0) {
            throw new IllegalArgumentException("La capacidad no puede ser negativa");
        }
        items = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    public boolean agregarCosasInventario(Objeto nuevoObjeto) {
        if (nuevoObjeto == null || items.size() >= capacidadMaxima) {
            System.out.println(nuevoObjeto == null ? "Objeto invalido" : "INVENTARIO LLENO");
            return false;
        }
        items.add(nuevoObjeto);
        System.out.println("Guardaste " + nuevoObjeto.getNombre() + " en el inventario");
        return true;
    }

    public void mostrarInventario(Personaje personaje) {
        while (!items.isEmpty()) {
            ArrayList<Objeto> objetos = mostrarObjetos(false);
            System.out.println("1) Consumir objeto");
            System.out.println("2) Vender objeto");
            System.out.println("3) Salir");
            int opcion = Utiles.verificarEntero(1, 3);

            if (opcion == 3) {
                return;
            }

            Objeto objeto = seleccionarObjeto(objetos);
            if (opcion == 1) {
                consumir(objeto, personaje);
            } else {
                vender(objeto, personaje);
            }
        }
        System.out.println("Inventario vacio");
    }

    public void mostrarComida(Personaje personaje) {
        ArrayList<Objeto> comidas = mostrarObjetos(true);
        if (comidas.isEmpty()) {
            System.out.println("No tienes comida en el inventario");
            return;
        }

        System.out.println("Ingrese el numero de la comida que desea consumir");
        consumir(seleccionarObjeto(comidas), personaje);
    }

    public Objeto consumirObjeto(int opcion) {
        int indice = opcion - 1;
        if (indice < 0 || indice >= items.size()) {
            System.out.println("Ese objeto no existe");
            return null;
        }
        return items.remove(indice);
    }

    private void consumir(Objeto objeto, Personaje personaje) {
        if (objeto == null) {
            return;
        }
        items.remove(objeto);
        Usable usable = objeto;
        usable.aplicarEfecto(personaje.getMascota());
        System.out.println("Se consumio " + objeto.getNombre());
    }

    private void vender(Objeto objeto, Personaje personaje) {
        if (objeto == null) {
            return;
        }
        items.remove(objeto);
        personaje.modificarPlata(objeto.getPrecioVenta());
        System.out.println("Vendiste " + objeto.getNombre() + " por " + objeto.getPrecioVenta());
    }

    private Objeto seleccionarObjeto(ArrayList<Objeto> objetos) {
        System.out.println("Ingrese el numero del objeto");
        int opcion = Utiles.verificarEntero(1, objetos.size());
        return objetos.get(opcion - 1);
    }

    private ArrayList<Objeto> mostrarObjetos(boolean soloComida) {
        Map<String, Objeto> objetosPorNombre = new LinkedHashMap<>();
        Map<String, Integer> cantidades = new LinkedHashMap<>();

        for (Objeto item : items) {
            if (!soloComida || "comida".equalsIgnoreCase(item.getTipo())) {
                String clave = item.getNombre();
                objetosPorNombre.putIfAbsent(clave, item);
                cantidades.put(clave, cantidades.getOrDefault(clave, 0) + 1);
            }
        }

        ArrayList<Objeto> objetos = new ArrayList<>(objetosPorNombre.values());
        if (!objetos.isEmpty()) {
            System.out.println("------- INVENTARIO -------");
        }
        for (int i = 0; i < objetos.size(); i++) {
            Objeto item = objetos.get(i);
            int cantidad = cantidades.get(item.getNombre());
            System.out.println((i + 1) + ") " + item.getNombre() + " x" + cantidad
                    + " | Tipo: " + item.getTipo()
                    + " | Venta: " + item.getPrecioVenta());
        }
        return objetos;
    }
}
