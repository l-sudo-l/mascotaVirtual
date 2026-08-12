package mascota;

public enum Mascotas {


    MECCA("mecca", 50 ,  50 , 50 , 50, Tipos.TIERRA),
    KIBO("kibo", 50 ,  50 , 50 , 50, Tipos.FUEGO),
    KOI("koi", 50 ,  50 , 50 , 50, Tipos.AGUA);

    private String nombre;
    private int energia;
    private int felicidad;
    private int hambre;
    private int suciedad;
    private Tipos tipo;

    Mascotas(String nombre, int energia, int felicidad, int hambre, int suciedad, Tipos tipo) {
        this.nombre = nombre;
        this.energia = energia;
        this.felicidad = felicidad;
        this.hambre = hambre;
        this.suciedad = suciedad;
        this.tipo = tipo;
    }

    public Mascota getMascota() {
        return new Mascota(nombre, energia, felicidad, hambre, suciedad, tipo);
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
}
