package Dwarf_RPG;

public class Tavernier extends Destructible {
	public Tavernier() {
		super(500);
	}
	//Pour l'affichage dans le tableau à deux dimensions
	public String dessin() {
		return "?";
	}
	
	public String type() {
		return "Tavernier";
	}
	@Override
	double contenu() {
		// TODO Auto-generated method stub
		return 0;
	}
}
