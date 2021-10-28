package Dwarf_RPG;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Jeu extends TestScanner {
	protected Personnage personnage;
	protected Donjon donjon;
	protected Scanner scanner = new Scanner(System.in);
	protected int tailleDonjon;

	//Le constructeur lance l'initialisation du Jeu puis la partie
	protected Jeu(int tailleDonjon) {
		this.tailleDonjon = tailleDonjon;
		init(tailleDonjon);
		partie();
	}

	protected void init(int tailleDonjon) {
		donjon = new Donjon(tailleDonjon);
		System.out.println(intro());
		initPersonnage();
		magasinEquipement();
	}

	protected String intro() {
		return ("8 888888888o.      `8.`888b                 ,8'          .8.          8 888888888o.   8 8888888888\n"
				+ "8 8888    `^888.    `8.`888b               ,8'          .888.         8 8888    `88.  8 8888\n"
				+ "8 8888        `88.   `8.`888b             ,8'          :88888.        8 8888     `88  8 8888\n"
				+ "8 8888         `88    `8.`888b     .b    ,8'          . `88888.       8 8888     ,88  8 8888\n"
				+ "8 8888          88     `8.`888b    88b  ,8'          .8. `88888.      8 8888.   ,88'  8 888888888888\n"
				+ "8 8888          88      `8.`888b .`888b,8'          .8`8. `88888.     8 888888888P'   8 8888\n"
				+ "8 8888         ,88       `8.`888b8.`8888'          .8' `8. `88888.    8 8888`8b       8 8888\n"
				+ "8 8888        ,88'        `8.`888`8.`88'          .8'   `8. `88888.   8 8888 `8b.     8 8888\n"
				+ "8 8888    ,o88P'           `8.`8' `8,`'          .888888888. `88888.  8 8888   `8b.   8 8888\n"
				+ "8 888888888P'               `8.`   `8'          .8'       `8. `88888. 8 8888     `88. 8 8888\n"
				+ "\n" + "\n" + "8 888888888o.   8 888888888o       ,o888888o.\n"
				+ "8 8888    `88.  8 8888    `88.    8888     `88.\n"
				+ "8 8888     `88  8 8888     `88 ,8 8888       `8.\n" + "8 8888     ,88  8 8888     ,88 88 8888\n"
				+ "8 8888.   ,88'  8 8888.   ,88' 88 8888\n" + "8 888888888P'   8 888888888P'  88 8888\n"
				+ "8 8888`8b       8 8888         88 8888   8888888\n"
				+ "8 8888 `8b.     8 8888         `8 8888       .8'\n"
				+ "8 8888   `8b.   8 8888            8888     ,88'\n"
				+ "8 8888     `88. 8 8888             `8888888P'\n" + "\n");
	}
	//Fonction qui met en place le Personnage que jouera l'utilisateur
	protected void initPersonnage() {
		while (true) {
			System.out.println("Entre le nom de ton Nain : ");
			String nom = scanner.nextLine();
			System.out.println("Le Guerrier est le plus résistant des Nains, il peut augmenter ses points de vie maximum." + "\n"
					+ "Le Guérisseur récupère ses points de vie en buvant une choppe d'hydromel." + "\n"
					+ "Le Maître des runes utilise l'art ancien des runes magiques pour améliorer son armement." + "\n"
					+ "Le Mineur peut piocher le sol à la découverte de filons d'or." + "\n" + "\n"
					+ "Choisis ta classe (tape 1, 2, 3 ou 4). \n"
					+ ">");

			int numClasse = testStringScanner(scanner, 5);		
			switch (numClasse) {
			case (1):
				personnage = new Guerrier(nom, "Guerrier", numClasse);
				break;
			case (2):
				personnage = new Guerisseur(nom, "Guérisseur", numClasse);
				break;
			case (3):
				personnage = new MaitreDesRunes(nom, "Maître des runes", numClasse);
				break;
			case (4):
				personnage = new Mineur(nom, "Mineur", numClasse);
				break;
			default:
				System.out.println(
						"Nain porte quoi, même pas capable de choisir entre 4 chiffres, te voilà Pécore, un moins que rien !");
				personnage = new Pecore(nom, "Pécore", numClasse);
			}
			System.out.println("\n");
			System.out.println(
					nom + " le " + personnage.classe + ", te voilà aux portes du Donjon d'Hildur, bon courage à toi. \n");
			break;
		}
	}
	
	//Annonce l'entrée dans la Taverne et appelle la fonction annonceEquipement()
	protected void magasinEquipement() {
		System.out.println("Bienvenue dans notre Taverne, tu peux acheter de l'armement et des champigons cultivés dans notre cave. \n");
		annonceEquipement();
		System.out.println("Tu sors de la Taverne pour t'engouffrer dans la pénombre du Donjon d'Hildur.");
	}
	//Fait la liste de l'équipement disponible dans le Jeu et son explication, gère l'attribution de l'Equipement avec des IF et SWITCH
	//C'est la grosse fonction qui gère le système de Taverne/Magasin
	protected void annonceEquipement() {
		while (true) {
			System.out.println(personnage.placeInventaire()+"\n");
			System.out.println("Nombre de pièces d'or : "+personnage.or +"\n");
			System.out.println("Veux-tu plus d'informations sur nos produits (0/1) ? \n"
					+ "0 pour Oui, 1 pour Non. \n"
					+ ">");
			
			int choixInfos = testStringScanner(scanner, 1);
			if(choixInfos == 0) {
				System.out.println("Chaque armement (armes ou armure) est disponible entre 6 matériaux qui déterminent la qualité du produit. \n"
						+ "Une arme ou armure en bois vaut 5 pièces d'or, en fer 10 pièces, en acier 20 pièces, en acier-argent 30 pièces, en Galvorn 60 pièces et en Mithril 90 pièces d'or. \n"
						+ "Un couteau permet lors d'une action de faire 4 attaques faibles avec la possibilité à chaque fois de faire une attaque critique ou non critique, ou de manquer l'attaque. \n"
						+ "La hache permet de faire 2 attaques en 1 action avec les mêmes conditions que le couteau. \n"
						+ "Le marteau permet de faire une attaque puissante en 1 action, elle peut être soit normale, soit critique, soit manquée. \n"
						+ "Le champignon, une fois ingéré te permet de récupérer 20 points de vie, il coûte 12 pièces d'or. \n");
			}
			System.out.println("Fais ton choix entre les différents equipements : \n" 
					+ "- couteau (1) \n"
					+ "- hache (2) \n" 
					+ "- marteau (3) \n" 
					+ "- armure (4) \n"
					+ "- champignon (5) pour 12 pièces d'or. \n \n" 
					+ "Entre le numéro de ton choix en ce qui concerne l'equipement, tu peux aussi faire (6) pour sortir de la Taverne, ou (7) pour accéder à ton inventaire. \n"
					+ ">");
			
			int choixEquipement = testStringScanner(scanner, 8);
			if(choixEquipement == 6) {
				partie();
			}
			else if(choixEquipement == 5) {
				if(personnage.or < 12) {
					System.out.println("Je crains que tu n'aies pas assez de pièces d'or pour cet achât.");
					annonceEquipement();
				}
				else if(personnage.ajoutInventaire(new Champignon()) == false) {
					System.out.println("Il y n'a plus de place dans ton inventaire.");
					annonceEquipement();
				}
				else {
					personnage.or -= 12;
					System.out.println("Ton champignon a été ajouté à ton inventaire. \n"
							+ "Veux-tu continuer tes achâts (0/1)? \n"
							+">");
					int repQuestion = testStringScanner(scanner, 1);
					if(repQuestion == 0) {
						annonceEquipement();
					}
					break;
				}
			}
			else if(choixEquipement == 7) {
				personnage.accesInventaire();
				annonceEquipement();				
			}
			else if(choixEquipement > 8 || choixEquipement < 1) {
				annonceEquipement();
			}
			else {
					System.out.println("Quel matiériau désires-tu pour ton armement : \n"
					+"du bois (5) pour 5 pièces d'or ? \n"
					+"du fer (10) pour 10 pièces d'or ? \n"
					+"de l'acier (20) pour 20 pièces d'or ? \n"
					+"de l'acier-argent (30) pour 30 pièces d'or ? \n"
					+"du Galvorn (60) pour 60 pièces d'or ? \n"
					+"du Mithril (90) pour 90 pièces d'or ? \n \n"
					+"Entre le numéro de ton choix entre parenthèses ou (1) pour revenir en arrière. \n"
					+">");
					
			int choixMateriau = testStringScanner(scanner, 1);
			if (choixMateriau == 1) {
				annonceEquipement();
			}
			else if(choixMateriau > personnage.or) {
				System.out.println("Je crains que tu n'aies pas assez de pièces d'or pour cet achât.");
				annonceEquipement();
			}
			else if(choixMateriau == 5 || choixMateriau == 10 || choixMateriau == 20 || choixMateriau == 30 || choixMateriau == 60 || choixMateriau == 90) {
				switch(choixEquipement) {
				case (1):					
					if(personnage.ajoutInventaire(new Couteau(choixMateriau)) == false) {
						System.out.println("Il y n'a plus de place dans ton inventaire.");
						annonceEquipement();
					}
					personnage.or -= choixMateriau;
					break;
				case (2):
					if(personnage.ajoutInventaire(new Hache(choixMateriau)) == false) {
						System.out.println("Il y n'a plus de place dans ton inventaire.");
						annonceEquipement();
					}
					personnage.or -= choixMateriau;
					break;
				case (3):
					if(personnage.ajoutInventaire(new Marteau(choixMateriau)) == false) {
						System.out.println("Il y n'a plus de place dans ton inventaire.");
						annonceEquipement();
					}
					personnage.or -= choixMateriau;
					break;
				case (4):
					if(personnage.ajoutInventaire(new Armure(choixMateriau)) == false) {
						System.out.println("Il y n'a plus de place dans ton inventaire.");
						annonceEquipement();
					}
					personnage.or -= choixMateriau;
					break;
				}
				System.out.println("Veux-tu poursuivre tes achâts dans notre Taverne (0/1) ? \n"
						+">");
				int repQuestion2 = testStringScanner(scanner, 1);
				if(repQuestion2 == 0) {
					annonceEquipement();
				}
				else {
					System.out.println("Tu sors de la Taverne pour t'engouffrer dans la pénombre du Donjon d'Hildur.");
					partie();
				}
			}
			else {
				System.out.println("Tu as essayé de me voler ! Fous-le camp de ma Tarverne Nain Bécil !");
				break;
			}			
		}
		}		
	}
	//Boucle infinie sur laquelle repose le Jeu et les choix principaux dans le Jeu
	protected void partie() {
		while(true) {
			donjon.affiche();
			System.out.println("Tu es dans le Donjon D'Hildur. Que veux-tu faire : \n"
					+"(1) te déplacer \n"
					+"(2) accéder à ton iventaire \n"
					+"(3) utiliser ton pouvoir \n"
					+"(4) voir ton profil \n"
					+ ">");
			int rep = testStringScanner(scanner, 0);
			if(rep == 1) {
				donjon.deplacement(this);
				partie();
			}
			else if(rep == 2) {
				personnage.accesInventaire();
				partie();
			}
			else if(rep == 3) {
				personnage.aptitudeDeClasse();
				partie();
			}
			else if(rep == 4) {
				System.out.println(personnage.profil());
				partie();
			}
			else {
				System.out.println("Erreur de saisie, recommence Nain.");
				partie();
			}
		}
	}
	
	protected void gameOver() {
		System.out.println("  ____    _    __  __ _____    _____     _______ ____  \n"
				+ " / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ \n"
				+ "| |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |\n"
				+ "| |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < \n"
				+ " \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\");
		System.out.println("Veux-tu tenter ta chance avec une autre partie (0/1) ? \n"
				+ ">");
		int rep = testStringScanner(scanner, 1);
		if(rep == 0) {
			Jeu j = new Jeu(tailleDonjon);
		}
		else {
			System.out.println("Aurevoir.");
			System.exit(0);
		}
	}
	
	protected void theEnd() {
		System.out.println(" _____ _   _ _____   _____ _   _ ____  \n"
				+ "|_   _| | | | ____| | ____| \\ | |  _ \\ \n"
				+ "  | | | |_| |  _|   |  _| |  \\| | | | |\n"
				+ "  | | |  _  | |___  | |___| |\\  | |_| |\n"
				+ "  |_| |_| |_|_____| |_____|_| \\_|____/ ");
		System.out.println("\n"
				+ "> Merci d'avoir joué à Dwarf RPG \n"
				+ "> Projet réalisé par Vincent RODRIGUEZ.");
		System.exit(0);
	}
}
