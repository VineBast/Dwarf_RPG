package Dwarf_RPG;

public abstract class Arme extends Equipement {
	//protected double prix;
	//protected double degats;
	static final double MONSTRE_DEGAT_RATIO = 1.1;
	static final double OBSTACLE_DEGAT_RATIO = 0.8;
	
	Arme(double prix) {
		super(prix);
	}
	abstract public String ascii_art();
	
	/*public void attaqueMonstre(Monstre m) {
		m.prendDesDegats(degats * MONSTRE_DEGAT_RATIO);
	}
	
	public void attaqueObstacle(Obstacle o) {
		o.prendDesDegats(degats * OBSTACLE_DEGAT_RATIO);
	}*/
}
