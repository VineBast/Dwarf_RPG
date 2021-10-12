package Dwarf_RPG;

public class Monstre extends Destructible {
	
	Monstre(double pv) {
		super(pv);
	}
	
	public String dessin() {
		return "?";
	}
	
	public String type() {
		return "Monstre";
	}
}
