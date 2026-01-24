#!/bin/sh

echo "\033[32mcompiling...\033[0m"
javac -d bin *.java

echo "\033[33mtesting the app...\033[0m"
sleep 2

echo "\033[34mpackaging the app...\033[0m"

echo "Main-Class: Hello" > bin/Manifest.mf
jar cfm app.jar bin/Manifest.mf -C bin .

mkdir -p target && mv app.jar target
java -jar target/app.jar
