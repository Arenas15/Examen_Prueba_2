package Microsoft;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmpleadoImpl implements Empleado {
	private String nombre;
    private String apellido;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private String sexo;
    private String ciudad;
    private String posicion;
    private double salarioBase;

    // Constructor
    public EmpleadoImpl(String nombre, String apellido, LocalDate fechaIngreso, LocalDate fechaSalida,
                       String sexo, String ciudad, String posicion, double salarioBase) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.posicion = posicion;
        this.salarioBase = salarioBase;
    }

    
    @Override
    public double calcularSalario() {
        return salarioBase * 0.83;
    }

    @Override
    public int calcularAntiguedad(LocalDate fechaActual) {
        return (int) ChronoUnit.YEARS.between(fechaIngreso, fechaActual);
    }

    @Override
    public boolean calcularRotacion() {
        boolean esIngeniero = this.posicion.equalsIgnoreCase("Ingeniero");
        int antiguedad = calcularAntiguedad(LocalDate.now());

        return esIngeniero && (antiguedad >= 2);
    }


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public LocalDate getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getPosicion() {
		return posicion;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}


	public double getSalarioBase() {
		return salarioBase;
	}


	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}


	@Override
	public String toString() {
		return "EmpleadoImpl [nombre=" + nombre + ", apellido=" + apellido + ", fechaIngreso=" + fechaIngreso
				+ ", fechaSalida=" + fechaSalida + ", sexo=" + sexo + ", ciudad=" + ciudad + ", posicion=" + posicion
				+ ", salarioBase=" + salarioBase + "]";
	}
}