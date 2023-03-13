package fp.tipos.futbol;

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
	
}
