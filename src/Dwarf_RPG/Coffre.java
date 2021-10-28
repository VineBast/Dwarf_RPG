package Dwarf_RPG;

public class Coffre  extends Destructible {
	
	Coffre(double pv) {
		super(pv);
	}
	//Pour l'affiche du tableau à deux dimensions
	public String dessin() {
		return "?";
	}
	
	public String type() {
		return "Coffre";
	}
	//Retourne le contenu du coffre qui equivaut aux PV du Destructible
	public double contenu() {
		return super.pv;
	}

}
