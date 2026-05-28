package model;

public class RealidadVirtual extends Atraccion {

    private int cantidadEstaciones;
    private boolean requiereAnteojos;
    private boolean requiereMantenimiento;

    public RealidadVirtual(String nombre, String zonaUbicacion, int capacidadMaxima,
                            int edadMinimaAnios, int visitantesPorDia, double precioEntrada,
                            int cantidadEstaciones, boolean requiereAnteojos, boolean requiereMantenimiento) {
        super(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios, visitantesPorDia, precioEntrada);
        this.cantidadEstaciones = cantidadEstaciones;
        this.requiereAnteojos = requiereAnteojos;
        this.requiereMantenimiento = requiereMantenimiento;
    }

    /**
     * Calcula el ingreso diario de la atracción de realidad virtual, aplicando un descuento del 10% si no requiere anteojos.
     * @param requiereAnteojos indica si la atracción requiere anteojos o no
     * @return el ingreso diario calculado
     */
    @Override
    public double calcularIngresoDiario(boolean requiereAnteojos) {
        double ingreso = visitantesPorDia * precioEntrada;

        if (!requiereAnteojos) {
            ingreso = ingreso - (ingreso * 0.10);
        }

        return ingreso;
    }

    /**
     * Verifica si la atracción de realidad virtual requiere mantenimiento, considerando que se requiere mantenimiento si la cantidad de estaciones es mayor a 20 o si la cantidad de visitantes por día supera la capacidad máxima.
      * @param cantidadEstaciones cantidad de estaciones de realidad virtual
     * @param visitantesPorDia cantidad de visitantes por día
     * @param capacidadMaxima capacidad máxima de la atracción
     * @return true si requiere mantenimiento, false en caso contrario
     */
    public boolean determinarMantenimiento(int cantidadEstaciones, int visitantesPorDia, int capacidadMaxima) {
        if (cantidadEstaciones > 20 || visitantesPorDia > capacidadMaxima) {
            requiereMantenimiento = true;
        } else {
            requiereMantenimiento = false;
        }

        return requiereMantenimiento;

    }

    /**
    * Determina el nivel de riesgo de la atracción de realidad virtual, considerando si requiere o no anteojos, y la cantidad de estaciones.
    * @param cantidadEstaciones cantidad de estaciones de realidad virtual
    * @return el nivel de riesgo determinado (Alto, Medio o Bajo)
    */
    public String determinarRiesgo(boolean requiereAnteojos, int cantidadEstaciones) {
        String riesgo = null;

        if (requiereAnteojos && cantidadEstaciones > 20) {
            riesgo = "Alto";
        }

        if (!requiereAnteojos && cantidadEstaciones > 20 || requiereAnteojos && cantidadEstaciones <= 20) {
             riesgo = "Medio";

        }

        if (!requiereAnteojos && cantidadEstaciones <= 20) {
            riesgo = "Bajo";
        }

        return riesgo;

    }
}