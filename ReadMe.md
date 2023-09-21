# Brève description du git! 
(le code source est basé sur le github [bfjava2023 par Flavian Ovyn](https://gitlab.com/fovyn/bfjava2023-spring))
 1. DockerFile
     Le dockerfile se base sur une l'image openjdk:20 et se charge de créer le fichier jar qui sera  
     ensuite utilisé pour lancer l'application spring
     
 2. Adaptation du fichier application.yml
     Afin de permettre d'utiliser les variables d'environnements, le fichier application.yml a été 
     modifié. 
  
  
 3. Docker-compose.yaml
	 3 services sont crées :
	          - db
		          basé sur l'image postgres:latest, le service
		             -  expose le port 5432 (nous pourrions ne pas le faire pour ne pas exposer le serveur 
		                db à l'extérieur de nos containers). 
		             - créé une base de données simpleAppDb grâce aux variables d'environnement
		             - définit le user et son mot de passe
		             - associe un volume pour les données (!!!Changez le volume pour qu'il puisse être 
		             - utilisés sur votre machine!!!)
	          - pgAdmin
			      basée sur l'image dpage/pgadmin4, le service :
			          - expose les ports 80 et 443 pour l'accès à l'outils
			          - définit le login et password pour l'utilisateur
	          - app
				  basé sur le dockerfile , le service :
				     - Expose le port 8080 (docker) sur le port 8081 du host
				     - Définit les variables d'environnement nécessaire à notre app spring

***Remarque***
la variable d'environnement SPRING_DATASOURCE_URL fait directement référence au service db pour obtenir l'adresse IP lors du compose up


# Comment l'utiliser!
Une fois le repository récupéré sur votre machine, rendez-vous dans le dossier du projet et lancez la commande 

    docker compose up

 
    



      
