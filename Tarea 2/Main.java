import java.util.*;

class Cancion {
    String titulo;
    String artista;
    int duracion;

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "[" + titulo + " - " + artista + " (" + duracion + "s)]";
    }
}

class Playlist {
    private LinkedList<Cancion> canciones;
    private String nombre;

    public Playlist(String nombre) {
        this.nombre = nombre;
        canciones = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public void eliminarCancion(String titulo) {
        canciones.removeIf(cancion -> cancion.titulo.equalsIgnoreCase(titulo));
    }

    public void reproducirSiguiente() {
        if (!canciones.isEmpty()) {
            System.out.println("Reproduciendo: " + canciones.removeFirst());
        } else {
            System.out.println("No hay canciones en la playlist.");
        }
    }

    public void reproducirAleatorio() {
        if (!canciones.isEmpty()) {
            Collections.shuffle(canciones);
            System.out.println("Reproduciendo en orden aleatorio:");
            canciones.forEach(System.out::println);
        } else {
            System.out.println("No hay canciones en la playlist.");
        }
    }

    public void ordenarPorDuracion() {
        canciones.sort(Comparator.comparingInt(c -> c.duracion));
    }

    public void ordenarPorArtista() {
        canciones.sort(Comparator.comparing(c -> c.artista));
    }

    public void mostrarPlaylist() {
        if (canciones.isEmpty()) {
            System.out.println("La playlist \"" + nombre + "\" está vacía.");
        } else {
            System.out.println("Playlist: " + nombre);
            canciones.forEach(System.out::println);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Playlist> playlists = new ArrayList<>();
        
        Playlist rock = new Playlist("Rock Clásico");
        Playlist pop = new Playlist("Pop Moderno");
        
        playlists.add(rock);
        playlists.add(pop);
        
        rock.agregarCancion(new Cancion("Bohemian Rhapsody", "Queen", 355));
        rock.agregarCancion(new Cancion("Stairway to Heaven", "Led Zeppelin", 482));
        rock.agregarCancion(new Cancion("Hotel California", "Eagles", 391));
        rock.agregarCancion(new Cancion("Sweet Child O' Mine", "Guns N' Roses", 356));
        rock.agregarCancion(new Cancion("Smoke on the Water", "Deep Purple", 340));
        
        pop.agregarCancion(new Cancion("Shape of You", "Ed Sheeran", 240));
        pop.agregarCancion(new Cancion("Blinding Lights", "The Weeknd", 200));
        pop.agregarCancion(new Cancion("Uptown Funk", "Mark Ronson ft. Bruno Mars", 270));
        pop.agregarCancion(new Cancion("Rolling in the Deep", "Adele", 228));
        pop.agregarCancion(new Cancion("Can't Stop the Feeling!", "Justin Timberlake", 236));

        for (Playlist playlist : playlists) {
            playlist.mostrarPlaylist();
            System.out.println();
        }
        
        rock.reproducirAleatorio();
        System.out.println();
        pop.reproducirAleatorio();
    }
}