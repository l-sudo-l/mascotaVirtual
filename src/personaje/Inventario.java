package personaje;

import utiles.Utiles;

import java.util.ArrayList;

public class Inventario{

    private ArrayList<Objeto> items;
    private int capacidadMaxima;

    public Inventario(int capacidadMaxima) {
        this.items = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    public boolean agregarCosasInventario(Objeto nuevoObjeto){
        if(items.size() < capacidadMaxima){
            items.add(nuevoObjeto);
            System.out.println("Guardaste" + nuevoObjeto.getNombre() + "en el inventario");
            return true;
        }
        else{
            System.out.println("INVENTARIO LLENO");
            return false;
        }

    }

    public void mostrarInventario(){
        if (items.isEmpty()){
            System.out.println("inventario vacio");
            return;
        }
        System.out.println("-------INVENTARIO-------");
        for (int i = 0; i < items.size(); i++){
            System.out.println((i+1) + ") " + items.get(i).getNombre() +  " = "
                    + " TIPO " + items.get(i).getTipo()
                    + ", PRECIOVENTA " + items.get(i).getPrecioVenta()
                    + ", ENERGIA " + items.get(i).getEnergia()
                    + ", FELICIDAD " + items.get(i).getFelicidad()
                    + ", HAMBRE " + items.get(i).getHambre()
                    + ", SUCIEDAD " + items.get(i).getSuciedad());
        }

    }

    public Objeto consumirObjeto(int op){
        int indice = op - 1;
        if(indice >= 0 && indice < items.size()){
          Objeto itemUsado = items.remove(indice);
            System.out.println("se consumio el objeto " + itemUsado.getNombre());
            return itemUsado;
        }
        else{
            System.out.println("ese item no existe");
            return null;
        }
    }

    public void mostrarComida(){
        for (int i = 0 ; i < items.size(); i++){
            if (items.get(i).getTipo() == "comida" ){
                System.out.println((i+1) + items.get(i).getNombre() + " = "
                        + " TIPO " + items.get(i).getTipo()
                        + ", PRECIOVENTA " + items.get(i).getPrecioVenta()
                        + ", ENERGIA " + items.get(i).getEnergia()
                        + ", FELICIDAD " + items.get(i).getFelicidad()
                        + ", HAMBRE " + items.get(i).getHambre()
                        + ", SUCIEDAD " + items.get(i).getSuciedad()
                );
            }

        }

        System.out.println("ingrese el numero del objeto que desea consumir");
        int op = Utiles.verificarEntero(1 , items.size());
        consumirObjeto(op);

    }




}
