package Dwarf_RPG;

public class Couteau extends Arme {
	static final double RATIO_CRITIQUE_COUTEAU = 1.2;
	protected int random;
	protected double degatsTemp;
	
	Couteau(double prix) {
		super(prix);
	}
		
	public void attaque(Monstre m) {
		int i = 0;
		int tour;
		while(i < 4) {
			random = ((int) (Math.random()* 3));
			tour = i + 1;
			switch(random) {
			case(0):
				degatsTemp = (double)Math.round((degats / 4 * RATIO_CRITIQUE_COUTEAU) * 10) / 10;
				m.pv = m.pv - (degatsTemp);
				System.out.println("Attaque au couteau n°"+tour+" ,le "+m.typeDeMonstre()+" a pris "+degatsTemp+" dégâts critiques.");
				System.out.println("Il reste "+m.pv+" points de vie au "+m.typeDeMonstre()+". \n");
				break;
			case(1):
				degatsTemp = (double)Math.round((degats / 4) * 10) / 10;
				m.pv = m.pv - (degatsTemp);
				System.out.println("Attaque au couteau n°"+tour+" ,le "+m.typeDeMonstre()+" a pris "+degatsTemp+" dégâts.");
				System.out.println("Il reste "+m.pv+" points de vie au "+m.typeDeMonstre()+". \n");
				break;
			case(2):
				System.out.println("Ton couteau manque totalement sa cible ! Ton attaque au couteau n°"+tour+" est ratée. \n");
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
		return "Couteau";
	}
}
