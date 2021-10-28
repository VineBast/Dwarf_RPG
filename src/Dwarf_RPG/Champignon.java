package Dwarf_RPG;

public class Champignon extends Equipement {
	static final double prix = 12;
	
	Champignon() {
		super(prix);
	}
	//Rend des pv au Personnage	
	protected boolean utilise(Personnage p) {
		if(p.pvMax - p.pv < 20) {
			p.pv = p.pvMax;
		}
		else {
			p.pv = p.pv + 20;
		}
		System.out.println("Champignon mangé, points de vie revigorés ! \n"
				+"Points de vie : "+ p.pv );
		return true;
	}

	@Override
	protected void attaque(Monstre m) {
		// TODO Auto-generated method stub
	}

	@Override
	String type() {
		return "Champignon";
	}
}
