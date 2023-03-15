package Netflix;

import java.util.ArrayList;
import java.util.List;
import utiles.ficheros;

public class CatalogoNetflix {
	
	public static List<ProduccionNetflix> getCatalogo(String path) {
		List<ProduccionNetflix> result= new ArrayList<>();
			for (String e: ficheros.leeFichero(path)) {
				result.add(new ProduccionNetflix(e));
			}
		return result;
	}
}
