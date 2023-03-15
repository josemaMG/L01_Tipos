package fp.tipos.musica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ListaReproduccion {
	private String nombre;
	private List<Cancion> canciones;
	
	public ListaReproduccion(String nombre) {
		this.nombre=nombre;
		this.canciones= new ArrayList<Cancion>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Cancion> getCanciones() {
		return canciones;
	}
	
	public Integer getNumeroCanciones() {
		return canciones.size();
	}
	
	public void aleatoriza() {
		Collections.shuffle(canciones);
	}
	
	public void incorpora(Cancion c) {
		canciones.add(c);
	}
	
	public void incorpora(Album a) {
		for(Cancion e:a.getCanciones()) {
			canciones.add(e);
		}
	}
	
	public void incorpora(List<Cancion> canciones) {
		for(Cancion e:canciones) {
			this.canciones.add(e);
		}
	}
	public void eliminaPrimera(Cancion c) {
		if(!(canciones.contains(c))) {
			throw new IllegalArgumentException();
		}
	canciones.remove(canciones.indexOf(c));
	}
	
	public void eliminaUltima(Cancion c) {
		if(!(canciones.contains(c))) {
			throw new IllegalArgumentException();
		}
		canciones.remove(canciones.lastIndexOf(c));
	}
	
	public void eliminaTrozo(int primeraPosicion, int ultimaPosicion) {
		if (primeraPosicion<0 || ultimaPosicion>canciones.size()-2 || primeraPosicion>ultimaPosicion) {
			throw new IllegalArgumentException();
		}
		for (int e=ultimaPosicion-primeraPosicion; e==0 ; e--) {
			canciones.remove(primeraPosicion);
		}
	}

	public int hashCode() {
		return Objects.hash(canciones, nombre);
	}

	public boolean equals(Object obj) {
		boolean result=false;
		if (getClass() == obj.getClass()) {
		ListaReproduccion other = (ListaReproduccion) obj;
		result= Objects.equals(canciones, other.canciones) && Objects.equals(nombre, other.nombre);
		}
		return result;
	}
	
	public String toString() {
		return nombre +"("+getNumeroCanciones()+" canciones)";
	}
}
