package Dwarf_RPG;

public class Monstre extends Destructible {
	protected int random;
	protected double degats;
	protected double degatsTemp;
	protected double pvMax;
	
	Monstre(double pv) {
		super(pv);
		this.pvMax = pv;
		this.degats = (double)Math.round((pv / 10) * 10) / 10;
	}
	
	public String dessin() {
		return "?";
	}
	
	public String type() {
		return "Monstre";
	}
	public String typeDeMonstre() {
		if(this.pvMax <= 100) {
			return "Gobelin";
		}
		else if(this.pvMax <= 250) {
			return "Warg égaré";
		}
		else if(this.pvMax <= 500) {
			return "Troll de Mine";
		}
		else if(this.pvMax == 1000) {
			return "Dragon d'Hildur";
		}
		else {
			return "Monstre";
		}
	}
	
	public String pv() {
		if(this.pv <= 0) {
			return("Il reste 0 point de vie au "+this.typeDeMonstre()+". \n");
		}
		else {
			return("Il reste "+this.pv+" points de vie au "+this.typeDeMonstre()+". \n");
		}
	}
	
	//Gère l'attaque du Monstre vers le personnage, soit il réussit l'attaque, soit il la rate
	public void attaque(Personnage p) {
		random = ((int) (Math.random()* 2));
		switch(random) {
		case(0):
			if(p.numArmureEquipee != -1) {
				if(degats < p.inventaire[p.numArmureEquipee].prix) {
					System.out.println("Ton Armure a encaissé tous les dégâts !");
					break;
				}
				else {
					degatsTemp = degats - p.inventaire[p.numArmureEquipee].prix;
					p.pv = p.pv - degatsTemp;
					System.out.println("Le "+this.typeDeMonstre()+" te donne un sacré coup, mais ton armure a encaissé une partie. Tu as pris "+degatsTemp+" dégâts. \n");
					if(p.pv <= 0) {
						System.out.println("Il te reste 0 point de vie.");

					}
					else {
						System.out.println("Il te reste "+p.pv+" points de vie.");
					}
					break;
				}
			}
			else {
				p.pv = p.pv - degats;
				System.out.println("Le "+this.typeDeMonstre()+" te donne un sacré coup ! Tu as pris "+degats+" dégâts. \n");
				if(p.pv <= 0) {
					System.out.println("Il te reste 0 point de vie.");

				}
				else {
					System.out.println("Il te reste "+p.pv+" points de vie.");
				}
				break;
			}
		case(1):
			System.out.println("Le "+this.typeDeMonstre()+" te rate totalement ! \n");
			break;
		}	
	}

	@Override
	double contenu() {
		return 0;
	}
}
