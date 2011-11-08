package Model;

public interface Horloge {
	/**
	 * Active l'action cmd toute les periodEnSec secondes. L'action se repete a l'infini sans
	 * tant que la method desactiver n'est pas utiliser
	 * @param cmd la Command a executer toutes les periodEnSec secondes
	 * @param periodEnSec delai en secondes entre les executions de la Command cmd
	 */
	public void activerPeriodiquement(Command cmd, float periodEnSec);
	
	/**
	 * Execute la Command cmd apres le delaiEnSec donne en parametre. Il s'agit d'un execution unique,
	 *  sans repetition
	 * @param cmd la Command a executer
	 * @param delaiEnSec delai en secondes avant l'execution
	 */
	public void activerApresDelais(Command cmd, float delaiEnSec);
	
	/**
	 * desactive l'execution periodique d'une Command mis en place via l'action activerPeriodiquement
	 * @param cmd Command dont la repetition est a desactiver
	 */
	public void desactiver(Command cmd);
}
