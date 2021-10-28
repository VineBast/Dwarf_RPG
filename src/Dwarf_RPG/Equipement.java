package Dwarf_RPG;

public abstract class Equipement {
	protected double prix;
	protected double degats;
	
	protected Equipement(double prix) {
		this.prix = prix;
	}
	abstract String type();
	
	//Récupère le type d'objet, et ajoute sa qualité en fonction de son prix
	protected String typeEquipement() {
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
			return(type);
		}
	}
	
	protected boolean utilise(Personnage p) {
		System.out.println("Rien ne se passe.");
		return false;
	}
	//Fonction abstraite qui pourrait être mise dans Arme, mais je voulais permettre d'attaquer avec d'autres types d'Equipement
	//Si le commentaire est toujours présent, c'est que je n'ai pas eu le temps de mettre cette fonction en place !
	abstract protected void attaque(Monstre m);
}
