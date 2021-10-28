package Dwarf_RPG;

public class Marteau extends Arme {
	static final double RATIO_CRITIQUE_MARTEAU = 3;
	protected int random;
	protected double degatsTemp;
		
	Marteau(double prix) {
		super(prix);
	}
	//Système de combat avec un random, soit c'est un critique, soit c'est une attaque normale, soit c'est ratée
	@Override
	public void attaque(Monstre m) {
		random = ((int) (Math.random()* 3));
		switch(random) {
		case(0):
			degatsTemp = degats * RATIO_CRITIQUE_MARTEAU;
			m.pv = m.pv - (degatsTemp);
			System.out.println("Attaque au couteau marteau critique ! Le "+m.typeDeMonstre()+" a pris "+degatsTemp+" dégâts critiques.");
			System.out.println(m.pv());
			break;
		case(1):
			degatsTemp = degats;
			m.pv = m.pv - degatsTemp;
			System.out.println("Attaque au marteau réussie, le "+m.typeDeMonstre()+" a pris "+degatsTemp+" dégâts.");
			System.out.println(m.pv());
			break;
		case(2):
			System.out.println("Ton marteau manque totalement sa cible ! Attaque ratée. \n");
			break;
		}			
	}

	@Override
	String type() {
		return "Marteau";
	}
}
