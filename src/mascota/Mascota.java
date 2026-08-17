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
        this.energia = limitar(energia);
        this.felicidad = limitar(felicidad);
        this.hambre = limitar(hambre);
        this.suciedad = limitar(suciedad);
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

    public void modificarEnergia(int energia) {
        this.energia = limitar(this.energia + energia);
    }

    public void modificarFelicidad(int felicidad) {
        this.felicidad = limitar(this.felicidad + felicidad);
    }

    public void modificarHambre(int hambre) {
        this.hambre = limitar(this.hambre + hambre);
    }

    public void modificarSuciedad(int suciedad) {
        this.suciedad = limitar(this.suciedad + suciedad);
    }

    private int limitar(int valor) {
        return Math.max(0, Math.min(100, valor));
    }
}
