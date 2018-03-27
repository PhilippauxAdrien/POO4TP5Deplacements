# POO4TP5Deplacements

## Enoncé

### Contexte

Une organisation de promotion des modes de déplacement doux souhaite aider les citoyens à améliorer
leur bilan carbone. Pour cela, suivant la devise “Ce qui ne se mesure pas ne s’améliore pas”, elle
souhaite proposer, à terme, une application sur téléphone, permettant, au jour le jour, d’enregistrer
rapidement deux indicateurs quotidiens :
- Aujourd'hui est-il un jour travaillé ou vaqué ?
- Quel a été mon mode de déplacement principal ?

Pour cela, elle fait appel à vos services pour développer une application qui permettra d'enregistrer
toutes les mesures faites par les usagers, mais aussi de fournir des données statistiques globales.
Le choix du SGBD n’est pas fait, il est donc nécessaire de concevoir une application pour laquelle le
changement de SGBD sera très facile à mettre en oeuvre.

Dans un premier temps, (Etape 1), l’application doit faire l’objet d’une maquette sous la forme d’une
application console java, avec une base de données embarquée Java DB.

Dans un second temps (Etape 2), la même application maquette doit être modifiée pour stocker les
données dans une base de données mySql, centralisée.

Dans un troisième temps, (Etape 3), l’application doit être portée en application web.

Dans un quatrième temps (Etape 4) , l’application sera portée sur Android.

Dans un dernier temps, l’application Android doit utiliser les ressources du téléphone pour renseigner la
base de données sans saisie utilisateur.

<b>Le présent TD a pour objet de réaliser les étapes 1 et 2.</b>

### Principe de l'application

Le principe de fonctionnement de l’application est le suivant:
Pour utiliser l’application, l’usager dispose d’un compte (identifiant) et d’un mot de passe. L’usager est
identifié de façon unique dans la base par son identifiant (email).

Chaque jour, l’application lui permet de saisir simplement les informations suivantes :
- Date du déplacement
- Jour travaillé (0/1) : 0= Non Travaillé, 1 = Travaillé
- Mode de déplacement (NUL, VOI, VEL, TRA, TEC, PIE) : NUL=Aucun déplacement,
VOI=Voiture, VEL=Vélo, TRA=Train, TEC=Transport en commun, PIE = marche à pied
- Distance parcourue

Chaque déplacement est identifié de façon unique dans la base, et est caractérisé par la date, le mode
de déplacement, la distance parcourue et s’il s’agit d’un jour travaillé ou non.

### Question 1

Dessiner le modèle UML correspondant à ces fonctionnalités.

### Question 2

En utilisant :
- la librairie JPA
- le Design Pattern DAO,
- le Design Pattern Factory,
- une base Java DB,

développer les classes métier permettant de développer l’application client, et une classe test
permettant de tester toutes les méthodes des classes métier. (Classe de test : <b>test1</b> )

NB : toutes les méthodes du CRUD et d’accès aux données doivent être testées dans l’application test1.

### Question 3

Développer les classes permettant d’accéder à une base de données mySql via JDBC en respectant
toujours le Design Pattern DAO

Développer une classe de test permettant de tester toutes les méthodes de ces classes,l’application
console permettant de tester les classes métiers développées. (Classe de test : test2 )

NB : toutes les méthodes du CRUD et d’accès aux données doivent être testées dans l’application test.

### Question 4

Créer une base de données Oracle identique à celle créée dans MySql.

Quelles sont les évolutions à apporter au modèle de données ? Que doit-on mettre en place dans
Oracle pour utiliser vos classes de façon identique à l’utilisation dans mySql et Java DB ?

Copier les classes test1 et test2 et renommez les respectivement test3 et test4.

Tester test3 et test4 pour accéder à la base Oracle, d’une part avec JPA, d’autre part en JDBC.

### Question 5 (Bonus)

Créer une vue permettant de récupérer simplement les indicateurs suivants :
- Par mois
- Par utilisateur
- Par mode de déplacement
- Par type de jour (travaillé ou non)
- Nombre de kilomètres
- Nombre de déplacements

Mettre en place les classes nécessaires à l’exploitation de cette vue, mettre à jour les classes existantes
si nécessaires, et ajouter les tests prouvant leur bon fonctionnement dans les applications test1 (JPA)
et test2 (JDBC)

### Question 6 (Bonus)

Comment limiter simplement les valeurs possibles (T ou C) de la colonne TYPEJOUR de la table
événement dans mySql ?

Comment traiter les cas d’erreur retournés par mySql, dans le code JAVA ?

Comment traiter ces limitations de valeur dans le code Java ?

Quelle est la solution la plus intéressante / pérenne ?
