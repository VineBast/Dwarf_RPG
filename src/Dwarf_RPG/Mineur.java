package Dwarf_RPG;

public class Mineur extends Personnage {
	public Mineur(String nom, String classe, int numClasse) {
		super(nom, classe, numClasse);
	}
	
	public void aptitudeDeClasse() {
		/*A COMPLETER POUR AVANCER D'UNE CASE */
		System.out.println("Tu sors ton marteau de mineur et creuse un tunnel à toute vitesse.");
		System.out.println("Tu as echappé au pire");
	}
}
