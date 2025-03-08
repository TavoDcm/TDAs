import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

class Reservacion {
    String nombre;
    int asiento;

    public Reservacion(String nombre, int asiento) {
        this.nombre = nombre;
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Asiento: " + asiento;
    }
}

class GestorBoletos {
    private Queue<Reservacion> reservaciones;
    private TreeSet<Integer> asientosDisponibles;
    private int filas;
    private int asientosPorFila;

    public GestorBoletos(int filas, int asientosPorFila) {
        this.filas = filas;
        this.asientosPorFila = asientosPorFila;
        reservaciones = new LinkedList<>();
        asientosDisponibles = new TreeSet<>();
        for (int fila = 1; fila <= filas; fila++) {
            for (int asiento = 1; asiento <= asientosPorFila; asiento++) {
                asientosDisponibles.add((fila - 1) * asientosPorFila + asiento);
            }
        }
    }

    public void registrarReservacion(String nombre, int asiento) {
        if (asientosDisponibles.contains(asiento)) {
            reservaciones.offer(new Reservacion(nombre, asiento));
            asientosDisponibles.remove(asiento);
        } else {
            System.out.println("El asiento " + asiento + " ya está ocupado.");
        }
    }

    public void registrarReservacionAutomatica(String nombre) {
        if (!asientosDisponibles.isEmpty()) {
            int mejorAsiento = asientosDisponibles.first(); 
            registrarReservacion(nombre, mejorAsiento);
        } else {
            System.out.println("No hay asientos disponibles.");
        }
    }

    public boolean cancelarReservacion(int asiento) {
        for (Reservacion r : reservaciones) {
            if (r.asiento == asiento) {
                reservaciones.remove(r);
                asientosDisponibles.add(asiento);
                return true;
            }
        }
        return false;
    }

    public boolean estaOcupado(int asiento) {
        return !asientosDisponibles.contains(asiento);
    }

    public void mostrarReservaciones() {
        for (Reservacion r : reservaciones) {
            System.out.println(r);
        }
    }
}

public class Teatro {
    public static void main(String[] args) {
        GestorBoletos gestor = new GestorBoletos(5, 4); 
        
        gestor.registrarReservacion("Juan Pérez", 5);
        gestor.registrarReservacion("María López", 10);
        
        gestor.registrarReservacionAutomatica("Carlos Ramírez");
        gestor.registrarReservacionAutomatica("Ana Torres");
        
        System.out.println("Reservaciones actuales:");
        gestor.mostrarReservaciones();
        
        System.out.println("¿El asiento 10 está ocupado? " + gestor.estaOcupado(10));

        System.out.println("Cancelando la reservación del asiento 10...");
        gestor.cancelarReservacion(10);
        
        System.out.println("Reservaciones después de la cancelación:");
        gestor.mostrarReservaciones();
    }
}
