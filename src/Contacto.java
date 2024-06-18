
public class Contacto {
    private String nombre;
    private String numero;

    // Constructor con nombre y número
    public Contacto(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    // Método para mostrar el contacto
    public String mostrarContacto() {
        return "Nombre del contacto: " + nombre + " Numero del contacto: " + numero + "\n";
    }


    // Método para obtener el nombre del contacto
    public String nombreContacto() {
        return nombre;
    }
}
