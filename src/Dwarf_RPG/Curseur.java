package Dwarf_RPG;

public class Curseur extends Destructible {
	public Curseur() {
		 super(0);		
	}
	//Cet objet a juste pour intérêt d'être supprimé et recréé pour simuler le déplacement du Personnage dans le Donjon
	//Pour l'affichage dans le tableau à deux dimensions.
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


