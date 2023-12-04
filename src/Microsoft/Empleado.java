package Microsoft;

import java.time.LocalDate;

public interface Empleado {
    double calcularSalario();
    boolean calcularRotacion();
	int calcularAntiguedad(LocalDate fechaActual);
}