package Dwarf_RPG;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TestScanner {
	//Classe qui permet d'utiliser la fonction testStringScanner dans plusieurs classes
	//Cette fonction permet d'éviter les erreurs en testant si ce qui est entré dans le Scanner est bien un String
	//Sinon elle retourne un int par défaut entré en paramètres.
	public int testStringScanner(Scanner scanner, int intParDefaut) {
		int intRetour;
		if (scanner.hasNext(Pattern.compile("[a-zAZ]"))) {
			String poubelleString = scanner.nextLine(); //supprime l'erreur de saisie du Scanner
			intRetour = intParDefaut;
		}
		else {
			intRetour = scanner.nextInt();
		}
		return intRetour;
	}
}
