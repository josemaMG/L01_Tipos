package fp.tipos.cine.test;
import java.time.LocalDate;

import fp.tipos.cine.*;
public class pelicula_test {

	public static void main(String[] args) {
		Pelicula a= new Pelicula("Charly Chaplin",LocalDate.of(1988, 4, 21), 30);
		Pelicula b= new Pelicula("Agente 007");
		b.setDuracion(45);
		System.out.println(a);
		System.out.println(b);
		b.setFechaEstreno(LocalDate.of(1990, 3, 14));
		System.out.println(b);
	}

}
