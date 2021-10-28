package Dwarf_RPG;

public class Poing extends Arme {
	static final double RATIO_CRITIQUE_POING = 2;
	protected int random;
	protected double degatsTemp;
	protected double degatsPoing;

	Poing(double prix) {
		super(prix);
	}

	@Override
	String type() {
		return "Poing";
	}

	@Override
	public void attaque(Monstre m) {
		int i = 0;
		int tour;
		while(i < 2) {
			random = ((int) (Math.random()* 3));
			tour = i + 1;
			switch(random) {
			case(0):
				degatsPoing = degats * RATIO_CRITIQUE_POING;
				degatsTemp = (double)Math.round((degatsPoing) * 10) / 10;
				m.pv = m.pv - degatsTemp;
				System.out.println("Coup de poing n°"+tour+", le "+m.typeDeMonstre()+" a pris "+degatsTemp+" dégâts critiques.");
				System.out.println(m.pv());
				break;
			case(1):
				degatsTemp = (double)Math.round(degats * 10) / 10;
				m.pv = m.pv - (degatsTemp);
				System.out.println("Coup de poing n°"+tour+", le "+m.typeDeMonstre()+" a pris "+degatsTemp+" dégâts.");
				System.out.println(m.pv());
				break;
			case(2):
				System.out.println("Ton poing manque totalement sa cible ! Ton attaque n°"+tour+" est ratée. \n");
				break;
			}
			if(m.pv <= 0) {
				break;
			}
			i++;
		}
		
	}

}
