package Dwarf_RPG;

public class Mineur extends Personnage {
	public Mineur(String nom, String classe, int numClasse) {
		super(nom, classe, numClasse);
	}
	//Ajoute un montant random d'or et enlève du mana
	public void aptitudeDeClasse() {
		if(super.mana >= 10) {
			System.out.println("Tu sors ta pioche de mineur et creuse le sol. \n"
					+ "Incroyable, il y avait un filon d'or sous tes pieds !");
			int random = ((int) (Math.random()* 30));
			super.or+= random;
			System.out.println("Tu as découvert l'équivalent de "+random+" pièces d'or. Tes bourses sont maintenant remplies de "+super.or+" pièces d'or. \n"
					+ "Tu perds 10 points de mana.");
			super.mana -= 10;
		}
		else {
			System.out.println("Tu n'as pas assez de mana, Nain");
		}
	}
}
