package fp.tipos.musica;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Cancion implements Comparable<Cancion> {
	private String titulo,artista;
	private Duration duracion;
	private LocalDate fechaLanzamiento;
	private Genero genero;
	public Cancion(String titulo, String artista) {
		this.titulo=titulo;
		this.artista=artista;
		this.duracion=Duration.of(0, ChronoUnit.SECONDS);
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista=artista;
	}
	public Duration getDuracion() {
		return duracion;
	}
	public void setDuracion(Duration duracion) {
		if(duracion.getSeconds()<0) {
			throw new IllegalArgumentException();
		}
		this.duracion=duracion;
	}
	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento=fechaLanzamiento;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero=genero;
	}
	public String formatoCorto() {
		return '"'+ titulo + '"' + " (" + artista +") " + duracion;
	}
	public String toString() {
		return "Cancion(Titulo: "+ titulo + ", Artista: " + artista + ", Duracion: " + duracion + ", Fecha de lanzamiento: "+ fechaLanzamiento + ", Género: " + genero + ", Formato corto(creado): " + formatoCorto()+")";
	}
	public int hashCode() {
		return Objects.hash(artista, titulo);
	}
	public boolean equals(Object obj) {
		boolean result=false;
		if (getClass() == obj.getClass()) {
			Cancion other = (Cancion) obj;
			result=Objects.equals(fechaLanzamiento, other.fechaLanzamiento) && Objects.equals(titulo, other.titulo);
		}
		return result;
	}
	public int compareTo(Cancion o) {
		int result=artista.compareTo(o.artista);
		if(result==0) {
			result=titulo.compareTo(o.titulo);
		}
		return result;
	}
}

