package Dwarf_RPG;

import java.util.Scanner;

public abstract class Personnage {
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
	
	public Personnage(String nom, String classe, int numClasse) {
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
	
	public String placeInventaire() {
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
	
	public boolean ajoutInventaire(Equipement e) {
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
	public void accesInventaire() {
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
		int rep = scanner.nextInt();
		if (rep == 1) {
			System.out.println("Entre la place indiquée de l'objet : \n"
					+ ">");
			int rep2 = scanner.nextInt() - 1;
			if (inventaire[rep2] != null && inventaire[rep2].type() != "Champignon" && inventaire[rep2].type() != "Armure") {
				numArmeEquipee = rep2;
				System.out.println("Tu as ton "+inventaire[rep2].typeEquipement()+" en main, prêt à te défendre.");
			}
			else if(inventaire[rep2] != null && inventaire[rep2].type() == "Armure") {
				numArmureEquipee = rep2;
				System.out.println("Tu portes ton "+inventaire[rep2].typeEquipement()+", prêt à encaisser les coups.");
			}
			else {
				System.out.println("Tu as mal du mal à taper avec tes gros doitgs de Nain ?");
				accesInventaire();
			}
		}
		else if (rep == 2) {
			System.out.println("Entre le numéro de positionnement de l'objet : \n"
					+ ">");
			int rep2 = scanner.nextInt() - 1;
			if (inventaire[rep2] != null || inventaire[rep2].typeEquipement() == "Champignon") {
				inventaire[rep2].utilise(this);
				inventaire[rep2] = null;
			}
			else {
				System.out.println("Tu as mal du mal à taper avec tes gros doitgs de Nain ?");
				accesInventaire();
			}			
		}
		else if (rep == 3) {
			System.out.println("Entre le numéro de positionnement de l'objet : \n"
					+ ">");
			int rep3 = scanner.nextInt() - 1;
			inventaire[rep3] = null;
			System.out.println("L'objet a été supprimé de ton inventaire.");
		}
		else {
			return;
		}
	}
	public void gainExp(double xp) {
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
	abstract public void aptitudeDeClasse();
}
