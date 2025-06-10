import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros = new ArrayList<>();
    private List<Lector> lectores = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();

    public String registrarLibro(String isbn, String titulo, String autor, String genero, String fechaPublicacion) {
        for (Libro l : libros) {
            if (l.isbn.equals(isbn)) return "Error: ISBN ya registrado.";
        }
        try {
            LocalDate fecha = LocalDate.parse(fechaPublicacion);
            libros.add(new Libro(isbn, titulo, autor, genero, fecha));
            return "Libro registrado exitosamente.";
        } catch (DateTimeParseException e) {
            return "Fecha inválida.";
        }
    }

    public Libro buscarPorTitulo(String titulo) {
        for (Libro l : libros) {
            if (l.titulo.equalsIgnoreCase(titulo)) return l;
        }
        return null;
    }

    public String registrarLector(String id, String nombre, String correo) {
        for (Lector l : lectores) {
            if (l.id.equals(id)) return "Error: ID de lector ya existe.";
        }
        lectores.add(new Lector(id, nombre, correo));
        return "Lector registrado correctamente.";
    }

    public Lector buscarLectorPorId(String id) {
        for (Lector l : lectores) {
            if (l.id.equalsIgnoreCase(id)) return l;
        }
        return null;
    }

    public String registrarPrestamo(String idLector, String tituloLibro) {
        Lector lector = buscarLectorPorId(idLector);
        if (lector == null) return "Error: Lector no encontrado.";

        Libro libro = buscarPorTitulo(tituloLibro);
        if (libro == null) return "Error: Libro no encontrado.";

        if (libro.prestado) return "Error: El libro ya está prestado.";

        libro.prestado = true;
        prestamos.add(new Prestamo(libro, lector));
        return "Préstamo registrado exitosamente.";
    }

    public void listarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
        } else {
            for (Prestamo p : prestamos) {
                System.out.println(p);
            }
        }
    }

    public String devolverLibro(String tituloLibro) {
        for (Prestamo p : prestamos) {
            if (p.libro.titulo.equalsIgnoreCase(tituloLibro)) {
                if (p.libro.prestado) {
                    p.libro.prestado = false;
                    prestamos.remove(p);
                    return "Libro devuelto exitosamente.";
                }
            }
        }
        return "Error: El libro no está en préstamo o no existe.";
    }

    

    public void mostrarLibrosPorTitulo(String filtro) {
        boolean encontrado = false;
        for (Libro l : libros) {
            if (l.titulo.toLowerCase().contains(filtro.toLowerCase())) {
                System.out.println(l);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros con ese título.");
        }
    }

    public void mostrarLectorPorId(String id) {
        Lector l = buscarLectorPorId(id);
        if (l != null) {
            System.out.println(l);
        } else {
            System.out.println("No se encontró un lector con ese ID.");
        }
    }
}
