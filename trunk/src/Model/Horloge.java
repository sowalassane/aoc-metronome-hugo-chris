package Model;

public interface Horloge {
	public void activerPeriodiquement(Command cmd, float periodEnSec);
	public void activerApresDelais(Command cmd, float delaiEnSec);
	public void desactiver(Command cmd);
}
