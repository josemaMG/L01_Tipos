package fp.tipos.common;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Persona {
	private String nombre,apellidos,dni;
	private LocalDate fechaNacimiento;
		
	public Persona(String cadena) {
		List<String> a=Arrays.asList(cadena.split(","));
		if(a.size()!=4) {
			throw new IllegalArgumentException();
		}
		LocalDate fechanacimiento=LocalDate.parse(a.get(3).trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		if(fechaNacimiento.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException();
		}
		this.nombre=a.get(0).trim();
		this.apellidos=a.get(1).trim();
		this.dni=a.get(2).trim();
		this.fechaNacimiento=fechanacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getDni() {
		return dni;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public Integer getEdad() {
		return LocalDate.now().until(fechaNacimiento).getYears();
	}
	public String toString() {
		return "Persona (nombre="+nombre+", apellidos="+apellidos+", dni="+dni+", fechaNacimiento="+fechaNacimiento+", Edad="+getEdad()+")";
	}
	public int hashCode() {
		return Objects.hash(apellidos, dni, fechaNacimiento, nombre);
	}
	public boolean equals(Object obj) {
		boolean result=false;
		if (getClass() == obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(dni, other.dni)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre);
	}
}


