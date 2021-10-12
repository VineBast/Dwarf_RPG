package Dwarf_RPG;

public class Coffre  extends Destructible {
	
	Coffre(double pv) {
		super(pv);
	}
	public String dessin() {
		return "?";
	}
	
	public String type() {
		return "Coffre";
	}
	

}
