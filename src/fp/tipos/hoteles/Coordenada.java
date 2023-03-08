package fp.tipos.hoteles;

import java.util.Objects;

public record Coordenada(Double latitud, Double longitud) {
	public Coordenada{
		if (latitud>90.0 || latitud<-90.0 || longitud<-180.0 || longitud>180.0) {
			throw new IllegalArgumentException();
		}
	}
	public Double getDistancia(Coordenada s) { 
		return Math.sqrt((latitud-s.latitud)*(latitud-s.latitud)+(longitud-s.longitud)*(longitud-s.longitud));
	}
	public Double getDistanciaHaversine(Coordenada c) {
		final Double RADIOTIERRA= 6371.0;
		Double diflat=Math.toRadians(latitud-c.latitud);
		Double diflong=Math.toRadians(longitud-c.longitud);
		Double a=Math.pow(Math.sin(diflat/2), 2)+Math.cos(Math.toRadians(latitud))*Math.cos(Math.toRadians(c.latitud))+Math.pow(Math.sin(diflong/2), 2);
		Double f= 2*Math.atan2(Math.sqrt(a), Math.sqrt(1.0-a));
		return RADIOTIERRA*f;
	}
	public boolean equals(Object obj) {
		boolean result=false;
		if(getClass()==obj.getClass()) {
			Coordenada other = (Coordenada) obj;
			result= Objects.equals(latitud, other.latitud) && Objects.equals(longitud, other.longitud);
		}
		return result;
	}
}
