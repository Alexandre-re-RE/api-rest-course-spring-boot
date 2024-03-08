---
sidebar_position: 3
title: Déploiement
---

import Tabs from '@theme/Tabs';
import TabItem from '@theme/TabItem';
import Admonition from '@theme/Admonition';

# Déploiement


Le déploiement  consiste à initialisé le conteneur docker sur votre machine gérant la contenerisation.

:::danger[Attention]

Les partits suivantes doivent déjà être réalisé surtout le clonage ou l'accées au sources car nous aurons besoins du fichier **docker-compose.yml** et du dossier **./docker** [`Installation`](/).

:::

<Tabs groupId="cicd-pipelines">
  <TabItem value="jenkins" label="Jenkins">
    Pour un déploiement **Jenkins** il faut décommenter dans le fichier **docker-compose.yml** les partits concerant jenkins.

    ![Code security and analysis link](/assets/jenkins_docker_compose.png)

    Commande de déploiemnt du container.
    
    ```cmd
    docker compose up --build -d
    ```

    <Admonition type="tip" icon="💡" title="Done">
        Une fois configuré il vous reste juste à lancer la `commande de déploiement`.
    </Admonition>

    #### Commande de déploiement.
    
    ```cmd
    docker compose up --build -d
    ```
    
  </TabItem>
  <TabItem value="github" label="Github Action">
    


    <Admonition type="tip" icon="💡" title="Done">
        Pour un déploiement Github Action vous n'avez rien à faire il faut juste lancer la `commande de déploiement`.
    </Admonition>

    #### Commande de déploiement.

    ```cmd
    docker compose up --build -d
    ```

  </TabItem>
</Tabs>