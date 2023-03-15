package fp.tipos.futbol;

import java.util.ArrayList;
import java.util.List;

public class Competicion {
	private String nombre;
	private Integer anyo;
	private List<PartidoFutbol> lista;
	public String getNombre() {
		return nombre;
	}
	public Integer getAnyo() {
		return anyo;
	}
	public List<PartidoFutbol> getLista() {
		return lista;
	}
	public Competicion(String nombre,Integer anyo) {
		if(nombre==null || anyo==null) {
			throw new IllegalArgumentException();
		}
		this.nombre=nombre;
		this.anyo=anyo;
		this.lista= new ArrayList<PartidoFutbol>();
	}
	public Integer getNumeroPartidos() {
		return lista.size();
	}
	public String toString() {
		return "Competicion (Nombre=" + nombre + ", Año=" + anyo + ", lista=" + lista + ", Numero de partidos="
				+ getNumeroPartidos() + ")";
	}
	public void incorporaPartido(PartidoFutbol p) {
		if(!(lista.contains(p))) {
			lista.add(p);
		}
	}
	public void incorporaPartidos(List<PartidoFutbol> partidos) {
		for(PartidoFutbol e:partidos) {
			incorporaPartido(e);
		}
	}
}
