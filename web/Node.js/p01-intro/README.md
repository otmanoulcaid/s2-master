<!-- marck down -->
# Introduction à node.js
dans ce projet, nous allons introduire [Node.js](http://nodejs.org) ainsi que la notion de **module** l'ensemble de parametre de celui-ci est des differents objets globaux.

> ce fichier est ecrit avec le syntax `Markdown`, qui est un langage de balisage simple pour visuaiser le fichier on utilise `Ctrl+shift+V`

## Node.js est un environnement d'execution javascript cote serveur.

## execution pour executer un script .js  sous node.j on utilise la commande suivante : 
```
    > node exp01
```

## objects globaux
Certains objets globaux n'ayant pas de rapport avec l'environnement cote serveur n'ont pas d'existance sur node.js:
1. window
1. document

En contre partie, l'equivament de l'objet global window est l'objet dont le nom est : `global`, Cependant, les variable et fonction utilisateur ne sont pas definit dedans par defaut

## Modules Node.js 
Tous fichier `.js` est un module, chaque module dispose de 5 parametre lui permettant de communique avec les autres modules : 
| Object | Definition |
| ------ | ---------- |
| **module** | un object contenat l'ensemble des information sur le module |
| **export** | ou encore **module.exports** est un object permettant de contenir l'ensemble des donnee à exporter |
| **require** | Fonction permettant d'importer ce qui est exporter par un autre module |
| **__filename** | non de module ou fichier module |
| **__durname** | chemin du module |
