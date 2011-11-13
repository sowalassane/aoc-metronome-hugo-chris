package View;

public class ClavierImpl implements Clavier{
	private SimulMateriel simulMateriel;
	
	public ClavierImpl(SimulMateriel simulMateriel){
		this.simulMateriel=simulMateriel;
	}

	@Override
	public boolean touchepressee(int i) {
		// TODO Auto-generated method stub
		return false;
	}

}
