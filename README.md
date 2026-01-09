# Calculatrice Java Swing +(TD travail de cours)

Une calculatrice graphique moderne développée en Java avec Swing, suivant le pattern MVC (Modèle-Vue-Contrôleur).

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)

## Fonctionnalités

- Opérations de base : addition, soustraction, multiplication, division
- Fonction pourcentage (%)
- Changement de signe (±)
- Support des nombres décimaux
- Historique des calculs persistant (sauvegardé dans un fichier)
- Interface graphique moderne avec thème sombre
- Support du clavier (touches numériques et opérateurs)
- Gestion des erreurs (division par zéro)
- Affichage de l'expression complète en cours

## Architecture

Le projet suit le pattern **MVC** (Modèle-Vue-Contrôleur) :

```
Calc/
├── Main.java              # Point d'entrée de l'application
├── Calculatrice.java      # Modèle - Logique de calcul
├── CalculatriceVue.java   # Vue - Interface graphique Swing
├── historique.txt         # Fichier de persistance de l'historique
└── README.md              # Documentation
```

### Classes

| Classe | Rôle |
|--------|------|
| `Main` | Lance l'application et initialise le modèle et la vue |
| `Calculatrice` | Gère toute la logique de calcul, l'historique et les notifications |
| `CalculatriceVue` | Interface graphique Swing, écoute les changements du modèle |

## Utilisation

### Prérequis

- Java JDK 8 ou supérieur

### Compilation

```bash
cd Calc
javac *.java
```

### Exécution

```bash
java Main
```

## Raccourcis clavier

| Touche | Action |
|--------|--------|
| `0-9` | Saisie des chiffres |
| `+` | Addition |
| `-` | Soustraction |
| `*` | Multiplication |
| `/` | Division |
| `.` | Point décimal |
| `Enter` | Calculer le résultat |
| `Backspace` | Effacer le dernier caractère |
| `Escape` | Effacer tout (C) |

## Interface

L'interface utilise un thème sombre moderne avec les caractéristiques suivantes :

- **Couleur de fond** : Gris foncé (`#1a1a1f`)
- **Accent** : Violet (`#9d4edd`)
- **Boutons** : Style arrondi avec effet hover
- **Historique** : Panel latéral avec liste scrollable

## Historique

L'historique des calculs est automatiquement sauvegardé dans le fichier `historique.txt` et rechargé au démarrage de l'application.

Pour effacer l'historique, utilisez le bouton "Effacer" dans le panel d'historique.

## Développement

### Pattern Observer

La classe `Calculatrice` utilise un pattern Observer via l'interface `CalculatriceListener` pour notifier la vue des changements :

```java
public interface CalculatriceListener {
    void onDisplayChanged(String value);
    void onExpressionChanged(String expression);
    void onHistoryAdded(String entry);
}
```

### Principe de responsabilité unique (SRP)

- `Calculatrice` : Uniquement la logique métier
- `CalculatriceVue` : Uniquement l'affichage et les interactions utilisateur

## Licence

Ce projet est un exercice pédagogique.
