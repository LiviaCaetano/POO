package codigo1;

public class StartApp {

	public static void main(String[] args) {

		Guitarra minhaGuitarra = new Guitarra ("01020304", "fender", "telecaster", "elétrica", "mogno", 1500);
		
		System.out.println(minhaGuitarra.getNumeroSerie());
		System.out.println(minhaGuitarra.getMadeira());
		System.out.println(minhaGuitarra.getPreco());
		System.out.println(minhaGuitarra.getTipo());
	}

}
