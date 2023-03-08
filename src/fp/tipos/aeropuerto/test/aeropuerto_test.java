package fp.tipos.aeropuerto.test;
import java.time.LocalDateTime;

import fp.tipos.aeropuerto.*;
public class aeropuerto_test {
	public static void main(String[] args) {
		Aeropuerto vuelo= new Aeropuerto("IB2089","Sevilla","Madrid", LocalDateTime.of(2022, 3, 21, 13, 24), 8);
		Aeropuerto vuelo2= new Aeropuerto("IB2089","Sevilla","Madrid", LocalDateTime.of(2022, 3, 21, 13, 24), 24,8);
		System.out.println(vuelo);
		System.out.println(vuelo2);
	}
}
