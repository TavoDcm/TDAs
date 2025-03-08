public class Main {
    public static void main(String[] args) {
        DiarioAventurero diario = new DiarioAventurero();

        diario.registrarMision("Derrotar al dragón", true);
        diario.registrarMision("Recuperar el artefacto perdido", true);
        diario.registrarMision("Explorar las ruinas antiguas", false);

        diario.mostrarMisiones();

        String misionBuscada = "Recuperar el artefacto perdido";
        if (diario.buscarMision(misionBuscada)) {
            System.out.println("La misión '" + misionBuscada + "' ya fue completada.");
        } else {
            System.out.println("La misión '" + misionBuscada + "' no ha sido completada.");
        }

        diario.editarMision("Recuperar el artefacto perdido", "Recuperar el artefacto mágico");

        diario.mostrarMisiones();

        diario.eliminarUltimaMisionFallida();

        diario.mostrarMisiones();
    }
}
