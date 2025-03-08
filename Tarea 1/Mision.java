public class Mision {
    private String descripcion;
    private boolean exitosa;

    public Mision(String descripcion, boolean exitosa) {
        this.descripcion = descripcion;
        this.exitosa = exitosa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean esExitosa() {
        return exitosa;
    }

    public void setDescripcion(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }

    public void setExitosa(boolean exitosa) {
        this.exitosa = exitosa;
    }

    @Override
    public String toString() {
        return descripcion + (exitosa ? " (Completada)" : " (Fallida)");
    }
}
