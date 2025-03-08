import java.util.LinkedList;

public class DiarioAventurero {
    private LinkedList<Mision> misiones;

    public DiarioAventurero() {
        misiones = new LinkedList<>();
    }


    public void registrarMision(String descripcion, boolean exitosa) {
        misiones.addLast(new Mision(descripcion, exitosa));
        System.out.println("Misión registrada: " + descripcion + (exitosa ? " (Completada)" : " (Fallida)"));
    }


    public void eliminarUltimaMisionFallida() {
        if (!misiones.isEmpty()) {
            Mision ultimaMision = misiones.getLast();
            if (!ultimaMision.esExitosa()) {
                misiones.removeLast();
                System.out.println("Misión fallida eliminada: " + ultimaMision.getDescripcion());
            } else {
                System.out.println("La última misión fue completada y no se eliminará.");
            }
        } else {
            System.out.println("No hay misiones para eliminar.");
        }
    }


    public void mostrarMisiones() {
        if (misiones.isEmpty()) {
            System.out.println("No hay misiones registradas.");
        } else {
            System.out.println("Misiones registradas:");
            for (Mision mision : misiones) {
                System.out.println("- " + mision);
            }
        }
    }


    public boolean buscarMision(String descripcion) {
        for (Mision mision : misiones) {
            if (mision.getDescripcion().equalsIgnoreCase(descripcion)) {
                return true;
            }
        }
        return false;
    }

    public void editarMision(String descripcionAntigua, String descripcionNueva) {
        for (Mision mision : misiones) {
            if (mision.getDescripcion().equalsIgnoreCase(descripcionAntigua)) {
                mision.setDescripcion(descripcionNueva);
                System.out.println("Misión editada: '" + descripcionAntigua + "' -> '" + descripcionNueva + "'");
                return;
            }
        }
        System.out.println("La misión '" + descripcionAntigua + "' no fue encontrada.");
    }
}
