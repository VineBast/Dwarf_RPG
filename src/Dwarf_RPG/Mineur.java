package Dwarf_RPG;

public class Mineur extends Personnage {
	public Mineur(String nom, String classe, int numClasse) {
		super(nom, classe, numClasse);
	}
	
	public void aptitudeDeClasse() {
		System.out.println("Tu sors ta pioche de mineur et creuse le sol. \n"
				+ "Incroyable, il y avait un filon d'or sous tes pieds !");
		int random = ((int) (Math.random()* 100));
		super.or+= random;
		System.out.println("Tu as découvert l'équivalent de "+random+" pièces d'or. Tes bourses sont maintenant remplies de "+super.or+" pièces d'or.");
	}
}
