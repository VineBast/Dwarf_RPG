package Dwarf_RPG;

public class Pecore extends Personnage {
	public Pecore(String nom, String classe, int numClasse) {
		super(nom, classe, numClasse);
		super.pv = 50;
	}
	public void aptitudeDeClasse() {
		System.out.println("Les yeux plissés, tu essayes de regarder au loin dans le pénombre du Donjon.");
		System.out.println("Une nouvelle goutte de sueur glisse sur ton front");
	}
}
