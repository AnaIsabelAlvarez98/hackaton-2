import java.util.*;

public class Agenda {
    private Contacto[] contactos;
    private int numContactos;

    // Constructor con tamaño específico
    public Agenda(int size) {
        this.contactos = new Contacto[size];
        this.numContactos = 0;
    }

    // Constructor con tamaño por defecto de 10
    public Agenda() {
        this(10);
    }
//Metodo para traer la información y retorna contactos
    public Contacto[] getContactos() {
        return contactos;
    }

    // Método para añadir un contacto
    public void añadirContacto(Contacto c) {
        if (numContactos >= contactos.length) {
            System.out.println("No se pueden añadir más contactos. La agenda está llena.");
            return;
        }
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].nombreContacto().equalsIgnoreCase(c.nombreContacto())) { //equalsIgnoreCase() se usa para convertir el string a minuscula y así no haya error en la búsqueda
                System.out.println("El contacto ya existe en la agenda.");
                return;
            }
        }
        contactos[numContactos++] = c;
        System.out.println("Contacto añadido.");
    }

    // Método para listar todos los contactos
    public void listarContactos() {
        for (int i = 0; i < numContactos; i++) {
            System.out.println(contactos[i].mostrarContacto());
        }
    }

    // Método para buscar un contacto por nombre
    public void buscaContacto(String nombre) {
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].nombreContacto().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado: " + contactos[i].mostrarContacto());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // Método para eliminar un contacto
    public void eliminarContacto(String nombre) {
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].nombreContacto().equalsIgnoreCase(nombre)) {
                for (int j = i; j < numContactos - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }
                contactos[--numContactos] = null;
                System.out.println("Contacto eliminado.");
                return;
            }
        }
        System.out.println("El contacto no se encontró en la agenda.");
    }

    // Método para comprobar si la agenda está llena
    public boolean agendaLlena() {
        return numContactos >= contactos.length;
    }

    // Método para indicar cuántos contactos más se pueden añadir
    public int espacioLibres() {
        return contactos.length - numContactos;
    }
}
