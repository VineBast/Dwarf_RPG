package Dwarf_RPG;

public class Couteau extends Arme {
	//static double prix = 4;
	static final double RATIO_COUTEAU= 1.1;
	
	
	Couteau(double prix) {
		super(prix);
	}
		
	public void attaque_monstre(Monstre m) {
		m.prendDesDegats(prix * MONSTRE_DEGAT_RATIO * RATIO_COUTEAU);
	}
	
	public String ascii_art() {
		return    "               .cd;...;l,               \n"
				+ "             ..':kOo,;:dOl.             \n"
				+ "              ..':l:,;:''.              \n"
				+ "                .:l:;::.                \n"
				+ "                'coc:cc.                \n"
				+ "                'ldoloo'                \n"
				+ "                ,dxdodd,                \n"
				+ "                ;dxdodx,                \n"
				+ "                ,dxolox,                \n"
				+ "                ':cxOxo'                \n"
				+ "              .''';clc;'..              \n"
				+ "              ..';l:;:ol'               \n"
				+ "               .,coc:lK0'               \n"
				+ "               .,coc:oK0,               \n"
				+ "               .':ol:oK0,               \n"
				+ "               .';llcdK0,               \n"
				+ "               .',clcdKO'               \n"
				+ "               .,,:lld0k.               \n"
				+ "               .,';cldOd.               \n"
				+ "               .,',:cldl.               \n"
				+ "               .,'':ccl:.               \n"
				+ "                .'';::;.                \n"
				+ "                 .',,'.    ";
	}
}
