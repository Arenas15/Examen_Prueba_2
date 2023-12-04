package Microsoft;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class GenerarJSON {
    public void generarArchivoJSON(EmpleadoImpl empleado, String nombreArchivo) {
        try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {
            String json = construirJSON(empleado);
            fileWriter.write(json);
            System.out.println("Archivo '" + nombreArchivo + "' creado exitosamente!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String construirJSON(EmpleadoImpl empleado) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");

        jsonBuilder.append("\"Nombre\": \"" + empleado.getNombre() + "\",\n");
        jsonBuilder.append("\"Apellido\": \"" + empleado.getApellido() + "\",\n");
        jsonBuilder.append("\"FechaIngreso\": \"" + empleado.getFechaIngreso() + "\",\n");
        jsonBuilder.append("\"FechaSalida\": \"" + empleado.getFechaSalida() + "\",\n");
        jsonBuilder.append("\"Sexo\": \"" + empleado.getSexo() + "\",\n");
        jsonBuilder.append("\"Ciudad\": \"" + empleado.getCiudad() + "\",\n");
        jsonBuilder.append("\"Posición\": \"" + empleado.getPosicion() + "\",\n");
        jsonBuilder.append("\"SalarioBase\": " + empleado.getSalarioBase() + "\n");

        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}
