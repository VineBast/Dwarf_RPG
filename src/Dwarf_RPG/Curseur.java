package Dwarf_RPG;

public class Curseur extends Destructible {
	public Curseur() {
		 super(0);		
	}
	
	public String dessin() {
		return "X";
	}

	public String type() {
		return "Curseur";
	}

	@Override
	double contenu() {
		// TODO Auto-generated method stub
		return 0;
	}
}


