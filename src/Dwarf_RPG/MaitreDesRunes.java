package Dwarf_RPG;

public class MaitreDesRunes extends Personnage {
	public MaitreDesRunes(String nom, String classe, int numClasse) {
		super(nom, classe, numClasse);
	}
	
	public void aptitudeDeClasse() {
		super.inventaire[0].degats += 5;
		//super.inventaire.get(0).degats += 5;
		System.out.println("Ton grimoire de runnage et ton marteau de Maître des runes en main, tu ajoutes une runes anciennes à ton arme");
		System.out.println("Ton arme gagne 5 de dégats");
	}
}
