package Dwarf_RPG;

public abstract class Arme extends Equipement {
	
	Arme(double prix) {
		super(prix);
		super.degats = prix;
	}
}
