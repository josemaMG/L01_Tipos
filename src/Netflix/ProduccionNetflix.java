package Netflix;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProduccionNetflix implements Comparable<ProduccionNetflix> {
	private String titulo;
	private tipo tipoSerie;
	private MesAnyo mesAnyo;
	private Duration duracion;
	private List<String> generos;
	private Integer numTemporadas;
	private Double score;
	private Long popularidad;
	
	public ProduccionNetflix(String titulo, tipo tipoSerie, MesAnyo mesAnyo, Duration duracion, List<String> generos,
			Integer numTemporadas, Double score, Long popularidad) {
		if (!(tipoSerie==tipo.MOVIE && numTemporadas==0) || !(tipoSerie==tipo.SHOW && numTemporadas>=1)) {
			throw new IllegalArgumentException();
		}
		if (score<0 || score >10) {
			throw new IllegalArgumentException();
		}
		if (popularidad<0) {
			throw new IllegalArgumentException();
		}
		if (mesAnyo.anyo()<=1900) {
			throw new IllegalArgumentException();
		}
		this.titulo = titulo;
		this.tipoSerie = tipoSerie;
		this.mesAnyo = mesAnyo;
		this.duracion = duracion;
		this.generos = generos;
		this.numTemporadas = numTemporadas;
		this.score = score;
		this.popularidad = popularidad;
	}

	public ProduccionNetflix(String linea) {
		String [] trozos = linea.split(";");
		tipo tipoSerie=parseaTipo(trozos[1].trim());
		MesAnyo mesanyo=new MesAnyo(Integer.valueOf(trozos[2].trim()),Integer.valueOf(trozos[3].trim()));
		Double score=Double.valueOf(trozos[7].trim());
		Long popularidad=Long.valueOf(trozos[8].trim());
		Integer numTemporadas=Integer.valueOf(trozos[6].trim());
		if (Integer.valueOf(trozos[3].trim())<=1900) {
			throw new IllegalArgumentException();
		}
		if (tipoSerie==tipo.SHOW) {
			if(numTemporadas<1) {
				throw new IllegalArgumentException();
			}
		}
		else  {
			if (numTemporadas!=0) {
			throw new IllegalArgumentException();
			}
		}
		if (score<0 || score >10) {
			throw new IllegalArgumentException();
		}
		if (popularidad<0) {
			throw new IllegalArgumentException();
		}
		if (mesanyo.anyo()<=1900) {
			throw new IllegalArgumentException();
		}
		this.titulo=trozos[0].trim();
		this.tipoSerie=tipoSerie;
		this.mesAnyo=mesanyo;
		this.duracion=Duration.ofMinutes(Integer.valueOf(trozos[4].trim()));
		this.generos=parseGeneros(trozos[5].trim());
		this.numTemporadas=numTemporadas;
		this.score=score;
		this.popularidad=popularidad;
	}

	@Override
	public String toString() {
		return "ProduccionNetflix [titulo=" + titulo + ", tipoSerie=" + tipoSerie + ", mesAnyo=" + mesAnyo
				+ ", duracion=" + duracion + ", generos=" + generos + ", numTemporadas=" + numTemporadas + ", score="
				+ score + ", popularidad=" + popularidad + "]";
	}

	private List<String> parseGeneros(String a) {
		List<String> result= new ArrayList<>();
		for (String e: a.replace("[","").replace("]","").split(",")) {
			result.add(e);
		}
		return result;
	}

	public tipo parseaTipo(String cosa) {
		return tipo.valueOf(cosa.toUpperCase());
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		if (score<0 || score >10) {
			throw new IllegalArgumentException();
		}
		this.score = score;
	}

	public Long getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(Long popularidad) {
		if (popularidad<0) {
			throw new IllegalArgumentException();
		}
		this.popularidad = popularidad;
	}

	public String getTitulo() {
		return titulo;
	}

	public tipo getTipoSerie() {
		return tipoSerie;
	}

	public MesAnyo getMesanyo() {
		return mesAnyo;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public List<String> getGeneros() {
		return generos;
	}

	public Integer getNumTemporadas() {
		return numTemporadas;
	}


	public int compareTo(ProduccionNetflix o) {
		int result=titulo.compareTo(o.titulo);
		if (result==0) {
			result=mesAnyo.anyo().compareTo(o.mesAnyo.anyo());
		}
		return result;
	}


	public int hashCode() {
		return Objects.hash(mesAnyo, titulo);
	}


	public boolean equals(Object obj) {
		boolean result=false;
		if (getClass() == obj.getClass()) {
		ProduccionNetflix other = (ProduccionNetflix) obj;
		result=Objects.equals(mesAnyo, other.mesAnyo) && Objects.equals(titulo, other.titulo);
		}
	return result;
	}
}
