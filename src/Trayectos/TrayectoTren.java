package Trayectos;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TrayectoTren {
	private String codigoTren,nombreTrayecto;
	private tipoTren tipo;
	private List<String> estaciones;
	private List<LocalTime> horasSalidas, horasLlegada;
	
	public TrayectoTren(String codigoTren, String nombreTrayecto, tipoTren tipo, String origen, String finall, LocalTime horaSalidaOr, LocalTime horaLlegadaFin) {
		if (codigoTren.length()!=5) {
			throw new IllegalArgumentException();
		}
		
		if (!(Character.isDigit(codigoTren.charAt(0)) && Character.isDigit(codigoTren.charAt(1)) && Character.isDigit(codigoTren.charAt(2)) && Character.isDigit(codigoTren.charAt(3)) && Character.isDigit(codigoTren.charAt(4)))) {
			throw new IllegalArgumentException();
		}
		
		if (horaSalidaOr==null || horaLlegadaFin==null) {
			throw new IllegalArgumentException();
		}
		
		if (horaSalidaOr.isAfter(horaLlegadaFin) || horaSalidaOr.equals(horaLlegadaFin)) {
			throw new IllegalArgumentException();
		}
		
		this.codigoTren=codigoTren;
		this.nombreTrayecto=nombreTrayecto;
		this.tipo=tipo;
		estaciones= new ArrayList<>(List.of(origen,finall));
		horasSalidas=new ArrayList<>(List.of(horaSalidaOr));
		horasLlegada=new ArrayList<>(List.of(horaLlegadaFin));
	}
	
	public LocalTime getHoraSalida() {
		return horasSalidas.get(0);
	}
	
	public LocalTime getHoraLlegada() {
		return horasLlegada.get(horasLlegada.size()-1);
	}
	
	public Duration getDuracion() {
		return Duration.between(getHoraSalida(), getHoraLlegada());
	}
	
	public String getCodigoTren() {
		return codigoTren;
	}
	
	public String getNombreTrayecto() {
		return nombreTrayecto;
	}
	
	public tipoTren getTipo() {
		return tipo;
	}
	
	public List<String> getEstaciones() {
		return estaciones;
	}
	
	public List<LocalTime> getHorasSalidas() {
		return horasSalidas;
	}
	
	public List<LocalTime> getHorasLlegada() {
		return horasLlegada;
	}
	
	public LocalTime getHoraSalida(String estacion) {
		LocalTime result=null;
		if (estaciones.contains(estacion)) {
			result=horasSalidas.get(estaciones.indexOf(estacion)); 
		}
		return result;
	}
	
	public LocalTime getHoraLlegada(String estacion) {
		LocalTime result=null;
		if (estaciones.contains(estacion)) {
			if (estaciones.indexOf(estacion)-1>=0) {
				result=horasLlegada.get(estaciones.indexOf(estacion)-1);
			}
		}
		return result;
	}
	
	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		
		if (posicion<1 || posicion>=estaciones.size()) {
			throw new IllegalArgumentException();
		}
		
		if (horaSalida.isAfter(horaLlegada) || horaSalida.equals(horaLlegada)) {
			throw new IllegalArgumentException();
		}
		
		if (horaSalida.isAfter(horasLlegada.get(posicion))) {
			throw new IllegalArgumentException();
		}
		
		if (horaLlegada.isBefore(horasSalidas.get(posicion-1))) {
			throw new IllegalArgumentException();
		}
		
		List<String> result=new ArrayList<>();			//
		for (String e: estaciones) {
			if (estaciones.indexOf(e)!=posicion) {
			result.add(e);
			}	else {
				result.add(estacion);
			}
		}
		
		this.estaciones=result;
		
		List<LocalTime> result2=new ArrayList<>();
		if (posicion==1) {
			result2.add(horaLlegada);
			for (LocalTime e:horasLlegada) {
				result2.add(e);
			}
		} else {
			for (LocalTime e:horasLlegada) {
				if (horasSalidas.indexOf(e)!=posicion-1) {
				result2.add(e);
			} else {
				result2.add(horaLlegada);
			}
		}

		List<LocalTime> result3=new ArrayList<>();			//
		for (LocalTime e: horasSalidas) {
			if (horasSalidas.indexOf(e)!=posicion) {
			result3.add(e);
			}
		}
		
		this.horasSalidas=result3;
		

		/*	TRAYECTO SEVILLA-MADRID - AV City (Nº 02471)
		   ESTACIÓN                                                    LLEGADA SALIDA -> 
		0º SEVILLA-SANTA JUSTA                                                 07.00  -> [?,0]  No puede ser
		1º CÓRDOBA                                                       07.45 07.50  -> [0,1]
		2º VILLANUEVA DE CÓRDOBA-LOS PEDROCHES                           08.13 08.14  -> [1,2]
		3º PUERTOLLANO                                                   08.40 08.41  -> [2,3]
		4º CIUDAD REAL                                                   08.57 08.58  -> [3,4]
		5º MADRID-PUERTA DE ATOCHA                                       10.02        -> [4,4]  No puede ser           */
		}
	
	
	}
}
