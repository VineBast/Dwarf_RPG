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
	//Pour l'affichage dans le tableau à deux dimensions
	protected String dessin() {
		return "?";
	}
	//Fonction qui simplifie le bestiaire du jeu (comme expliqué dans le README). 
	//Les monstres n'étaient pas assez évolués pour que j'en fasse des classes particulières, j'ai préféré tout faire fonctionner avec cette fonction
	//En fonction de ses pvMax le Monstre a un certain nom, les pvMax determinent aussi les dégâts
	protected String type() {
		return "Monstre";
	}
	protected String typeDeMonstre() {
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
	//Fonction qui évite d'avoir des montants de PV négatifs
	protected String pv() {
		if(this.pv <= 0) {
			return("Il reste 0 point de vie au "+this.typeDeMonstre()+". \n");
		}
		else {
			return("Il reste "+this.pv+" points de vie au "+this.typeDeMonstre()+". \n");
		}
	}
	
	//Gère l'attaque du Monstre vers le personnage, soit il réussit l'attaque, soit il la rate
	protected void attaque(Personnage p) {
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
		// TODO Auto-generated method stub
		return 0;
	}
}
