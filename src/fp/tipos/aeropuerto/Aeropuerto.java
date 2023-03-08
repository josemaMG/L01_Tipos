package fp.tipos.aeropuerto;
import java.time.LocalDateTime;
import java.util.Objects;
public class Aeropuerto implements Comparable<Aeropuerto> {
	String codigo,origen,destino; 
	LocalDateTime fechaSalida; 
	Integer numeroPasajeros,numeroPlazas;
	public Aeropuerto(String codigo, String origen, String destino, LocalDateTime fechaSalida, Integer numeroPasajeros,Integer numeroPlazas) {
		if(fechaSalida.isAfter(LocalDateTime.now()) || numeroPasajeros>numeroPlazas || numeroPlazas<=0 || numeroPasajeros<=0) {
			throw new IllegalArgumentException();
		}
		this.codigo=codigo;
		this.origen=origen;
		this.destino=destino;
		this.fechaSalida=fechaSalida;
		this.numeroPlazas=numeroPlazas;
		this.numeroPasajeros=numeroPasajeros;
	}
	public Aeropuerto(String codigo, String origen, String destino, LocalDateTime fechaSalida, Integer numeroPlazas) {
		if(fechaSalida.isAfter(LocalDateTime.now()) || numeroPlazas<=0) {
			throw new IllegalArgumentException();
		}
		this.codigo=codigo;
		this.origen=origen;
		this.destino=destino;
		this.fechaSalida=fechaSalida;
		this.numeroPlazas=numeroPlazas;
		this.numeroPasajeros=0;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getOrigen() {
		return origen;
	}
	public String getDestino() {
		return destino;
	}
	public LocalDateTime getfechaSalida() {
		return fechaSalida;
	}
	public void setfechaSalida(LocalDateTime fechaSalida) {
		if(fechaSalida.isAfter(LocalDateTime.now())) {
			throw new IllegalArgumentException();
		}
		this.fechaSalida=fechaSalida;
	}
	public Integer getNumeroPlazas() {
		return numeroPlazas;
	}
	public void setNumeroPasajeros(Integer numeroPasajeros) {
		if(numeroPasajeros>numeroPlazas || numeroPasajeros<=0) {
			throw new IllegalArgumentException();
		}
		this.numeroPasajeros=numeroPasajeros;
	}
	public Boolean getCompleto() {
		return numeroPasajeros.equals(numeroPlazas);
	}
	public String CadenaFormato() {
		return "("+codigo+") "+origen+"-"+destino+ fechaSalida;
	}
	public String toString() {
		return "Vuelo( Código: "+codigo+", Origen: "+ origen+", Destino: "+destino+", Fecha de salida: "+fechaSalida+", Número de Pasajeros: "+numeroPasajeros+", Número de Plazas: "+numeroPlazas+", Completo: "+getCompleto()+", FormatoCorto: "+CadenaFormato()+")";
	}
	public int hashCode() {
		return Objects.hash(codigo, destino, fechaSalida, origen);
	}
	public boolean equals(Object obj) {
		boolean result=false;
		if (getClass() == obj.getClass()) {
			Aeropuerto other = (Aeropuerto) obj;
			result=Objects.equals(codigo, other.codigo) && Objects.equals(destino, other.destino)
					&& Objects.equals(fechaSalida, other.fechaSalida) && Objects.equals(origen, other.origen);
		}
		return result;
	}
	public int compareTo(Aeropuerto o) {
		int result=codigo.compareTo(o.codigo);
		if(result==0) {
			result=origen.compareTo(o.origen);
			if(result==0) {
				result=destino.compareTo(o.destino);
				if(result==0) {
					result=fechaSalida.compareTo(o.fechaSalida);
				}
			}
		}
		return result;
	}
}