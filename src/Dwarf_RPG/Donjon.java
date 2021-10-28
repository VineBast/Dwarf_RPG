package Dwarf_RPG;

import java.util.Scanner;

public class Donjon {
	Destructible[][] donjon;
	protected int largeur;
	protected int hauteur;
	protected Scanner scanner = new Scanner(System.in);
	protected int CurseurI = 0; //positions du Personnage dans le Tableau à deux dimensions
	protected int CurseurY = 0;
	
	protected Donjon(int largeur) {
		this.largeur = largeur;
		this.hauteur = largeur;
		this.donjon = new Destructible[this.largeur][this.hauteur];
		initDonjon(largeur);
	}
	
	protected void initDonjon(int largeur) {
		constructDonjon();		
	}	
	//Créé le Tableau à deux dimensions d'Objets Destructibles : Monstre, Coffre, Tavernier et Curseur.
	protected void constructDonjon() {
		int i = 0;
		int j;	
		int random;
		
		while (i < hauteur) {
			j = 0;
			while (j < largeur) {
				random = ((int) (Math.random()* 4));
				switch(random) {
				case(0):
					donjon[i][j] = new Monstre((int) (Math.random()* 300));
					break;
				case(1):
					donjon[i][j] = new Monstre((int) (Math.random()* 300)+300);
					break;
				case(2):
					donjon[i][j] = new Coffre((int) (Math.random()* 40));
					break;
				case(3):
					donjon[i][j] = new Tavernier();
					break;
				}
				j=j+1;				
			}
			i=i+1;
		}
		donjon[0][0] = new Curseur(); //Objet qui pointe l'endroit où se trouve le Personnage
		donjon[hauteur-1][largeur-1] = new Monstre(1000);
	}
	//Affiche le Donjon en fonction des Destructibles et du retour de leur fonction dessin()
	protected void affiche() {
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
	//Fonction de déplacement demande où on veut se déplacer dans le tableau à deux dimensions.
	//Regarde si cela pointe un Objet null, une sortie de tableau, un Objet Destructible
	protected void deplacement(Jeu jeu) {
		System.out.println("Se déplacer en haut (Z), à gauche (Q), en bas (S) ou à droite (D) ? \n"
				+ ">");
		String rep = (scanner.nextLine()).toUpperCase();
		switch(rep) {
		case("Z"):
			if (CurseurI == hauteur -1) {
				erreurDeplacement(jeu);
			}
			else if(donjon[CurseurI + 1][CurseurY] != null) {
				System.out.println("Il y a un "+donjon[CurseurI + 1][CurseurY].type()+" devant toi !");
				queFaire(donjon[CurseurI + 1][CurseurY].type(), jeu, CurseurI + 1, CurseurY);			
			}
			else {
				avanceCase(CurseurI + 1, CurseurY);
			}
			break;
		case("Q"):
			if (CurseurY == 0) {
				erreurDeplacement(jeu);
			}
			else if(donjon[CurseurI][CurseurY - 1] != null) {
				System.out.println("Il y a un "+donjon[CurseurI][CurseurY - 1].type()+" devant toi !");
				queFaire(donjon[CurseurI][CurseurY - 1].type(), jeu, CurseurI, CurseurY - 1);	
			}
			else {
				avanceCase(CurseurI, CurseurY - 1);
			}
			break;
		case("S"):
			if (CurseurI == 0) {
				erreurDeplacement(jeu);
			}
			else if(donjon[CurseurI - 1][CurseurY] != null) {
				System.out.println("Il y a un "+donjon[CurseurI - 1][CurseurY].type()+" devant toi !");
				queFaire(donjon[CurseurI -1][CurseurY].type(), jeu, CurseurI - 1, CurseurY);
			}
			else {
				avanceCase(CurseurI -1, CurseurY);
			}
			break;
		case("D"):
			if (CurseurY == largeur -1) {
				erreurDeplacement(jeu);
			}
			else if(donjon[CurseurI][CurseurY + 1] != null) {
				System.out.println("Il y a un "+donjon[CurseurI][CurseurY + 1].type()+" devant toi !");
				queFaire(donjon[CurseurI][CurseurY + 1].type(), jeu, CurseurI, CurseurY + 1);
			}
			else {
				avanceCase(CurseurI, CurseurY + 1);
			}
			break;
		default:
			System.out.println("Erreur de saisie !");
			deplacement(jeu);
		}
	}
	//Relance la fonction déplacement si erreur
	protected void erreurDeplacement(Jeu jeu) {
		System.out.println("Il y a un mur là où tu vas !");
		deplacement(jeu);
	}
	//Fonction avec système de choix en IF et SWITCH
	protected void queFaire(String type, Jeu jeu, int positionI, int positionY) {
		String rep = "";
		if (type == "Monstre") {
			Monstre m = (Monstre)donjon[positionI][positionY];
			System.out.println("Veux-tu Combattre le "+m.typeDeMonstre()+" ou Fuir ? (C/F) \n"
					+ ">");
			rep = (scanner.nextLine()).toUpperCase();
			switch(rep) {
			case("C"):
				combat(positionI, positionY, jeu, (Monstre)donjon[positionI][positionY]);
				avanceCase(positionI, positionY);
				break;
			default:
				System.out.println("Nain de Dieu, c'est quoi cette bête, je me tire de là !");
				deplacement(jeu);
			}
		}
		else if(type == "Tavernier") {
			System.out.println("Veux-tu faire des Emplettes ou revenir sur tes Pas ou passer ton Chemin ? (E/P/C) \n"
					+ ">");
			rep = (scanner.nextLine()).toUpperCase();
			switch(rep) {
			case("E"):
				jeu.magasinEquipement();
				avanceCase(positionI, positionY);
				System.out.println("Dans ton dos tu entends des volets se fermer avec fracas, le Tavernier ferme boutique.");
				break;
			case("C"):
				avanceCase(positionI, positionY);
				System.out.println("Dans ton dos tu entends des volets se fermer avec fracas, le Tavernier ferme boutique.");
				break;
			default:
				System.out.println("J'ai pas très soif à vrai dire.");
				deplacement(jeu);				
			}
		}
		else if(type == "Coffre") {
			System.out.println("Veux-tu Ouvrir le coffre ou revenir sur tes Pas ? (O/P) \n"
					+ ">");
			rep = (scanner.nextLine()).toUpperCase();
			switch(rep) {
			case("O"):
				coffre(positionI, positionY, jeu);
				avanceCase(positionI, positionY);
				break;
			default:
				System.out.println("Coffre ou pas, c'est pas pour moi.");
				deplacement(jeu);
			}
		}
	}
	//Fonction d'avancée de case dans le tableau à deux dimensions
	protected void avanceCase(int I, int Y) {
		donjon[CurseurI][CurseurY] = null;
		CurseurI = I;
		CurseurY = Y;
		donjon[CurseurI][CurseurY] = new Curseur();
	}
	//Système de combat sur une boucle dont les tours varient en fonction de l'arme et armure du personnage et du monstre
	protected void combat(int I, int Y, Jeu j, Monstre m) {
		int i = 1;
		while(true) {
			System.out.println("##########\n"
					+ ">Tour n°"+i+" \n"
					+ "##########");
			if(j.personnage.numArmeEquipee == -1) {
				Poing p = new Poing(1);
				p.attaque(m);
			}
			else {
				j.personnage.inventaire[j.personnage.numArmeEquipee].attaque(m);
			}
			if(m.pv <= 0 && m.typeDeMonstre() == "Dragon d'Hildur") {
				System.out.println("Ton arme a mis fin à la vie du Dragon d'Hildur. \n"
						+ "Bravo à toi "+j.personnage.nom+" pour cette aventure. Le butin d'Hildur te revient Nain. \n"
						+ "Le sac plein de trésors tu t'avances vers la lumière, tu prends la porte de sortie.");
				j.theEnd();
				break;
			}
			if(m.pv <= 0) {
				System.out.println("Ton coup a été fatal, le Monstre s'écroule devant toi. \n");
				j.personnage.gainExp(m.pvMax);
				break;
			}
			m.attaque(j.personnage);
			if(j.personnage.pv <= 0) {
				System.out.println("D'un coup bien senti, le Monstre t'a arraché la tête. \n");
				j.gameOver();
				break;
			}
			i++;
		}
	}
	//Fonction d'ouverture de coffre, qui ajoute de l'or
	protected void coffre(int I, int Y, Jeu j) {
		System.out.println("Tu fais sauter le cadenas du coffre d'un coup bien senti. \n");
		System.out.println("A l'intérieur se trouvent : "+donjon[I][Y].contenu()+" pièces d'or. \n");
		j.personnage.or += donjon[I][Y].contenu();
		System.out.println("Tes bourses sont maintenant remplies de : "+j.personnage.or+" pièces d'or.");
	}
}
