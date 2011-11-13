package View;

public class MoletteImpl implements Molette{

	private SimulMateriel simulMateriel;
	
	public MoletteImpl(SimulMateriel simulMateriel){
		this.simulMateriel=simulMateriel;;
	}
	@Override
	public float position() {
		float val=simulMateriel.getPositionSlider();
		val-=40;
		return (val/168);
	}

}
