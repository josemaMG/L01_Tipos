package fp.tipos.hoteles;

import java.util.Objects;
//Se puede convertir en un record.
public class Hotel{
	String nombre,direccion,ciudad,telefono,cadenaHotelera,descripcion;
	CategoriaHotelera categoria;
	TipoAlojamiento tipoAlojar;
	CategoriaPrecio precio;
	Float puntuacion;
	Integer comentario;
	Boolean admiteMascotas,estaAdaptado;
	Coordenada coordenada;
	public Hotel(String nombre,String direccion,String ciudad,String telefono,String cadenaHotelera,String descripcion,CategoriaHotelera categoria,TipoAlojamiento tipoAlojar,CategoriaPrecio precio,Float puntuacion,Integer comentario,Boolean admiteMascotas,Boolean estaAdaptado,Coordenada coordenada) {
		if(puntuacion==null || puntuacion<0) {
			throw new IllegalArgumentException();
		}
		if(comentario==null || comentario<0) {
			throw new IllegalArgumentException();
		}
		this.nombre=nombre;
		this.direccion=direccion;
		this.ciudad=ciudad;
		this.telefono=telefono;
		this.cadenaHotelera=cadenaHotelera;
		this.descripcion=descripcion;
		this.categoria=categoria;
		this.tipoAlojar=tipoAlojar;
		this.precio=precio;
		this.puntuacion=puntuacion;
		this.comentario=comentario;
		this.admiteMascotas=admiteMascotas;
		this.estaAdaptado=estaAdaptado;
		this.coordenada=coordenada;
	}
	public Hotel(String nombre,String direccion,String ciudad,String telefono,String cadenaHotelera,CategoriaHotelera categoria) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.ciudad=ciudad;
		this.telefono=telefono;
		this.cadenaHotelera=cadenaHotelera;
		this.categoria=categoria;
		this.precio=CategoriaPrecio.MEDIA;
		this.admiteMascotas=false;
		this.estaAdaptado=false;
	}
	public Hotel(String nombre,String cadenaHotelera,CategoriaHotelera categoria) {
		this.nombre=nombre;
		this.cadenaHotelera=cadenaHotelera;
		this.categoria=categoria;
		this.precio=CategoriaPrecio.MEDIA;
		this.admiteMascotas=false;
		this.estaAdaptado=false;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getCadenaHotelera() {
		return cadenaHotelera;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public CategoriaHotelera getCategoria() {
		return categoria;
	}
	public TipoAlojamiento getTipoAlojar() {
		return tipoAlojar;
	}
	public CategoriaPrecio getPrecio() {
		return precio;
	}
	public Float getPuntuacion() {
		return puntuacion;
	}
	public Integer getComentario() {
		return comentario;
	}
	public Boolean getAdmiteMascotas() {
		return admiteMascotas;
	}
	public Boolean getEstaAdaptado() {
		return estaAdaptado;
	}
	public Coordenada getCoordenada() {
		return coordenada;
	}
	public String cadenaFormato() {
		String result="N/A";
		if (categoria==CategoriaHotelera.UNA) {
			result="*";
		}
		else if (categoria==CategoriaHotelera.DOS) {
			result="**";
		}
		else if (categoria==CategoriaHotelera.TRES) {
			result="***";
		}
		else if (categoria==CategoriaHotelera.CUATRO) {
			result="****";
		}
		else if (categoria==CategoriaHotelera.CINCO) {
			result="*****";
		}
		return nombre+"("+result+")";
	}
	public String toString() {
		return "Hotel( Nombre: "+nombre+", Dirección: "+direccion+", Ciudad: "+ciudad+", Teléfono: "+telefono+", Cadena hotelera: "+cadenaHotelera+", Descripcion: "+descripcion+", Categoría: "+categoria+", Tipo de alojamiento: "+tipoAlojar+", Categoría(precio): "+precio+", Puntuación: "+puntuacion+", Nº comentarios: "+ comentario+", Admite mascotas: "+admiteMascotas+", Esta adaptado: "+estaAdaptado+", Coordenadas: "+coordenada+")";
	}
	public boolean equals(Object obj) {
		boolean result=false;
		if(getClass()==obj.getClass()) {
			Hotel other = (Hotel) obj;
			result=Objects.equals(admiteMascotas, other.admiteMascotas)
					&& Objects.equals(cadenaHotelera, other.cadenaHotelera) && categoria == other.categoria
					&& Objects.equals(ciudad, other.ciudad) && Objects.equals(comentario, other.comentario)
					&& Objects.equals(coordenada, other.coordenada) && Objects.equals(descripcion, other.descripcion)
					&& Objects.equals(direccion, other.direccion) && Objects.equals(estaAdaptado, other.estaAdaptado)
					&& Objects.equals(nombre, other.nombre) && precio == other.precio
					&& Objects.equals(puntuacion, other.puntuacion) && Objects.equals(telefono, other.telefono)
					&& tipoAlojar == other.tipoAlojar;
		}
		return result;
	}
}