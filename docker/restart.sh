#!/bin/bash

JAR_FILE="/home/expernet/app/api-rest.jar"

if pgrep -f "$JAR_FILE" >/dev/null; then
    echo "Arrêt du processus existant..."
    pkill -f "$JAR_FILE"
fi

# Démarrage du processus
echo "Démarrage du processus..."
java -jar "$JAR_FILE" &