package fp.tipos.futbol;

import java.time.LocalDateTime;
import java.util.Objects;

public record PartidoFutbol(LocalDateTime fecha, String equipoLocal, String equipoVisitante, Integer golesLocales, Integer golesVisitantes) {
	public PartidoFutbol {
		if(equipoLocal=="" || equipoVisitante=="" || golesLocales>0 || golesVisitantes>0) {
			throw new IllegalArgumentException();
		}
	}
	public ResultadoQuiniela resultado() {
		ResultadoQuiniela result;
		if (golesLocales>golesVisitantes) {
			result=ResultadoQuiniela.UNO;
		}
		else if (golesVisitantes==golesLocales) {
			result=ResultadoQuiniela.EQUIS;
		}
		else {
			result=ResultadoQuiniela.DOS;
		}
			return result;
	}
	public String cadenaConFormato() {
		String finish;
		Integer result=0;
		if (resultado()==ResultadoQuiniela.UNO) {
			result=1;
		}
		else {
			result=2;
		}
		if (result==0) {
			finish=fecha+"-> "+equipoLocal+" vs "+equipoVisitante+": "+golesLocales+"-"+golesVisitantes+" (X)";
		}
		else {
			finish=fecha+"-> "+equipoLocal+" vs "+equipoVisitante+": "+golesLocales+"-"+golesVisitantes+" ("+result+")";
		}
		return finish;
	}
	public String toString() {
		return "PartidoFutbol(Fecha: "+fecha+", Equipo local: "+equipoLocal+", Equipo visitante: "+equipoVisitante+", Goles locales: "+golesLocales+", Goles visitantes: "+golesVisitantes+", resultado: "+resultado()+")";
	}
	public int hashCode() {
		return Objects.hash(equipoLocal, equipoVisitante, fecha);
	}
	public boolean equals(Object obj) {
		boolean result=false;
		if(getClass()==obj.getClass()) {
			PartidoFutbol other = (PartidoFutbol) obj;
			result=Objects.equals(equipoLocal, other.equipoLocal) && Objects.equals(equipoVisitante, other.equipoVisitante)
					&& Objects.equals(fecha, other.fecha) && Objects.equals(golesLocales, other.golesLocales)
					&& Objects.equals(golesVisitantes, other.golesVisitantes);
		}
		return result;
	}
}
