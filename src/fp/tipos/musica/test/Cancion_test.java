package fp.tipos.musica.test;
import java.time.Duration;
import java.time.LocalDate;

import fp.tipos.musica.*;

public class Cancion_test {

	public static void main(String[] args) {
		Cancion exitazo= new Cancion("La Macarena","Diosito");
		Cancion exitazo2= new Cancion("Okey I pull up","Ni idea");
		System.out.println(exitazo);
		exitazo.setDuracion(Duration.ofMinutes(3));
		exitazo.setGenero(Genero.FOLK);
		exitazo.setFechaLanzamiento(LocalDate.of(2007, 5, 21));
		System.out.println(exitazo);
		System.out.println(exitazo.compareTo(exitazo2));
	}

}
