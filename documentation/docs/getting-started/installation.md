---
sidebar_position: 1
title: Installation
slug: /
sidebar_class_name: green
---

import Tabs from '@theme/Tabs';
import TabItem from '@theme/TabItem';
import Admonition from '@theme/Admonition';

# Installation


## Prérequis

Pour pouvoir installer notre API, il est nécessaire de remplir certains prérequis techniques.

Voici ce dont vous aurez besoin :

- Créer un conteneur Docker : Docker est une plateforme open-source permettant de créer, déployer et exécuter des applications dans des conteneurs. Avant de pouvoir utiliser notre API, assurez-vous d'avoir Docker installé sur votre système. Si ce n'est pas déjà le cas, vous pouvez trouver des instructions d'installation sur le site officiel de [Docker](https://www.docker.com/).

- Avoir Git installé : Git est un système de contrôle de version qui facilite la collaboration et le suivi des modifications apportées au code source. Assurez-vous d'avoir Git installé sur votre machine. Si vous ne l'avez pas encore installé, vous pouvez le faire en suivant les instructions disponibles sur le site officiel de [Git](https://git-scm.com/).

- Posséder un compte GitHub : GitHub est une plateforme de développement collaboratif qui héberge le code source de nombreux projets open-source, y compris le nôtre. Si vous n'avez pas déjà un compte GitHub, vous pouvez en créer un gratuitement sur leur site [Github](https://pages.github.com/).

## Installation

Pour utiliser notre solution, vous devez cloner ou fork notre dépôt dans un dossier accessible à l'utilisateur disposant des droits d'exécution de Docker.

```bash
git clone https://github.com/Alexandre-re-RE/api-rest-course-spring-boot.git
```

### Fichier .env

Une fois installé, vous devrez créer votre fichier .env afin de fournir les informations nécessaires à la création du conteneur Docker, notamment un nom d'utilisateur, un mot de passe, et les ports à utiliser.

```bash
cp .env.example .env
```

Les valeurs suivantes doivent être présentes et renseignées dans le fichier .env.

<Tabs groupId="cicd-pipelines">
  <TabItem value="jenkins" label="Jenkins">

    | Clé                           | Valeur|
    | ----------------------------- | ----- |
    | APP_USER                      | L'utilisateur à utiliser dans le container |
    | APP_PASSWORD                  | Le mot de passe de l'utilisateur du conteneur |
    | API_EXPOSE_PORT               | Le port à utiliser pour exposer l'api rest par default(8083) |
    | SSH_EXPOSE_PORT               | Le port à utiliser pour exposer la connexion ssh au conteneur |
    | JENKINS_EXPORT_PORT_HTTP      | Le port exposer par le container jenkins |
    | JENKINS_EXPORT_PORT_WEBSOCKET | Le port à exposer pour le container jenkins webbsocket |
    
  </TabItem>

  <TabItem value="github" label="Github Action">
    | Clé                           | Valeur|
    | ----------------------------- | ----- |
    | APP_USER                      | L'utilisateur à utiliser dans le container |
    | APP_PASSWORD                  | Le mot de passe de l'utilisateur du conteneur |
    | API_EXPOSE_PORT               | Le port à utiliser pour exposer l'api rest par default(8083) |
    | SSH_EXPOSE_PORT               | Le port à utiliser pour exposer la connexion ssh au conteneur |

    <Admonition type="info" icon="💡" title="Information">
        Les clés suivantes sont omis `JENKINS_EXPORT_PORT_HTTP` `JENKINS_EXPORT_PORT_WEBSOCKET` pour la configuration Github actions.
    </Admonition>

  </TabItem>
</Tabs>

### Configuration    

<Tabs groupId="cicd-pipelines">
  <TabItem value="jenkins" label="Jenkins">
  
  </TabItem>
  <TabItem value="github" label="Github Action">
     Pour pouvoir utiliser la pipeline CI/CD après un fork, vous devrez configurer vos secrets dans votre dépôt en accédant à l'interface GitHub du projet forké.
     `Settings` > `Secrets and variables` > `Actions`.

     IL faudra rajouter les clés suivantes afin que lorsq'un événement de push arrive sur le repository il puisse mettre à jour l'API REST déploiyé.

     | Clé                           | Valeur|
    | ----------------------------- | ----- |
    | HOST                      | Adresse ip permettant de joindre le containeur docker |
    | PASSWORD                  | Le mot de passe de l'utilisateur du conteneur définit dans le fichier .env |
    | PORT               | Le port définit dans le fichier .env pour accéder au conteneur en SSH |
    | USERNAME               | Le nom d'utilisateur choisi pour le conteneur définit dans le fichier .env |

    **Exemple**.

    ![Code security and analysis link](/assets/github_secret_link.png)
  </TabItem>
</Tabs>

  :::tip[Configuration terminé]

  Maintenant votre pipeline CI/CD et configuré vous pouvez maintenant passer au [Déploiement de votre conteneur](./deployement.md).

  :::

