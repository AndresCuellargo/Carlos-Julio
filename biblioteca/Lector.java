public class Lector {
    public String id;
    public String nombre;
    public String correo;

    public Lector(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Lector [ID=" + id + ", Nombre=" + nombre + ", Correo=" + correo + "]";
    }
}
