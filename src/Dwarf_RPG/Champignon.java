package Dwarf_RPG;

public class Champignon extends Equipement {
	static final double prix = 12;
	
	Champignon() {
		super(prix);
	}
		
	public boolean utilise(Personnage p) {
		if(p.pvMax - p.pv < 20) {
			p.pv = p.pvMax;
		}
		else {
			p.pv = p.pv + 20;
		}
		System.out.println("Champignon mangé, points de vie revigorés !"
				+"Points de vie : "+ p.pv );
		return true;
	}
}
