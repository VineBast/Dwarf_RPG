package Dwarf_RPG;

public class Guerisseur extends Personnage {
	public Guerisseur(String nom, String classe, int numClasse) {
		super(nom, classe, numClasse);
	}
	
	public void aptitudeDeClasse() {
		if(super.pv >= super.pvMax) {
			System.out.println("Tu as déjà tous tes points de vie. C'est la choppe d'hydromel de trop, ivre, tu trébuches et tu te blesses");
			System.out.println("Tu perds 10 pv");
			super.pv -= 10;
		}
		else if(super.pv >= super.pvMax - 10) {
			System.out.println("Tu descends ta choppe d'hydromel d'une traite, tu es à une gorgée de finir ivre.");
			System.out.println("Tu récupères tous tes pv");
			this.pv = 100;
		}
		else {
			System.out.println("Tu descends ta choppe d'hydromel d'une traite.");
			System.out.println("Tu récupères 10pv");
			this.pv += 10;
		}
	}
}
