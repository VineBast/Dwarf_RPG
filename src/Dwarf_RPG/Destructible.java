package Dwarf_RPG;

public abstract class Destructible {
	protected double pv;
	
	Destructible(double pv) {
		this.pv = pv;
	}
		
	public void affichePv() {
		System.out.println(this.pv);
	}
	
	abstract String dessin();
	abstract String type();
	abstract double contenu();
}
