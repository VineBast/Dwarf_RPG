package Dwarf_RPG;

public class Hache extends Arme {
	static final double RATIO_CRITIQUE_HACHE = 1.5;
	protected int random;
	protected double degatsTemp;
	protected double degatsHache;
	
	Hache(double prix) {
		super(prix);
	}
	//Système de combat avec un random, soit c'est un critique, soit c'est une attaque normale, soit c'est ratée
	public void attaque(Monstre m) {
		int i = 0;
		int tour;
		degatsHache = degats / 2;
		while(i < 2) {
			random = ((int) (Math.random()* 3));
			tour = i + 1;
			switch(random) {
			case(0):
				degatsHache = degats / 2 * RATIO_CRITIQUE_HACHE;
				degatsTemp = (double)Math.round(degatsHache * 10) / 10;
				m.pv = m.pv - degatsTemp;
				System.out.println("Attaque à la hache n°"+tour+", le "+m.typeDeMonstre()+" a pris "+degatsHache+" dégâts critiques.");
				System.out.println(m.pv());
				break;
			case(1):
				degatsHache = degats / 2;
				degatsTemp = (double)Math.round(degatsHache * 10) / 10;
				m.pv = m.pv - (degatsTemp);
				System.out.println("Attaque à la hache n°"+tour+", le "+m.typeDeMonstre()+" a pris "+degatsHache+" dégâts.");
				System.out.println(m.pv());
				break;
			case(2):
				System.out.println("Ta hache manque totalement sa cible ! Ton attaque à la hache n°"+tour+" est ratée. \n");
				break;
			}
			if(m.pv <= 0) {
				break;
			}
			i++;
		}	
	}

	@Override
	String type() {
		// TODO Auto-generated method stub
		return "Hache";
	}
}
