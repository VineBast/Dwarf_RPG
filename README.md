# Dwarf_RPG
> Vincent RODRIGUEZ
## Jeu RPG dans le terminal :

**Introduction à Dwarf_RPG :**
* C'est un RPG en terminal classique dans un univers **Tolkenien**. Vous y incarnerez un Nain qui fait son entrée dans le Donjon d'**Hildur**.
* Vous avez le choix entre 4 classes : Guerrier, Guérisseur, Maître des Runes, Mineur ou une classe cachée.
* Le bestiaire se compose de : Gobelins (faible créature), Wargs (moyenne créature), de Trolls (forte créature) et d'un Boss, le **Dragon d'Hildur** qui est très puissant.
* Vous commencez en bas à gauche sur une carte carrée. Le but du jeu est de vaincre le boss en haut à droite et de sortir du Donjon.
* Pour faire varier la taille du Donjon, allez dans `Jeu.java`, et inscriver la taille souhaitée dans `new Jeu(4)`. Le chiffre correspond à la largeur du donjon.

**Fonctionnement IG :**
* La majorité des choix ont pour réponse Oui ou Non, avec `0` pour Oui, et `1` pour Non.
* Pour avancer dans le Donjon il vous sera demandé d'entrer `Z`, `Q`, `S` ou `D` comme un jeu classique.
* Parfois, mais rarement, il faudra entrer des lettres en majuscules (tout est expliqué).
* Il y a des pouvoirs propre à chaque classe (avec un système de mana), un système d'expérience et de niveaux, des Coffres, des Monstres et des Taverniers dans le Donjon.

**Choix personnels d'optimisation :**
* Dans un premier temps, il était possible de fuir après chaque attaque, et donc de revenir dans le terminal entre chaque action. Cela ajoutant beaucoup de lourdeur, j'ai fait le choix de jouer les combats automatique avec une boucle pour gagner en fluidité (parfois on fait face à 50 tours). Il est toujours possible de fuir, ou de revenir en arrière mais **avant** d'engager l'action ou le combat. Dans le cas du combat, il est annoncé le type de monstre auquel on fait face avant de prendre une décision.
* Les Tarveniers permettent 3 actions, on peut soit revenir sur ses **pas** (ne pas avancer de case), soit passer son **chemin** ce qui fera disparaitre le Tarvenier (et avancer d'une case), soit faire des **emplettes** pour faire un achât (dans ce cas le Tavernier sera à nouveau accessible).
* Les déplacements dans le Donjon se font avec des suppressions et des ajouts d'Objets Destructibles dans un Tableau à deux dimensions. Ainsi, j'ai créé un Objet Destructible Curseur qui a comme unique but de prendre la place d'un autre Destructible (Monstre, Tavernier ou Coffre) pour savoir où on se trouve.
* La Taverne, ou le Magasin d'Equipement n'est pas une classe à part, elle fait partie de la classe Jeu, la classe principale. Je trouvais cette façon de faire plus simple au niveau du codage.

**Améliorations possibles (et envisagées) :**
* La classe Monstre est très simpliste, j'aurais pu créer de nouvelles classes héritées pour chaque Monstre et leur donner des fonctions particulières.
* Améliorer le système de leveling, qui est basique.
* Un peu mieux équilibrer le jeu en général au niveau du nombre de monstres (et leur niveau), de coffres et de taverniers.
* Il y a aussi certaines exceptions avec des réponses erronées (les caractères spéciaux à la place d'un int par exemple) qui n'ont pas été géré.
