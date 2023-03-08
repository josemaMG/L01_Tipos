package fp.tipos.universidad;

import java.util.Objects;

public class Beca {
	String codigo;
	Double cuantiaTotal;
	Integer duracion;
	TipoBeca tipo;
	public 	Beca(String codigo,Double cuantiaTotal, Integer duracion, TipoBeca tipo) {
		if(!(Character.isAlphabetic(codigo.charAt(0)) && Character.isAlphabetic(codigo.charAt(2)) && Character.isDigit(codigo.charAt(3)) && Character.isDigit(codigo.charAt(4)) && Character.isDigit(codigo.charAt(5)) && Character.isDigit(codigo.charAt(6)))) {
			throw new IllegalArgumentException();
		}
		if(cuantiaTotal<1500.0 || duracion<1) {
			throw new IllegalArgumentException();
		}
		this.codigo=codigo;
		this.cuantiaTotal=cuantiaTotal;
		this.duracion=duracion;
		this.tipo=tipo;
	}
	public Beca() {
		this.cuantiaTotal=1500.0;
		this.duracion=1;
	}
	public Double cuantiaMensual() {
		return cuantiaTotal/duracion;
	}	public String getCodigo() {
		return codigo;
	}	public Double getCuantiaTotal() {
		return cuantiaTotal;
	}	public Integer getDuracion() {
		return duracion;
	}	public void setDuracion(Integer duracion) {
		if(duracion<=1) {
			throw new IllegalArgumentException();
		}
		this.duracion=duracion;
	}
	public int hashCode() {
		return Objects.hash(codigo);
	}
	public boolean equals(Object obj) {
		boolean result=false;
		if (getClass() == obj.getClass()) {
			Beca other = (Beca) obj;
			result= Objects.equals(codigo, other.codigo);
		}
		return result;
	}
	public TipoBeca getTipo() {
		return tipo;
	}
	public String toString() {
		return "Beca( Código: "+codigo+", Cuantia total: "+cuantiaTotal+", Duración: "+duracion+", Tipo: "+tipo+", Cuantia mensual: "+ cuantiaMensual()+")";
	}
}