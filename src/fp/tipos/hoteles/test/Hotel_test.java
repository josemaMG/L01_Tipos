package fp.tipos.hoteles.test;
import fp.tipos.hoteles.*;
public class Hotel_test {
	public static void main(String[] args) {
		Coordenada coords= new Coordenada(17.8, 79.9);
		Hotel ho= new Hotel("La casa Pepe","Calle Previsión","Sevilla","123 45 67 89","Márquez","Hotel reconfortante",CategoriaHotelera.CINCO, TipoAlojamiento.HOTEL, CategoriaPrecio.ALTA, 4.8f, 2023, true, true, coords);
		Hotel ho1= new Hotel("La casa Pepe","Calle Previsión","Sevilla","123 45 67 89","Márquez",CategoriaHotelera.CINCO);
		Hotel ho2= new Hotel("La casa Pepe","Sevilla",CategoriaHotelera.CINCO);
		System.out.println(ho);
		System.out.println(ho1);
		System.out.println(ho2);
	}
}
