package Dwarf_RPG;

public class Equipement {
	protected double prix;
	
	public Equipement(double prix) {
		this.prix = prix;
	}
	
	public String typeEquipement() {
		String type = this.getClass().toString().substring(16);
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
	
	/*public Armement(double prix, double protection) {
		this.prix = prix;
		this.prix = protection;
	}*/
}
