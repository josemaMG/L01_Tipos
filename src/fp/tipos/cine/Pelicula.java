package fp.tipos.cine;
import java.time.*;
import java.util.Objects;

public class Pelicula implements Comparable<Pelicula> {
	private String titulo;
	private LocalDate fechaEstreno;
	private Integer duracion;
	public Pelicula(String titulo, LocalDate fechaestreno, Integer duracion) {
		if(titulo==null) {
			throw new IllegalArgumentException();
		}
		if(duracion<=0) {
			throw new IllegalArgumentException();
		}
		this.titulo=titulo;
		this.fechaEstreno=fechaestreno;
		this.duracion=duracion;
	}
	public Pelicula(String titulo) {
		if(titulo==null) {
			throw new IllegalArgumentException();
		}
		this.titulo=titulo;
	}
	public String getTitulo() {
		return titulo;
	}
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	public void setDuracion(Integer duracion) {
		if(duracion<=0) {
			throw new IllegalArgumentException();
		}
		this.duracion=duracion;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno=fechaEstreno;
	}
	public TipoMetraje metraje() {
		TipoMetraje result;
		if (duracion<30) {
			result=TipoMetraje.CORTOMETRAJE;
		}
		else if (30<duracion && duracion<=60) {
			result=TipoMetraje.MEDIOMETRAJE;
		}
		else {
			result=TipoMetraje.LARGOMETRAJE;
		}
		return result;
	}
	public String formatoCorto() {
		String result;
		if (fechaEstreno==null) {
			result=titulo;
		}
		else {
			result=titulo+'('+fechaEstreno+')';
		}
		return result;
	}
	public String toString() {
		return "Película(Título: "+titulo+", Fecha de estreno: "+fechaEstreno+", Tipo de metraje: "+metraje()+", Formato corto:"+formatoCorto()+')';
	}
	public int hashCode() {
		return Objects.hash(fechaEstreno, titulo);
	}
	public boolean equals(Object obj) {
		boolean result=false;
		if(getClass()==obj.getClass()) {
			Pelicula other = (Pelicula) obj;
			result= Objects.equals(fechaEstreno, other.fechaEstreno) && Objects.equals(titulo, other.titulo);
		}
		return result;
	}
	@Override
	public int compareTo(Pelicula o) {
		int result=fechaEstreno.compareTo(o.fechaEstreno);
		if(result==0) {
			result=titulo.compareTo(o.titulo);
		}
		return result;
	}
}