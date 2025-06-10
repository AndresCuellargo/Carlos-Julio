import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú de Biblioteca ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Registrar lector");
            System.out.println("4. Registrar préstamo");
            System.out.println("5. Listar préstamos");
            System.out.println("6. Devolver libro");
            System.out.println("7. Filtro de libros por título");
            System.out.println("8. Buscar lector por ID");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion) {
                case 1: registrarLibro(); break;
                case 2: buscarLibroPorTitulo(); break;
                case 3: registrarLector(); break;
                case 4: registrarPrestamo(); break;
                case 5: listarPrestamos(); break;
                case 6: devolverLibro(); break;
                case 7: filtroLibrosPorTitulo(); break;
                case 8: buscarLectorPorId(); break;
                case 0: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    static void registrarLibro() {
        System.out.print("ISBN: ");
        String isbn = scan.nextLine();
        System.out.print("Título: ");
        String titulo = scan.nextLine();
        System.out.print("Autor: ");
        String autor = scan.nextLine();
        System.out.print("Género: ");
        String genero = scan.nextLine();
        System.out.print("Fecha de publicación (yyyy-mm-dd): ");
        String fecha = scan.nextLine();
        System.out.println(biblioteca.registrarLibro(isbn, titulo, autor, genero, fecha));
    }

    static void buscarLibroPorTitulo() {
        System.out.print("Título a buscar: ");
        String titulo = scan.nextLine();
        Libro libro = biblioteca.buscarPorTitulo(titulo);
        if (libro != null) {
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    static void registrarLector() {
        System.out.print("ID lector: ");
        String id = scan.nextLine();
        System.out.print("Nombre lector: ");
        String nombre = scan.nextLine();
        System.out.print("Correo lector: ");
        String correo = scan.nextLine();
        System.out.println(biblioteca.registrarLector(id, nombre, correo));
    }

    static void registrarPrestamo() {
        System.out.print("ID del lector: ");
        String idLector = scan.nextLine();
        System.out.print("Título del libro: ");
        String tituloLibro = scan.nextLine();
        System.out.println(biblioteca.registrarPrestamo(idLector, tituloLibro));
    }

    static void listarPrestamos() {
        biblioteca.listarPrestamos();
    }

    static void devolverLibro() {
        System.out.print("Título del libro a devolver: ");
        String titulo = scan.nextLine();
        System.out.println(biblioteca.devolverLibro(titulo));
    }

    static void filtroLibrosPorTitulo() {
        System.out.print("Ingrese parte del título para buscar: ");
        String filtro = scan.nextLine();
        biblioteca.mostrarLibrosPorTitulo(filtro);
    }

    static void buscarLectorPorId() {
        System.out.print("Ingrese el ID del lector: ");
        String id = scan.nextLine();
        biblioteca.mostrarLectorPorId(id);
    }
}
