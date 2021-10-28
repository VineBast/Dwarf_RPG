package Dwarf_RPG;

public class Guerisseur extends Personnage {
	public Guerisseur(String nom, String classe, int numClasse) {
		super(nom, classe, numClasse);
	}
	//Rend tous les points de vie et enlève 10 pts de mana
	public void aptitudeDeClasse() {
		if(this.mana >= 10) {
			if(super.pv >= super.pvMax) {
				System.out.println("Tu as déjà tous tes points de vie. C'est la choppe d'hydromel de trop, ivre, tu trébuches et tu te blesses");
				System.out.println("Tu perds 10 points de vie et 10 points de mana.");
				super.pv -= 10;
			}
			else {
				super.pv = super.pvMax;
				super.mana -= 10;
				System.out.println("Tu descends ta choppe d'hydromel d'une traite. \n"
						+ "Tu récupères tous tes points de vie et perds 10 points de mana..");
			}
		}
		else {
			System.out.println("Tu n'as pas assez de mana, Nain");
		}
	}
}
