#!/bin/sh

echo "\033[33mCompilation de la bibliothèque parser-lib...\033[0m"

cd mql-parser > /dev/null 2>&1 || exit 1
mvn clean install || exit 2

echo "\033[34mparser-lib installée localement avec succès.\033[0m"

echo "\033[35mCompilation et packaging de student-manager...\033[0m"
cd ../student-management > /dev/null 2>&1 || exit 3
mvn clean package  || exit 4

echo "\033[32mBuild terminé avec succès.\033[0m"
