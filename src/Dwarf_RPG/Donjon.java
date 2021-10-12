package Dwarf_RPG;

import java.util.Scanner;

public class Donjon {
	Destructible[][] donjon;
	protected int largeur;
	protected int hauteur;
	protected Scanner scanner = new Scanner(System.in);
	protected int CurseurI = 0;
	protected int CurseurY = 0;
	
	public Donjon(int largeur) {
		this.largeur = largeur;
		this.hauteur = largeur;
		this.donjon = new Destructible[this.largeur][this.hauteur];
		initDonjon(largeur);
	}
	
	public void initDonjon(int largeur) {
		constructDonjon();		
	}	
	public String asciiDonjon() {
		return " _____________________________________________\n"
				+ "|.'',                                     ,''.|\n"
				+ "|.'.'',                                 ,''.'.|\n"
				+ "|.'.'.'',                             ,''.'.'.|\n"
				+ "|.'.'.'.'',                         ,''.'.'.'.|\n"
				+ "|.'.'.'.'.|                         |.'.'.'.'.|\n"
				+ "|.'.'.'.'.|===;                 ;===|.'.'.'.'.|\n"
				+ "|.'.'.'.'.|:::|',             ,'|:::|.'.'.'.'.|\n"
				+ "|.'.'.'.'.|---|'.|, _______ ,|.'|---|.'.'.'.'.|\n"
				+ "|.'.'.'.'.|:::|'.|'|???????|'|.'|:::|.'.'.'.'.|\n"
				+ "|,',',',',|---|',|'|???????|'|,'|---|,',',',',|\n"
				+ "|.'.'.'.'.|:::|'.|'|???????|'|.'|:::|.'.'.'.'.|\n"
				+ "|.'.'.'.'.|---|','   /%%%\\   ','|---|.'.'.'.'.|\n"
				+ "|.'.'.'.'.|===:'    /%%%%%\\    ':===|.'.'.'.'.|\n"
				+ "|.'.'.'.'.|%%%%%%%%%%%%%%%%%%%%%%%%%|.'.'.'.'.|\n"
				+ "|.'.'.'.','       /%%%%%%%%%\\       ','.'.'.'.|\n"
				+ "|.'.'.','        /%%%%%%%%%%%\\        ','.'.'.|\n"
				+ "|.'.','         /%%%%%%%%%%%%%\\         ','.'.|\n"
				+ "|.','          /%%%%%%%%%%%%%%%\\          ','.|\n"
				+ "|;____________/%%%%%%%%%%%%%%%%%\\____________;|";
	}
	
	public void constructDonjon() {
		int i = 0;
		int j;	
		int random;
		
		while (i < hauteur) {
			j = 0;
			while (j < largeur) {
				random = ((int) (Math.random()* 3));
				switch(random) {
				case(0):
					donjon[i][j] = new Monstre((int) (Math.random()* 500));
					break;
				case(1):
					donjon[i][j] = new Tavernier();
					break;
				case(2):
					donjon[i][j] = new Coffre((int) (Math.random()* 50));
					break;
				}
				j=j+1;				
			}
			i=i+1;
		}
		donjon[0][0] = new Curseur();
	}
	
	public void affiche() {
		int i = hauteur - 1;
		int j;
		String print;
		System.out.println("\n");
		
		while(i >= 0) {			
			j = 0;
			print = "| ";
			while(j < largeur) {
				if(donjon[i][j] == null) {
					print = print +"  | ";
				}
				else {
					print = print + donjon[i][j].dessin()+" | ";
				}
				j=j+1;
			}
			System.out.println(print);
			i=i-1;
		}	
		System.out.println("\n");
	}
	
	public void deplacement() {
		System.out.println("Se déplacer en haut (Z), à gauche (Q), en bas (S) ou à droite (D) ? \n"
				+ ">");
		String rep = scanner.nextLine();
		switch(rep) {
		case("Z"):
			if (CurseurI == hauteur -1) {
				erreurDeplacement();
			}
			else {
				System.out.println("Il y a un "+donjon[CurseurI + 1][CurseurY].type()+" devant toi !");
				queFaire(donjon[CurseurI + 1][CurseurY].type());
				donjon[CurseurI][CurseurY] = null;
				CurseurI = CurseurI + 1;
				donjon[CurseurI][CurseurY] = new Curseur();
			}
			break;
		case("Q"):
			if (CurseurY == 0) {
				erreurDeplacement();
			}
			else {
				System.out.println("Il y a un "+donjon[CurseurI][CurseurY - 1].type()+" devant toi !");
				queFaire(donjon[CurseurI][CurseurY -1].type());
				donjon[CurseurI][CurseurY] = null;
				CurseurY = CurseurY - 1;
				donjon[CurseurI][CurseurY] = new Curseur();
			}
			break;
		case("S"):
			if (CurseurI == 0) {
				erreurDeplacement();
			}
			else {
				System.out.println("Il y a un "+donjon[CurseurI - 1][CurseurY].type()+" devant toi !");
				queFaire(donjon[CurseurI -1][CurseurY].type());
				donjon[CurseurI][CurseurY] = null;
				CurseurI = CurseurI - 1;
				donjon[CurseurI][CurseurY] = new Curseur();
			}
			break;
		case("D"):
			if (CurseurY == largeur -1) {
				erreurDeplacement();
			}
			else {
				System.out.println("Il y a un "+donjon[CurseurI][CurseurY + 1].type()+" devant toi !");
				queFaire(donjon[CurseurI][CurseurY + 1].type());
				donjon[CurseurI][CurseurY] = null;
				CurseurY = CurseurY + 1;
				donjon[CurseurI][CurseurY] = new Curseur();
			}
			break;
		default:
			System.out.println("Erreur de saisie !");
			deplacement();
		}
	}
	
	public void erreurDeplacement() {
		System.out.println("Il y a un mur là où tu vas !");
		deplacement();
	}
	
	public void queFaire(String type) {
		if (type == "Monstre") {
			System.out.println("Veux-tu Combattre ou Fuir ? (C/F) \n"
					+ ">");
			String rep = scanner.nextLine();
			if (rep == "C") {
				combat();
			}
			else {
				deplacement();
			}
		}
		else if(type == "Tavernier") {
			System.out.println("Veux-tu faire des Emplettes ou revenir sur tes Pas ? (E/P) \n"
					+ ">");
			String rep = scanner.nextLine();
			if (rep == "E") {
				// IL FAUT CREER UNE CLASSE MAGAIN AVEC LES FONCTIONS DEJA EN PLACE DANS JEU !!!
			}
			else {
				deplacement();
			}
		}
		else if(type == "Coffre") {
			System.out.println("Veux-tu Ouvrir le coffre ou revenir sur tes Pas ? (O/P) \n"
					+ ">");
			String rep = scanner.nextLine();
			if (rep == "O") {
				coffre();				
			}
			else {
				deplacement();
			}
		}
	}
	
	public void combat() {
		
	}
	
	public void coffre() {
		
	}
}
