package mascota;

public class Mascota {
    private String nombre;
    private int energia;
    private int felicidad;
    private int hambre;
    private int suciedad;
    private Tipos tipo;

    public Mascota(String nombre, int energia, int felicidad, int hambre, int suciedad, Tipos tipo) {
        this.nombre = nombre;
        this.energia = energia;
        this.felicidad = felicidad;
        this.hambre = hambre;
        this.suciedad = suciedad;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public int getFelicidad() {
        return felicidad;
    }

    public int getHambre() {
        return hambre;
    }

    public int getSuciedad() {
        return suciedad;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void modificarEnergia(int energia){
            this.energia += energia;
    }

    public void modificarFelicidad(int felicidad){
        this.felicidad += felicidad;
    }

    public void modificarHambre(int hambre){
        this.hambre += hambre;
    }

    public void modificarSuciedad(int suciedad){
        this.suciedad += suciedad;

    }
}
