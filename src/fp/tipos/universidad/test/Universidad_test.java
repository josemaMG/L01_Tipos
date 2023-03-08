package fp.tipos.universidad.test;
import fp.tipos.universidad.*;
public class Universidad_test {

	public static void main(String[] args) {
		Beca beca= new Beca("14A7U", 2436.27, 2, TipoBeca.ORDINARIA);
		Beca beca2= new Beca();
		System.out.println(beca);
		System.out.println(beca2);
	}

}
