package Dwarf_RPG;

public abstract class Destructible {
	protected double pv;
	
	Destructible(double pv) {
		this.pv = pv;
	}
	
	public void prendDesDegats(double degats) {
		pv -= degats;
	}
	
	public void affichePv() {
		System.out.println(this.pv);
	}
	
	abstract String dessin();
	abstract String type();
}
