package Dwarf_RPG;

public class Guerrier extends Personnage {
	public Guerrier(String nom, String classe, int numClasse) {
		super(nom, classe, numClasse);
	}
	public void aptitudeDeClasse() {
		if(super.mana >= 10) {
			super.pvMax += 10;
			super.pv += 10;
			System.out.println("Tu te fais une petite poelée de champignons d'Erebor et la déguste avec passion");
			System.out.println("Ton montant de points de vie maximum augmente de 10. \n"
					+ "Tu perds 10 de mana.");
			super.mana -= 10;
		}
		else {
			System.out.println("Tu n'as pas assez de mana, Nain");
		}
	}
	

}
