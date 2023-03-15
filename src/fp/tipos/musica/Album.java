package fp.tipos.musica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Album {
	private String nombre,id;
	private Integer popularidad,anyo;
	private TipoAlbum tipo;
	private List<Cancion> canciones;
	private List<String> imagenes;
	
	public boolean equals(Object obj) {
		boolean result=false;
		if (getClass() == obj.getClass()) {
		Album other= (Album) obj;
		result=Objects.equals(id, other.id);
		}
		return result;
	}
	public String toString() {
		return "Album (nombre=" + nombre + ", id=" + id + ", popularidad=" + popularidad + ", anyo=" + anyo+ ", canciones=" + canciones + ", imágenes=" + imagenes + ")";
	}
	public Album(String nombre,String id,Integer popularidad,Integer anyo,TipoAlbum tipo) {
		if(id.length()!=22 || popularidad<0 || popularidad>100){
			throw new IllegalArgumentException();
		}
		this.nombre=nombre;
		this.id=id;
		this.popularidad=popularidad;
		this.anyo=anyo;
		this.tipo=tipo;
		this.canciones=new ArrayList<Cancion>();
		this.imagenes=new ArrayList<String>();
	}
	public String getNombre() {
		return nombre;
	}
	public String getId() {
		return id;
	}
	public Integer getPopularidad() {
		return popularidad;
	}
	public Integer getAnyo() {
		return anyo;
	}
	public List<Cancion> getCanciones() {
		return canciones;
	}
	public List<String> getImagenes() {
		return imagenes;
	}
	public void incorporaCancion(Cancion c) {
		if(!(canciones.contains(c))){
			canciones.add(c);
		}
	}
	public void incorporaCancion(Cancion c, int posicion) {
		if(posicion<0 || posicion>canciones.size()) {
			throw new IllegalArgumentException();
		}
		if(!(canciones.contains(c))) {
			canciones.add(posicion, c);
		}
	}
	public void eliminaCancion(Cancion c) { 
		if(!(canciones.contains(c))) {
			canciones.remove(canciones.indexOf(c));
		}
	}
	public void eliminaCancion(int posicion) {
		if(posicion<0 || posicion>=canciones.size()) {
			throw new IllegalArgumentException();
		}
		canciones.remove(posicion);
	}
	public void incorporaImagen(String ruta) {
		if(ruta.startsWith("http")) {
			imagenes.add(ruta);
		}
	}
	public void eliminaImagen(int posicion) {
		if(posicion<0 || posicion>=imagenes.size()) {
			throw new IllegalArgumentException();
		}
		imagenes.remove(posicion);
	}
	public TipoAlbum getTipo() {
		return tipo;
	}
}
