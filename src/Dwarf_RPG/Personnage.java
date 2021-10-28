package Dwarf_RPG;

import java.util.Scanner;

public abstract class Personnage extends TestScanner {
	protected String nom;
	protected String classe;
	protected int numClasse;
	protected double pv;
	protected double pvMax;
	protected double or;
	protected Equipement[] inventaire;
	protected Scanner scanner = new Scanner(System.in);
	protected int numArmeEquipee = -1;
	protected int numArmureEquipee = -1;
	protected double exp;
	protected int niveau;
	protected int mana;
	protected int manaMax;
	
	protected Personnage(String nom, String classe, int numClasse) {
		this.nom = nom;
		this.classe = classe;
		this.numClasse = numClasse;
		this.inventaire = new Equipement[4];
		this.or = 10;
		this.pv = 100;
		this.pvMax = pv;
		this.exp = 0;
		this.niveau = 1;
		this.mana = 10;
		this.manaMax = 10;
	}
	abstract protected void aptitudeDeClasse();
	
	protected String placeInventaire() {
		int i = 0;
		int place = 1;
		int compteur = 0;
		while(i < inventaire.length) {
			if(inventaire[i] == null) {
				compteur=compteur+1;
			}
			else {
				System.out.println("Inventaire place n°"+place+" : "+inventaire[i].typeEquipement());
			}
			place++;
			i++;
		}
		if(compteur == 4) {
			return("Ton inventaire est vide, tu as 4 places disponibles, "+this.classe+".");
		}
		else if(compteur == 0) {
			return("Ton inventaire est plein, si tu veux y ajouter une marmelade, il faut faire de la place.");
		}
		else {
			return("Il te reste "+compteur+" places dans ton inventaire.");
		}
	}
	
	//Fonction qui regarde s'il y a une place, et met en favoris l'equipement si c'est une arme ou une armure
	protected boolean ajoutInventaire(Equipement e) {
		int i = 0;
		boolean rep = false;
		while(i < inventaire.length) {
			if(inventaire[i] == null) {
				inventaire[i] = e;
				if(e.type() == "Armure") {
					numArmureEquipee = i;
				}
				else if((e.type() != "Champignon") && (e.type() != "Armure")) {
					numArmeEquipee = i;
				}
				rep = true;
				break;
			}
			i++;
		}
		return rep;
	}
	//Fonction qui liste l'inventaire. Et propose 3 actions possible : équiper une arme ou armure, utiliser un Equipement, supprimer un Equipement. 
	protected void accesInventaire() {
		int i = 0;
		int place = i + 1;
		while (i < inventaire.length) {
			if(inventaire[i] != null) {
				System.out.println("Place n°"+place+" : "+inventaire[i].typeEquipement());
			}
			i++;
			place++;
		}
		System.out.println("Que veux-tu faire avec ton équipement : \n"
				+"(1) équiper une arme ou une armure \n"
				+"(2) utiliser un objet de ton inventaire \n"
				+"(3) supprimer un equipement de l'inventaire \n"
				+"(4) sortir. \n"
				+ ">");
		int rep = testStringScanner(scanner, 4);
		if (rep == 1) {
			System.out.println("Entre la place indiquée de l'objet : \n"
					+ ">");
			int rep2 = testStringScanner(scanner, 5) - 1;
			if (inventaire[rep2] != null && inventaire[rep2].type() != "Champignon" && inventaire[rep2].type() != "Armure") {
				numArmeEquipee = rep2;
				System.out.println("Tu as ton "+inventaire[rep2].typeEquipement()+" en main, prêt à te défendre.");
			}
			else if(inventaire[rep2] != null && inventaire[rep2].type() == "Armure") {
				numArmureEquipee = rep2;
				System.out.println("Tu portes ton "+inventaire[rep2].typeEquipement()+", prêt à encaisser les coups.");
			}
			else if(rep2 > 3) {
				System.out.println("Tu as du mal à taper avec tes gros doitgs de Nain ?");
				accesInventaire();
			}
		}
		else if (rep == 2) {
			System.out.println("Entre le numéro de positionnement de l'objet : \n"
					+ ">");
			int rep2 = testStringScanner(scanner, 5) - 1;
			if (inventaire[rep2] != null && inventaire[rep2].type() == "Champignon") {
				inventaire[rep2].utilise(this);
				inventaire[rep2] = null;
			}
			else if(rep > 3){
				System.out.println("Tu as du mal à taper avec tes gros doitgs de Nain ?");
				accesInventaire();
			}
			else {
				inventaire[rep2].utilise(this);
			}
		}
		else if (rep == 3) {
			System.out.println("Entre le numéro de positionnement de l'objet : \n"
					+ ">");
			int rep3 = testStringScanner(scanner, 5) - 1;
			if (rep3 < 4) {
				inventaire[rep3] = null;
				System.out.println("L'objet a été supprimé de ton inventaire.");
			}
			else {
				System.out.println("Tu as du mal à taper avec tes gros doitgs de Nain ?");
			}
		}
	}
	//Met en place le gain d'expérience avec une boucle
	protected void gainExp(double xp) {
		this.exp = this.exp + xp;
		System.out.println("Tu as gagné "+xp+" points d'expérience.");
		while(this.exp >= 100) {
			this.niveau++;
			this.exp = this.exp - 100;
			this.pvMax = this.pvMax + 10;
			this.pv = this.pvMax;
			this.manaMax++;
			this.mana = this.manaMax;
			System.out.println("Tu as gagné 1 niveau, tu es maintenant niveau : "+this.niveau+"\n"
					+ "Tu as "+this.pv+" points de vie. \n"
					+ "et "+this.mana+" mana. \n");
		}
	}
	//Liste des attributs du Personnage
	protected String profil() {
		String profil = "Nom : "+this.nom+"\n"
				+ "Classe : "+this.classe+"\n"
				+ "PV : "+this.pv+"/"+this.pvMax+"\n"
				+ "Mana : "+this.mana+"/"+this.manaMax+"\n"
				+ "Pièces d'or : "+this.or+"\n"
				+ "Niveau : "+this.niveau+"\n"
				+ "Exp : "+this.exp+"/100 \n";
		return profil;
	}
}
