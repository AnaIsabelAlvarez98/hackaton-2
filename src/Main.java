import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Agenda agenda = new Agenda();

        while (true) {
            System.out.println("Espacio de contactos disponible: " + agenda.espacioLibres());
            System.out.println("Espacio total: " + agenda.getContactos().length);
            System.out.println("Bienvenido/a a tu agenda ");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Comprobar si la agenda está llena");
            System.out.println("6. Ver espacios libres");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            int respuesta = entrada.nextInt();
            entrada.nextLine();

            switch (respuesta) {
                case 1:
                    while (true) {
                        System.out.println("Por favor ingrese el nombre del contacto");
                        String nombre = entrada.nextLine();

                        System.out.println("Ingrese el número del contacto");
                        String numero = entrada.nextLine();

                        Contacto contacto = new Contacto(nombre, numero);
                        agenda.añadirContacto(contacto);

                        System.out.println("¿Desea añadir otro contacto? (s/n): ");
                        String continuar = entrada.nextLine();
                        if (!continuar.equalsIgnoreCase("s")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Mostrando todos los contactos:");
                    agenda.listarContactos();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del contacto a buscar:");
                    String nombreBuscar = entrada.nextLine();
                    agenda.buscaContacto(nombreBuscar);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del contacto a eliminar:");
                    String nombreEliminar = entrada.nextLine();
                    agenda.eliminarContacto(nombreEliminar);
                    break;
                case 5:
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena.");
                    } else {
                        System.out.println("La agenda no está llena.");
                    }
                    break;
                case 6:
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
                    break;
                case 7:
                    System.out.println("Saliendo de la agenda...");
                    entrada.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
