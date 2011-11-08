package View;

public class EmetteurSonoreImpl implements EmetteurSonore{

	@Override
	public void emettreClic() {
		System.out.println("Clic!");
		System.out.println("\007");
		
	}

}
