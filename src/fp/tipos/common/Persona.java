package fp.tipos.common;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
//Se puede convertir en un record
public class Persona implements Comparable<Persona> {
	private String nombre,apellidos,dni,email;
	private LocalDate fechaNacimiento;
		
	public Persona(String cadena) {
		List<String> a=Arrays.asList(cadena.split(","));
		if(a.size()!=5) {
			throw new IllegalArgumentException();
		}
		if(a.get(0).trim().length()!=9) {
			throw new IllegalArgumentException();
		}
		if(!(Character.isDigit(a.get(0).trim().charAt(0)) || Character.isDigit(a.get(0).trim().charAt(1)) || Character.isDigit(a.get(0).trim().charAt(2)) || Character.isDigit(a.get(0).trim().charAt(3)) || Character.isDigit(a.get(0).trim().charAt(4)) || Character.isDigit(a.get(0).trim().charAt(5)) || Character.isDigit(a.get(0).trim().charAt(6)) || Character.isDigit(a.get(0).trim().charAt(7)) || Character.isAlphabetic(a.get(0).trim().charAt(8)))) {
			throw new IllegalArgumentException();
		}
		if(!(a.get(4).trim().contains("@"))) {
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
		this.email=a.get(4).trim();
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
		if (getClass() == obj.getClass()) {
			Persona other = (Persona) obj;
			result=Objects.equals(apellidos, other.apellidos) && Objects.equals(dni, other.dni)
					&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre);
		}
		return result;
	}
	public int compareTo(Persona o) {
		return dni.compareTo(o.dni);
	}
}


