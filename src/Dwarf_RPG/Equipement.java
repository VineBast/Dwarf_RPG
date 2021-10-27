package Dwarf_RPG;

public abstract class Equipement {
	protected double prix;
	protected double degats;
	
	public Equipement(double prix) {
		this.prix = prix;
	}
	abstract String type();
	
	public String typeEquipement() {
		String type = this.type();
		switch((int)this.prix) {
		case(5):
			return(type+" en bois");
		case(10):
			return(type+" en fer");
		case(20):
			return(type+" en acier");
		case(30):
			return(type+" en acier-argent");
		case(60):
			return(type+" en Galvorn");
		case(90):
			return(type+" en Mithril");
		default:
			return("");
		}
	}
	
	public boolean utilise(Personnage p) {
		System.out.println("Rien ne se passe.");
		return false;
	}
	
	abstract public void attaque(Monstre m);
}
