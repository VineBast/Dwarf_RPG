package Dwarf_RPG;

public class Hache extends Arme {
	//static double prix = 5;
	static final double RATIO_HACHE = 1.1;
	
	Hache(double prix) {
		super(prix);
	}
	
	public String typeEquipement() {
		return("Hache");
	}
	
	public void attaque_monstre(Monstre m) {
		m.prendDesDegats(prix * MONSTRE_DEGAT_RATIO * RATIO_HACHE);
	}
	
	public String ascii_art() {
		return    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXKNMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXxlkNMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNWMMMMMMMMMXx:,cONMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWOclO0kdx00K0d:',,:kXMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMW0l,;;;'',;;;;',,,,':kNMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMKd:;,,;,,,,,;;,;;,'ckNMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXo:xNx,':o0Kc..'':ONMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMMO;'l0Xd...',l0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO;'o0Xo...,dKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO:'o0XXOOOKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM0:,o0XMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO:,o0XMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXd;,:oOWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXl;;;:xWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO:,cxKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO:'ckKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO:,ckXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO:,ckXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO:,ckKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO:'ckXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO:'ckKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO;'ckXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO;.ckKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO;.ckKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO;.ckKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO;.ckKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO;':xKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXl,,;cxNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXx:,:oOWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0xKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM";
				
	}
}
