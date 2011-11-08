package View;

import javax.swing.JSlider;

public class MoletteImpl implements Molette{

	private JSlider slider;
	
	public MoletteImpl(JSlider slider){
		this.slider=slider;
	}
	@Override
	public float position() {
		float val=slider.getValue();
		val-=40;
		return (val/168);
	}

}
