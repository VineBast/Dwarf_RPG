# Dwarf_RPG
> Vincent RODRIGUEZ
## Jeu RPG dans le terminal :

**Introduction à Dwarf_RPG :**
* C'est un RPG en terminal classique dans un univers **Tolkenien**. Vous y incarnerez un Nain qui fait son entrée dans le Donjon d'**Hildur**.
* Vous avez le choix entre 4 classes : Guerrier, Guérisseur, Maître des Runes, Mineur ou une classe cachée.
* Le bestiaire se compose de : Gobelins (faible créature), Wargs (moyenne créature), de Trolls (forte créature) et d'un Boss qui est très puissant.
* Vous commencez en bas à gauche sur une carte carrée. Le but du jeu est de vaincre le boss en haut à droite et de sortir du Donjon.

**Fonctionnement IG :**
* La majorité des choix ont pour réponse Oui ou Non, avec 0 pour Oui et 1 pour Non.
* Pour avancer dans le Donjon il vous sera demander d'entrer Z, Q, S ou D comme un jeu classique.
* Parfois, mais rarement, il faudra entrer des lettres en majuscules (tout est expliqué).
* Il y a des pouvoirs propre à chaque classe, un système d'expérience et de niveaux, des Coffres et des Taverniers dans le Donjon.

**Choix personnels d'optimisation :**
* Dans un premier temps, il était possible de fuir après chaque attaque, et donc revenir dans le terminal à chauqe fois. Cela ajoutait beaucoup de lourdeur, j'ai donc fait le choix de jouer les combats automatique avec une boucle pour gagner en fluidité (parfois on fait face à 50 tours). Il est toujours possible de fuir, ou de revenir en arrière mais **avant** d'engager l'action ou le combat. Dans le cas du combat, il est annoncé le type de monstre auquel on fait face avant de prendre une décision.
* Les déplacements dans le Donjon se font avec des suppressions et des ajouts d'Objets Destructibles dans un Tableau à deux dimensions. Ainsi, j'ai créé un Objet Destructible Curseur qui a comme unique but de prendre la place d'un autre Destructible (Monstre, Tavernier ou Coffre) pour savoir où on se trouve.

**Améliorations possibles (et envisagées) :**
* La classe Monstre est très simpliste, j'aurais pu créer de nouvelles classes héritées pour chaque Monstre et leur donner des fonctions particulières.
* Améliorer le système de leveling, qui est basique.
* Il y a aussi certaines exceptions avec des réponses erronées (comme des String entrés à la place de int) qui n'ont pas été géré.
