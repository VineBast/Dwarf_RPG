package Dwarf_RPG;

import java.util.Scanner;

public class Personnage {
	protected String nom;
	protected String classe;
	protected int numClasse;
	protected double pv;
	protected double pvMax;
	protected double or;
	protected int exp;
	protected Equipement[] inventaire;
	protected Scanner scanner = new Scanner(System.in);
	protected int numArmeEquipee;
	
	public Personnage(String nom, String classe, int numClasse) {
		this.nom = nom;
		this.classe = classe;
		this.numClasse = numClasse;
		this.inventaire = new Equipement[4];
		this.or = 10;
		this.pv = 100;
		this.pvMax = pv;
		this.exp = 0;
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
			place=place+1;
			i=i+1;
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
				rep = true;
				break;
			}
			i=i+1;
		}
		return rep;
	}
	
	public void accesInventaire() {
		int i = 0;
		while (i < inventaire.length) {
			System.out.println("Place n°"+i+" : "+inventaire[i].typeEquipement());
			i=i+1;
		}
		System.out.println("Que veux-tu faire avec ton équipement : \n"
				+"(1) équiper une arme ou une armure \n"
				+"(2) utiliser un objet de ton inventaire \n"
				+"(3) sortir."
				+ ">");
		int rep = scanner.nextInt();
		if (rep == 1) {
			System.out.println("Entre le numéro de positionnement de l'objet : \n"
					+ ">");
			int rep2 = scanner.nextInt();
			if (inventaire[rep2] != null || inventaire[rep2].typeEquipement() != "Champignon") {
				numArmeEquipee = rep2;

			}
			else {
				System.out.println("Tu as mal du mal à taper avec tes gros doitgs de Nain ?");
				accesInventaire();
			}
		}
		else if (rep == 2) {
			System.out.println("Entre le numéro de positionnement de l'objet : \n"
					+ ">");
			int rep2 = scanner.nextInt();
			if (inventaire[rep2] != null || inventaire[rep2].typeEquipement() == "Champignon") {
				inventaire[rep2].utilise(this);
				inventaire[rep2] = null;

			}
			else {
				System.out.println("Tu as mal du mal à taper avec tes gros doitgs de Nain ?");
				accesInventaire();
			}			
		}
		else {
			return;
		}
	}

}
