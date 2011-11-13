package View;

public class EmetteurSonoreImpl implements EmetteurSonore{
	private SimulMateriel simulMateriel;
	
	public EmetteurSonoreImpl(SimulMateriel simulMateriel){
		this.simulMateriel=simulMateriel;
	}

	@Override
	public void emettreClic() {
		System.out.println("Clic!");
		System.out.println("\007");
		
	}

}
