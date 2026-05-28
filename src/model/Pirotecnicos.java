package model;

public class Pirotecnicos extends Atraccion {

    private int duracionMinutos;
    private boolean materialPeligroso;

    public Pirotecnicos(String nombre, String zonaUbicacion, int capacidadMaxima,
                        int edadMinimaAnios, int visitantesPorDia, double precioEntrada,
                        int duracionMinutos, boolean materialPeligroso) {
        super(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios, visitantesPorDia, precioEntrada);
        this.duracionMinutos = duracionMinutos;
        this.materialPeligroso = materialPeligroso;
    }

    /**
     * Calcula el ingreso diario de la atracción pirotécnica, aplicando un recargo del 20% si utiliza material peligroso.
     * @param materialPeligroso indica si la atracción utiliza material peligroso o no
     * @return el ingreso diario calculado
     */
    @Override
    public double calcularIngresoDiario(boolean materialPeligroso) {
        double ingreso = visitantesPorDia * precioEntrada;

        if (materialPeligroso) {
            ingreso = ingreso - (ingreso * 0.20);
        }

        return ingreso;
    }

    public boolean determinarMantenimiento(boolean materialPeligroso, int duracionMinutos) {
        boolean requiereMantenimiento = false;

        if (materialPeligroso || duracionMinutos > 60) {
            requiereMantenimiento = true;
        }

        return requiereMantenimiento;
    }

    public String determinarRiesgo(boolean materialPeligroso, int duracionMinutos) {
        String riesgo = null;

        if (materialPeligroso) {
            riesgo = "Alto";
        } 
        if (!materialPeligroso && duracionMinutos > 60) {
            riesgo = "Medio";
        } 
        if (!materialPeligroso && duracionMinutos <= 60) {
            riesgo = "Bajo";
        }

        return riesgo;
    }
}