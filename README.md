# Back MSPR

L'application Back MSPR est une API permettant de récupérer les différentes données nécessaires pour l'application mobile.

Les routes sont documentées via Swagger et sont accessibles à cette URL : [localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

## Installation de l'application

1. **Créer la base de données via Docker**  
   Utilisez la commande suivante :
   ```bash
   docker compose up
   ```
2. **Lancer l'application**
L'initialisation de la base de données se fera automatiquement via les migrations.

## Création d'une migration
Pour créer une migration, rendez-vous dans le dossier ressource/bdd/migrations. Des migrations existent déjà à cet emplacement. Pour en créer une nouvelle, vous devez ajouter un nouveau fichier SQL contenant les instructions en langage SQL permettant de modifier la base de données.

## Déploiement de l'application
Grâce à notre fichier **'DockerFile'**, nous pouvons facilement déployer l'application sur un cloud pour créer notre container Docker. Actuellement, ce n'est pas encore fait, mais nous pourrions le faire grâce à ce fichier.

## Modification du port de l'application

Le port de l'application peut être modifié dans le fichier `ressource/application.properties`. 

Pour changer le port, ouvrez le fichier `ressource/application.properties` et modifiez la valeur de la variable `server.port`. Par exemple, pour définir le port à 9090, ajoutez ou modifiez la ligne suivante :

```properties
server.port=9090
