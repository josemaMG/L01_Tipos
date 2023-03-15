package Netflix.test;
import Netflix.*;
public class test {

	public static void main(String[] args) {
		System.out.println(CatalogoNetflix.getCatalogo("data/titulos_Netflix.csv").get(3));
		
	}
}
