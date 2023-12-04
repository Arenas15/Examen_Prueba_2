package Microsoft;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmpleadoImpl empleado = null;
        boolean informacionCorrecta = false;

        do {
            System.out.println("Ingrese el nombre del empleado:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el apellido del empleado:");
            String apellido = scanner.nextLine();

            LocalDate fechaIngreso = ingresarFecha("Ingrese la fecha de ingreso (Año-Mes-Día):", scanner);

            System.out.println("Ingrese la fecha de salida (Año-Mes-Día) o deje en blanco si sigue trabajando:");
            LocalDate fechaSalida = null;
            String fechaSalidaStr = scanner.nextLine();
            if (!fechaSalidaStr.isEmpty()) {
                fechaSalida = ingresarFecha("Ingrese una fecha válida para la salida (Año-Mes-Día):", scanner);
            }

            System.out.println("Ingrese el sexo:");
            String sexo = scanner.nextLine();

            System.out.println("Ingrese la ciudad:");
            String ciudad = scanner.nextLine();

            System.out.println("Ingrese la posición:");
            String posicion = scanner.nextLine();

            double salarioBase = ingresarSalario("Ingrese el salario base:", scanner);

            empleado = new EmpleadoImpl(nombre, apellido, fechaIngreso, fechaSalida, sexo, ciudad, posicion, salarioBase);

            System.out.println("\nInformación del empleado:");
            System.out.println(empleado);
            mostrarInformacionAdicional(empleado);

            System.out.println("¿Es esta la información correcta? (Sí/No):");
            String respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("sí") || respuesta.equals("si")) {
                informacionCorrecta = true;
            }

        } while (!informacionCorrecta);

        // Crear un objeto GenerarJSON y generar el archivo JSON
        if (empleado != null) {
            GenerarJSON generarJSON = new GenerarJSON();
            generarJSON.generarArchivoJSON(empleado, "informacion_empleado.json");
        }

        scanner.close();
    }

    private static LocalDate ingresarFecha(String mensaje, Scanner scanner) {
        LocalDate fecha = null;
        boolean fechaValida = false;

        do {
            try {
                System.out.println(mensaje);
                fecha = LocalDate.parse(scanner.nextLine());
                fechaValida = true;
            } catch (Exception e) {
                System.out.println("Por favor, ingrese una fecha válida en el formato correcto (Año-Mes-Día).");
            }
        } while (!fechaValida);

        return fecha;
    }

    private static double ingresarSalario(String mensaje, Scanner scanner) {
        double salario = 0;
        boolean salarioValido = false;

        do {
            try {
                System.out.println(mensaje);
                salario = Double.parseDouble(scanner.nextLine());
                salarioValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido para el salario.");
            }
        } while (!salarioValido);

        return salario;
    }

    private static void mostrarInformacionAdicional(Empleado empleado) {
        System.out.println("\nInformación adicional:");
        System.out.println("Salario final: " + empleado.calcularSalario());
        System.out.println("Antigüedad laboral: " + empleado.calcularAntiguedad(LocalDate.now()) + " años");
        System.out.println("Rotación: " + (empleado.calcularRotacion() ? "Habilitada" : "No habilitada"));
    }
}