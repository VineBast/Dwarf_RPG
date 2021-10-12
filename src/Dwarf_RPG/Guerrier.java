package Dwarf_RPG;

public class Guerrier extends Personnage {
	public Guerrier(String nom, String classe, int numClasse) {
		super(nom, classe, numClasse);
	}
	public void aptitudeDeClasse() {
		super.pv += 3;
		System.out.println("Tu te fais une petite poelée de champignons d'Erebor et la déguste avec passion");
		System.out.println("Ton montant de pv maximu augmente de 3.");
	}
	

}
