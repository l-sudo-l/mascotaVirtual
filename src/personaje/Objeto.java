package personaje;

import mascota.Mascota;

public class Objeto implements Usable {
        private String nombre;
        private String tipo;
        private int precioCompra;
        private int precioVenta;
        private int hambre;
        private int energia;
        private int felicidad;
        private int suciedad;


    public Objeto(String nombre, String tipo, int precioCompra, int precioVenta, int hambre, int energia, int felicidad, int suciedad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.hambre = hambre;
        this.energia = energia;
        this.felicidad = felicidad;
        this.suciedad = suciedad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public int getHambre() {
        return hambre;
    }

    public int getEnergia() {
        return energia;
    }

    public int getFelicidad() {
        return felicidad;
    }

    public int getSuciedad() {
        return suciedad;
    }

    @Override
    public void aplicarEfecto(Mascota mascota) {
        mascota.modificarEnergia(energia);
        mascota.modificarFelicidad(felicidad);
        mascota.modificarHambre(hambre);
        mascota.modificarSuciedad(suciedad);
    }

}
