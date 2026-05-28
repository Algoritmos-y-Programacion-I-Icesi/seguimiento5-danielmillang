package model;

public class Infantiles extends Atraccion {

    private int edadMaximaAnios;
    private boolean tieneSupervision;

    public Infantiles(String nombre, String zonaUbicacion, int capacidadMaxima,
                      int edadMinimaAnios, int visitantesPorDia, double precioEntrada,
                      int edadMaximaAnios, boolean tieneSupervision) {
        super(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios, visitantesPorDia, precioEntrada);
        this.edadMaximaAnios = edadMaximaAnios;
        this.tieneSupervision = tieneSupervision;
    }

    /**
    * Calcula el ingreso diario de la atracción infantil, aplicando un recargo del 20% si tiene supervisión.
    * @param tieneSupervision indica si la atracción tiene supervisión o no
    * @return el ingreso diario calculado
    */
    @Override
    public double calcularIngresoDiario(boolean tieneSupervision) {
        double ingreso = visitantesPorDia * precioEntrada;

        if (tieneSupervision) {
            ingreso = ingreso + (visitantesPorDia * 50.000);
        }

        return ingreso;
    }

    /**
     * Determina si la atracción infantil requiere mantenimiento, considerando si tiene supervisión y la cantidad de visitantes por día.
     * @param tieneSupervision indica si la atracción tiene supervisión o no
     * @param visitantesPorDia cantidad de visitantes por día
     * @return true si requiere mantenimiento, false en caso contrario
     */
    public boolean determinarMantenimiento(boolean tieneSupervision, int visitantesPorDia) {
        boolean requiereMantenimiento = false;

        if (!tieneSupervision || visitantesPorDia > capacidadMaxima) {
            requiereMantenimiento = true;
        }

        return requiereMantenimiento;
    }
}