package Model;

//test commentaire
public interface Moteur {
	public int getTempo();
	public void setTempo(int t);
	public void setNbTpsParMesure(int t);
	public int getNbTpsParMesure();
	public boolean getEnMarche();
	public void setEnMarche(boolean b);
	public void setCmdMarquerTps(Command cmd);
	public void setCmdTic(Command cmd);
}
