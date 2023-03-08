package fp.tipos.futbol.test;
import java.time.LocalDateTime;

import fp.tipos.futbol.*;
public class PartidoFutbol_test {

	public static void main(String[] args) {
		PartidoFutbol par= new PartidoFutbol(LocalDateTime.of(2020, 5, 3, 21, 3, 24), "Betis", "Sevilla", 2, 3);
		System.out.println(par);
		System.out.println(par.equipoLocal());
		System.out.println(par.cadenaConFormato());
	}
}
