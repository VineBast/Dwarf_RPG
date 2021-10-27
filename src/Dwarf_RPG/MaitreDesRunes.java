package Dwarf_RPG;

public class MaitreDesRunes extends Personnage {
	public MaitreDesRunes(String nom, String classe, int numClasse) {
		super(nom, classe, numClasse);
	}
	
	public void aptitudeDeClasse() {
		if(super.mana >= 10) {
			super.inventaire[this.numArmeEquipee].degats += 5;
			System.out.println("Ton grimoire de runnage et ton marteau de Maître des runes en main, tu ajoutes une runes ancienne à ton arme");
			System.out.println("Ton arme équipée gagne 5 de dégats \n"
					+ "Tu perds 10 points de mana.");
			super.mana -= 10;
		}
		else {
			System.out.println("Tu n'as pas assez de mana, Nain");
		}
	}
}
